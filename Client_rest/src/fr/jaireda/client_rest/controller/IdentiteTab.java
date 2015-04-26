package fr.jaireda.client_rest.controller;

import fr.jaireda.client_rest.R;
import fr.jaireda.client_rest.model.CV;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
public class IdentiteTab extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View inflatedView= inflater.inflate(R.layout.identity_frag, container, false);
		String mode="";
		EditText nom_tb, prenom_tb, adresse_tb, tel_tb;
		
		nom_tb=(EditText)inflatedView.findViewById(R.id.nom_tbt);
		prenom_tb=(EditText)inflatedView.findViewById(R.id.prenom_tbt);
		adresse_tb=(EditText)inflatedView.findViewById(R.id.adresse_tbt);
		tel_tb=(EditText)inflatedView.findViewById(R.id.tel_tbt);
		
		Bundle bn=getArguments();
		CV uncv=(CV) bn.get("uncv");
		mode=bn.getString("mode");
		
		if(mode=="view"){
			nom_tb.setEnabled(false);
			prenom_tb.setEnabled(false);
			adresse_tb.setEnabled(false);
			tel_tb.setEnabled(false);
		}
		
		
		nom_tb.setText(uncv.getIdentite().getNom());
		prenom_tb.setText(uncv.getIdentite().getPrenom());
		adresse_tb.setText(uncv.getIdentite().getAdresse());
		tel_tb.setText(uncv.getIdentite().getTel());
		
		System.out.println("identite tab, received tab"+ uncv.toString());
		
		return inflatedView;
	}


	
}
