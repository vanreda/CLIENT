package fr.jaireda.client_rest.controller;

import java.util.ArrayList;

import fr.jaireda.client_rest.R;
import fr.jaireda.client_rest.model.CV;
import fr.jaireda.client_rest.model.Experience;
import fr.jaireda.client_rest.model.Formation;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class CursusTab extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View inflatedView= inflater.inflate(R.layout.cursus_frag, container, false);
		
		
		EditText annee_dpl_tb, diplome_tb, exp_tb, annee_exp_tb;
		
		annee_dpl_tb=(EditText)inflatedView.findViewById(R.id.annee__diple_tbt);
		diplome_tb=(EditText)inflatedView.findViewById(R.id.nom_diple_tbt);
		exp_tb=(EditText)inflatedView.findViewById(R.id.experience_tbt);
		annee_exp_tb=(EditText)inflatedView.findViewById(R.id.annee__exp_tbt);
		
		Bundle bn=getArguments();
		CV uncv=(CV) bn.get("uncv");
		String mode=bn.getString("mode");
		
		
		

			ArrayList<Formation> form=new ArrayList<Formation>();
			form.add(new Formation("dut", 2010));
			form.add(new Formation("l3",2011));
			uncv.setCursus(form);
			
			ArrayList<Experience> exps=new ArrayList<Experience>();
			exps.add(new Experience("stage atrait", 2010));
			exps.add(new Experience("bcp", 2011));
			uncv.setExperiencesPro(exps);
			Toast.makeText(getActivity(), "des données fictives sont ajoutées !", Toast.LENGTH_LONG).show();
		
		
		if(mode=="view"){
			annee_dpl_tb.setEnabled(false);
			annee_exp_tb.setEnabled(false);
			exp_tb.setEnabled(false);
			diplome_tb.setEnabled(false);
		}
		
	
		
		annee_dpl_tb.setText(uncv.getCursus().get(0).getAnnée()+" ");
		diplome_tb.setText(uncv.getCursus().get(0).getDiplome().toString());
		annee_exp_tb.setText(uncv.getExperiencesPro().get(0).getDateExp()+" ");
		exp_tb.setText(uncv.getExperiencesPro().get(0).getDescription().toString());
		
		
		
		
		return inflatedView;
	}

}
