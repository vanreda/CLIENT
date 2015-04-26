package fr.jaireda.client_rest.controller;


import fr.jaireda.client_rest.MainActivity;
import fr.jaireda.client_rest.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch_activity);

		Button bt1,bt2, bt3;


		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);


		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(!isConnected()){
					Toast.makeText(getBaseContext(), "Veuillez vous connecter à internet", Toast.LENGTH_LONG).show();
					return;
				}
				Intent in=new Intent(getBaseContext(), MainActivity.class);
				startActivity(in);

			}
		});


		bt2.setOnClickListener(new OnClickListener() {
			
			
			EditText input = new EditText(LaunchActivity.this);

			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(LaunchActivity.this)
				.setTitle("Identifiant CV")
				.setMessage("Veuillez entrer l'identifiant du CV à afficher")
				.setView(input)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						String value = input.getText().toString();
						
						if(!isConnected()){
							Toast.makeText(getBaseContext(), "Veuillez vous connecter à internet", Toast.LENGTH_LONG).show();
							return;
						}
						
						
						if(value.matches("[+-]?\\d*(\\.\\d+)?")){
							Intent in=new Intent(getBaseContext(), VDetailsCV.class);
							in.putExtra("idcv", value);
							startActivity(in);
						}else {
							Toast.makeText(getBaseContext(), "Veuillez entre un entier",Toast.LENGTH_LONG).show();
						}

					}
				}).show();

			}
		});


		bt3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(!isConnected()){
					Toast.makeText(getBaseContext(), "Veuillez vous connecter à internet", Toast.LENGTH_LONG).show();
					return;
				}
				Intent in=new Intent(getBaseContext(), RedigerCV.class);
				startActivity(in);

			}
		});

	}
	public boolean isConnected(){
		ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) 
			return true;
		else
			return false;    
	}
}
