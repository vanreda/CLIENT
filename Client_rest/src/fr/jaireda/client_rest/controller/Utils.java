package fr.jaireda.client_rest.controller;

import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.AsyncTask;
import fr.jaireda.client_rest.model.CVsManager;

public class Utils {
	public final static String SERVER_URL="http://restserver-jaireda.rhcloud.com/REST_SERVER-0.2/rest/descvs";
	
	 class getAllCVs extends AsyncTask<String, Void,CVsManager> {

	        private Exception exception;

	        protected CVsManager doInBackground(String... urls) {
	        	

	            RestTemplate restTemplate = new RestTemplate();
	            restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());

	            CVsManager cvs=restTemplate.getForObject(SERVER_URL, CVsManager.class);
	            
	            
	            System.out.println(cvs.toString());
	            return cvs;
	           
	        }

	        protected void onPostExecute() {
	            // TODO: check this.exception 
	            // TODO: do something with the feed
	        }
	    }
}
