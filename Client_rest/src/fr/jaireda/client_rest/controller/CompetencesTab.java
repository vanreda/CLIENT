package fr.jaireda.client_rest.controller;

import java.util.ArrayList;

import fr.jaireda.client_rest.R;
import fr.jaireda.client_rest.model.CV;
import fr.jaireda.client_rest.model.Competence;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;




public class CompetencesTab extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View inflatedView= inflater.inflate(R.layout.competences_frag, container, false);
		
		String mode="";
		EditText titre_cmpt_tb, desc_cmpt_tb, annee_proj_tb, proj_tb;
		
		titre_cmpt_tb=(EditText)inflatedView.findViewById(R.id.titre_cmpt_tbt);
		desc_cmpt_tb=(EditText)inflatedView.findViewById(R.id.desc_cmpt_tbt);
		annee_proj_tb=(EditText)inflatedView.findViewById(R.id.annee_projet_tbt);
		proj_tb=(EditText)inflatedView.findViewById(R.id.projet_tbt);
		
		Bundle bn=getArguments();
		CV uncv=(CV) bn.get("uncv");
		mode=bn.getString("mode");
		
		if(mode=="view"){
			titre_cmpt_tb.setEnabled(false);
			desc_cmpt_tb.setEnabled(false);
			annee_proj_tb.setEnabled(false);
			proj_tb.setEnabled(false);
		}
		
		
		
		ArrayList<Competence> competences=new ArrayList<Competence>();
		competences.add(new Competence("languages:", "vb.NET, java, c, C++"));
		uncv.setCompetences(competences);
		
		titre_cmpt_tb.setText(uncv.getCompetences().get(0).getTitre());
		desc_cmpt_tb.setText(uncv.getCompetences().get(0).getDescription());
		
		
		
		
		
		return inflatedView;
	}

}
