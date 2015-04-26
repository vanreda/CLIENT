package fr.jaireda.client_rest.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HTTP;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import fr.jaireda.client_rest.MainActivity;
import fr.jaireda.client_rest.R;
import fr.jaireda.client_rest.model.CV;
import fr.jaireda.client_rest.model.CVsManager;
import fr.jaireda.client_rest.model.Personne;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml.Encoding;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RedigerCV extends Activity{

	Button post_btn, abort_btn;
	EditText nom_tb, prenom_tb, adresse_tb, tel_tb;
	final static String SERVER_URL="http://restserver-jaireda.rhcloud.com/REST_SERVER-0.3/rest/descvs";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_cv);

		post_btn=(Button)findViewById(R.id.button1);
		abort_btn=(Button)findViewById(R.id.button2);

		nom_tb=(EditText)findViewById(R.id.nom_tbt);
		prenom_tb=(EditText)findViewById(R.id.prenom_tbt);
		adresse_tb=(EditText)findViewById(R.id.adresse_tbt);
		tel_tb=(EditText)findViewById(R.id.tel_tbt);


		post_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CV uncv=new CV();

				String nom="", prenom="", tel="", adresse="";
				nom=nom_tb.getText().toString();
				prenom=prenom_tb.getText().toString();
				tel=tel_tb.getText().toString();
				adresse=adresse_tb.getText().toString();

				if(nom.equals("") || prenom.equals("") || tel.equals("") || adresse.equals("")){
					Toast.makeText(getBaseContext(), "Veuillez remplir le formulaire d'identité !", Toast.LENGTH_LONG).show();
					return;
				}
				uncv.setIdentite(new Personne(tel, adresse, prenom, nom));
				Log.i("post request","sending "+uncv.toString());

				Serializer deserialser=new Persister();
				try {
					File sdCard = Environment.getExternalStorageDirectory();
					File dir = new File (sdCard.getAbsolutePath() + "/REST_Client/files");
					dir.mkdirs();
					File file = new File(dir, "file.xml");
					deserialser.write(uncv, file);

					System.out.println("check ?"+getStringFromFile(file.getCanonicalPath()));
					
					new do_POST().execute(file);


					Intent in=new Intent(getApplicationContext(), MainActivity.class);
					startActivity(in);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		abort_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent in=new Intent(getBaseContext(), MainActivity.class);
				startActivity(in);
			}
		});


	}

	public static String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
		}
		reader.close();
		return sb.toString();
	}

	public static String getStringFromFile (String filePath) throws Exception {
		File fl = new File(filePath);
		FileInputStream fin = new FileInputStream(fl);
		String ret = convertStreamToString(fin);
		//Make sure you close all streams.
		fin.close();        
		return ret;
	}
	public void postData(File file) {
		HttpClient httpclient = new DefaultHttpClient();  
		HttpPost httppost = new HttpPost(SERVER_URL); 

		StringEntity se;
		try {
			se = new StringEntity(getStringFromFile(file.getCanonicalPath()),HTTP.UTF_8);
			se.setContentType("text/xml"); 
			httppost.setHeader("Content-Type","application/soap+xml;charset=UTF-8");
			httppost.setEntity(se);

			BasicHttpResponse httpResponse = (BasicHttpResponse) httpclient .execute(httppost);

			System.out.println(httpResponse.getStatusLine().toString());
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} 

	} 	
	class do_POST extends AsyncTask<File, Integer,Void> {

		private Exception exception;

		protected Void doInBackground(File... params) {


			postData(params[0]);
			return null ;

		}




	}
}
