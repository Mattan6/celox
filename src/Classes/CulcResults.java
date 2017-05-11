package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CulcResults {

	private Long totalProd=(long) 0;
	private MachineOutput mac;
	private Sorts sort;



	public CulcResults(MachineOutput mac, Sorts sort){
		this.mac=mac;
		this.sort=sort;
	}


	public List<Carrots> fillDate(){
		for (ProductList pl : mac.getDetails()){
			totalProd+=pl.getTotal_prod();
			for (int i=0;i<pl.getTotal_prod();++i){
				sort.addCarrot(new Carrots(pl.getLength().get(i),
						pl.getCshape().get(i), pl.getSshape().get(i), pl.getDiameter().get(i), pl.getVolume().get(i),
						pl.getFilter0().get(i),pl.getFilter1().get(i), pl.getFilter2().get(i), pl.getFilter3().get(i),
						pl.getFilter4().get(i), pl.getFilter5().get(i), pl.getFilter6().get(i), pl.getFilter7().get(i),
						pl.getBrokenends().get(i), pl.getDivision().get(i) ));
				sort.getClassesOutcome()[pl.getDivision().get(i)]++;
				sort.getClassOutcomeWeight()[pl.getDivision().get(i)]+= pl.getVolume().get(i)*0.001;
				//System.out.println(sort.getCarrots().get(i).toString());
			}
		}
		this.sort.setTotalProd(totalProd);
		System.out.println("total prod is: " + totalProd);
		return sort.getCarrots();
	}

	
	public Sorts reSort(Sorts sort){
		for (Carrots car : sort.getCarrots()){
			
		}
			
		
		
		return null;
	}


}
