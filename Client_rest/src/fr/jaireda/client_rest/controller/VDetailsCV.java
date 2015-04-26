package fr.jaireda.client_rest.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import fr.jaireda.client_rest.R;
import fr.jaireda.client_rest.model.CV;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class VDetailsCV extends Activity{
	public final static String SERVER_URL="http://restserver-jaireda.rhcloud.com/REST_SERVER-0.3/rest/descvs/";
	public CV uncv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.un_cv);
		
		ActionBar.Tab Tab1, Tab2, Tab3, Tab4;
		   
	    Fragment fragmentTab1=new IdentiteTab();
	    Fragment fragmentTab2=new CursusTab();
	    Fragment fragmentTab3=new CompetencesTab();
	    Fragment fragmentTab4=new LoisisrsTab();
	    
	    ActionBar actionBar = getActionBar();
	    
        // Hide Actionbar Icon
        actionBar.setDisplayShowHomeEnabled(false);
 
        // Hide Actionbar Title
        actionBar.setDisplayShowTitleEnabled(false);
 
        // Create Actionbar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
 
        // Set Tab Icon and Titles
        Tab1 = actionBar.newTab().setText(getString(R.string.identity_tab));
        Tab2 = actionBar.newTab().setText(getString(R.string.cursus_tab));
        Tab3 = actionBar.newTab().setText(getString(R.string.competences_tab));
        Tab4 = actionBar.newTab().setText(getString(R.string.competences_tab));
 
        // Set Tab Listeners
        Tab1.setTabListener(new TabListener(fragmentTab1));
        Tab2.setTabListener(new TabListener(fragmentTab2));
        Tab3.setTabListener(new TabListener(fragmentTab3));
        Tab4.setTabListener(new TabListener(fragmentTab4));
        
        // Add tabs to actionbar
        
        actionBar.addTab(Tab1);
        actionBar.addTab(Tab2);
        actionBar.addTab(Tab3);
        actionBar.addTab(Tab4);
        
        
        //récupération de l'id du cv à  afficher, passé en extra
        Intent in=getIntent();
        int idcv=in.getIntExtra("idcv", 0);
        
        Log.i("details cv", "id cv="+idcv);
        
        
        try {
        	//récupération du cv en utilisant get/{id}
			uncv=new getCVById().execute(idcv).get();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
        
        //remplissage des zones de texte
        Gson gs=new Gson();
        
        
        in.putExtra("uncv", gs.toJson(uncv));
        Bundle bn=new Bundle();
        bn.putSerializable("uncv", uncv);
        bn.putString("mode", "view");
        fragmentTab1.setArguments(bn);
        fragmentTab2.setArguments(bn);
        fragmentTab3.setArguments(bn);
        fragmentTab4.setArguments(bn);
	}
	class getCVById extends AsyncTask<Integer, Void,CV> {

        private Exception exception;

        protected CV doInBackground(Integer...idCV) {
        	final String url = SERVER_URL+""+(int)idCV[0];

        	System.out.println("url= "+url);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());

            CV cv=restTemplate.getForObject(url, CV.class);
            System.out.println(cv.toString());
            return cv;
           
        }

        protected void onPostExecute() {
            
        }
    }
}
