package Classes;

import java.util.List;

public class CulcResults {

	private Long totalProd=(long) 0;
	private MachineOutput mac;
	private Sorts sort;



	public CulcResults(MachineOutput mac, Sorts sort){
		this.mac=mac;
		this.sort=sort;
	}
	
	public CulcResults(Sorts sort){
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
		int num=0;
		for (Carrots car : sort.getCarrots()){
			num = whatClass(car, sort.getUserClassDetails());
			sort.getClassesOutcome()[num]++;
			sort.getClassOutcomeWeight()[num]+= car.getVolume()*0.001;
			car.setWhatClass(num);
		}
		//System.out.println(Arrays.toString(sort.getClassesOutcome()));
		//System.out.println(Arrays.toString(sort.getClassOutcomeWeight()));
		
		
		return sort;
	}


	private int whatClass(Carrots car, List<ClassDetails> userClassDetails) {
		for ( int i=0;i<userClassDetails.size();++i){
			if (car.getLength()>=userClassDetails.get(i).getLengthFrom() && car.getLength()<=userClassDetails.get(i).getLengthTo()){
				if (car.getDiameter()>=userClassDetails.get(i).getDiameterFrom() && car.getDiameter()<=userClassDetails.get(i).getDiameterTo()){
					if (car.getcShape()<=userClassDetails.get(i).getcShape()){
						if (car.getsShape()<=userClassDetails.get(i).getsShape()){
							if (car.getBrokenends()<userClassDetails.get(i).getBroken()){
								return i+1;
							}
						}
					}
				}
			}
		}
		return 0;
	}



}
