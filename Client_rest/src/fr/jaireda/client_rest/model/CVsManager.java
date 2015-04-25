package fr.jaireda.client_rest.model;


import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


/**
 * Created by jaired on 16/04/15.
 */

@Root(name="listedeCVs")
public class CVsManager {

	@ElementList(inline=true, entry="cv")
    private List<CV> listedeCVs;


    public CVsManager(ArrayList<CV> listCV) {

        this.listedeCVs=new ArrayList<CV>();
        this.setListCV(listCV);
    }

    public CVsManager() {

        this.listedeCVs=new ArrayList<CV>();

    }
    public List<CV> getListCV() {
        return listedeCVs;
    }

    public void setListCV(ArrayList<CV> listCV) {
        this.listedeCVs= listCV;
    }

	@Override
	public String toString() {
		return "CVsManager [listedeCVs=" + listedeCVs + "]";
	}


    

}
