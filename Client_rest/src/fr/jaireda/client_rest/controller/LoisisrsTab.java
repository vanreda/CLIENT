package fr.jaireda.client_rest.controller;


import java.util.ArrayList;

import fr.jaireda.client_rest.R;
import fr.jaireda.client_rest.model.CV;
import fr.jaireda.client_rest.model.Langue;
import fr.jaireda.client_rest.model.Loisir;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class LoisisrsTab extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View inflatedView= inflater.inflate(R.layout.loisirs_frag, container, false);
		
		String mode="";
		EditText loisir_tb, langue_tb, niveau_tb;
		
		loisir_tb=(EditText)inflatedView.findViewById(R.id.loisir_tbt);
		langue_tb=(EditText)inflatedView.findViewById(R.id.langue_tbt);
		niveau_tb=(EditText)inflatedView.findViewById(R.id.niveau_tbt);
		
		
		Bundle bn=getArguments();
		CV uncv=(CV) bn.get("uncv");
		mode=bn.getString("mode");
		
		if(mode=="view"){
			loisir_tb.setEnabled(false);
			langue_tb.setEnabled(false);
			niveau_tb.setEnabled(false);
			
		}
		
		
		
		ArrayList<Loisir> loisirs=new ArrayList<Loisir>();
		loisirs.add(new Loisir("DJing"));
		uncv.setLoisirs(loisirs);
		
		
		ArrayList<Langue> langues=new ArrayList<Langue>();
		langues.add(new Langue("anglais", 10));
		uncv.setLangues(langues);
		Toast.makeText(getActivity(), "des données fictives sont ajoutées !", Toast.LENGTH_LONG).show();
		
		loisir_tb.setText(uncv.getLoisirs().get(0).getLoisir());
		langue_tb.setText(uncv.getLangues().get(0).getNom());
		niveau_tb.setText(uncv.getLangues().get(0).getNiveau()+" ");
		
		
		System.out.println("identite tab, received tab"+ uncv.toString());
		
		return inflatedView;
	}
	
}
