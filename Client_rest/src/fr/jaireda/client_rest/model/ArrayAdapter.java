package fr.jaireda.client_rest.model;

import fr.jaireda.client_rest.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ArrayAdapter extends BaseAdapter {

	private CVsManager cvs; 
	LayoutInflater inflater;
	
	public ArrayAdapter(Context context, CVsManager cvs) {
		inflater=LayoutInflater.from(context);
		this.cvs=cvs;
	}
	
	
	@Override
	public int getCount() {
		return this.cvs.getListCV().size();
	}

	@Override
	public Object getItem(int arg0) {
	
		return this.cvs.getListCV().get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
	
		return arg0;
	}

	
	private class ViewHolder {
		TextView nom;
		TextView prenom;
		TextView titre;
	}
	@Override
	public View getView(int position, View converView, ViewGroup parent) {
		ViewHolder holder;
		if(converView==null){
			holder=new ViewHolder();
			converView=inflater.inflate(R.layout.item_personne, null);
			holder.nom=(TextView)converView.findViewById(R.id.nom);
			holder.prenom=(TextView)converView.findViewById(R.id.prenom);
			holder.titre=(TextView)converView.findViewById(R.id.titre);
			converView.setTag(holder);
		} else {
			holder=(ViewHolder)converView.getTag();
		}
		holder.nom.setText( this.cvs.getListCV().get(position).getIdentite().getNom()+" ");
		holder.prenom.setText(this.cvs.getListCV().get(position).getIdentite().getPrenom()+" ");
		holder.titre.setText(this.cvs.getListCV().get(position).getTitre());
		return converView;
	}

}
