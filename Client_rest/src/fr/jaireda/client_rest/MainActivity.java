package fr.jaireda.client_rest;




import java.util.concurrent.ExecutionException;

import javax.xml.parsers.SAXParserFactory;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.core.Persister;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import fr.jaireda.client_rest.*;
import fr.jaireda.client_rest.controller.Utils;
import fr.jaireda.client_rest.model.ArrayAdapter;
import fr.jaireda.client_rest.model.CV;
import fr.jaireda.client_rest.model.CVsManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends Activity {
	public final static String SERVER_URL="http://restserver-jaireda.rhcloud.com/REST_SERVER-0.3/rest/descvs";
	private ListView vList;
	private ProgressBar PBar;
	public CVsManager cvs;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        vList=(ListView)findViewById(R.id.lvListe);
        
		PBar=(ProgressBar)findViewById(R.id.progressBar1);
		PBar.setVisibility(View.GONE);
        
		 try {
			this.cvs= new getAllCVs().execute().get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), cvs); 
		vList.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		
		
       /* String str="<point><x>10</x><y>4</y></point>";
        
        String strcv="<cv><identite><adresse>worclaw</adresse><nom>noise</nom><prenom>indecent</prenom><tel>88990011</tel></identite><titre>Mr</titre></cv>";
        
        String cvarray=
        		"<listedeCVs><cv><identite><adresse>saint aignant</adresse><nom>Reda</nom><prenom>JAI</prenom><tel>002255447</tel></identite><titre>Mr</titre></cv><cv><identite><adresse>leinden</adresse><nom>van buuren</nom><prenom>armin</prenom><tel>00112233</tel></identite><titre>Mr</titre></cv></listedeCVs>";;
        
        Serializer deserialser=new Persister();
        
        try {
        	
        	System.out.println("deserialising "+cvarray);
			CVsManager cv=deserialser.read(CVsManager.class, cvarray);
			System.out.println(cv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
        
        
        
        
        /*try {
        	
        	System.out.println("deserialising "+str);
			Point p=deserialser.read(Point.class, str);
			System.out.println(p.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        Point p2=new Point(50, 60);*/

        
        //new RetrieveFeedTask().execute();
       
        
        //new getAllCVs().execute();
        
    }


    @Override
    public void onStart() {
        super.onStart();
        
        
    }
    
    class RetrieveFeedTask extends AsyncTask<String, Void,CV> {

        private Exception exception;

        protected CV doInBackground(String... urls) {
        	final String url = SERVER_URL+"/2";

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());

            CV cv=restTemplate.getForObject(url, CV.class);
            System.out.println(cv.toString());
            return cv;
           
        }

        protected void onPostExecute() {
            
        }
    }
    class getAllCVs extends AsyncTask<String, Integer,CVsManager> {

        private Exception exception;

        protected CVsManager doInBackground(String... urls) {
        	

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
            
            CVsManager cvs=restTemplate.getForObject(SERVER_URL, CVsManager.class);
            
            //.cvs=restTemplate.getForObject(SERVER_URL, CVsManager.class);
            System.out.println(cvs.toString());
            return cvs;
           
        }

       
        @Override
		protected void onPostExecute(CVsManager result) {
        	PBar.setVisibility(View.GONE);
			super.onPostExecute(result);
		}


		@Override
		protected void onProgressUpdate(Integer... values) {
			PBar.setProgress(values[0]);
		}

		@Override
		protected void onPreExecute() {
			PBar.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}
        
        
    }
}
