package Classes;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

	private int total_prod;
	private List<Integer> length = new ArrayList<>();
	private List<Integer> diameter = new ArrayList<>();
	private List<Integer> volume = new ArrayList<>();
	private List<Integer> cshape = new ArrayList<>();
	private List<Integer> sshape = new ArrayList<>();
	private List<Integer> brokenends = new ArrayList<>();
	private List<Integer> greenShoulder = new ArrayList<>();
	private List<Integer> greenTop = new ArrayList<>();
	private List<Integer> multipleRoots = new ArrayList<>();
	private List<Integer> doubles = new ArrayList<>();
	private List<Integer> crooks = new ArrayList<>();	
	private List<Integer> filter0 = new ArrayList<>();
	private List<Integer> filter1 = new ArrayList<>();
	private List<Integer> filter2 = new ArrayList<>();
	private List<Integer> filter3 = new ArrayList<>();
	private List<Integer> filter4 = new ArrayList<>();
	private List<Integer> filter5 = new ArrayList<>();
	private List<Integer> filter6 = new ArrayList<>();
	private List<Integer> filter7 = new ArrayList<>();
	private List<Integer> division = new ArrayList<>(); // handle!!!!!! 

	public 	ProductList(){

	}
	
	public ProductList(ProductList pro){
		this.total_prod = pro.total_prod;
		this.length = pro.length;
		this.diameter = pro.diameter;
		this.volume = pro.volume;
		this.cshape = pro.cshape;
		this.sshape = pro.sshape;
		this.brokenends = pro.brokenends;
		this.greenShoulder = pro.greenShoulder;
		this.greenTop = pro.greenTop;
		this.multipleRoots = pro.multipleRoots;
		this.doubles = pro.doubles;
		this.crooks = pro.crooks;
		this.filter0 = pro.filter0;
		this.filter1 = pro.filter1;
		this.filter2 = pro.filter2;
		this.filter3 = pro.filter3;
		this.filter4 = pro.filter4;
		this.filter5 = pro.filter5;
		this.filter6 = pro.filter6;
		this.filter7 = pro.filter7;
		this.division = pro.division;
	}


	public List<Integer> getDivision() {
		return division;
	}

	public int getTotal_prod() {
		return total_prod;
	}

	public List<Integer> getLength() {
		return length;
	}

	public List<Integer> getDiameter() {
		return diameter;
	}

	public List<Integer> getVolume() {
		return volume;
	}

	public List<Integer> getCshape() {
		return cshape;
	}

	public List<Integer> getSshape() {
		return sshape;
	}

	public List<Integer> getBrokenends() {
		return brokenends;
	}

	public List<Integer> getGreenShoulder() {
		return greenShoulder;
	}

	public List<Integer> getGreenTop() {
		return greenTop;
	}

	public List<Integer> getMultipleRoots() {
		return multipleRoots;
	}

	public List<Integer> getDoubles() {
		return doubles;
	}

	public List<Integer> getCrooks() {
		return crooks;
	}

	public List<Integer> getFilter0() {
		return filter0;
	}

	public List<Integer> getFilter1() {
		return filter1;
	}

	public List<Integer> getFilter2() {
		return filter2;
	}

	public List<Integer> getFilter3() {
		return filter3;
	}

	public List<Integer> getFilter4() {
		return filter4;
	}

	public List<Integer> getFilter5() {
		return filter5;
	}

	public List<Integer> getFilter6() {
		return filter6;
	}

	public List<Integer> getFilter7() {
		return filter7;
	}

	
	@Override
	public String toString() {
		return "ProductList [total_prod=" + total_prod + ", length=" + length + ", diameter=" + diameter + ", volume="
				+ volume + ", cshape=" + cshape + ", sshape=" + sshape + ", brokenends=" + brokenends
				+ ", greenShoulder=" + greenShoulder + ", greenTop=" + greenTop + ", multipleRoots=" + multipleRoots
				+ ", doubles=" + doubles + ", crooks=" + crooks + ", filter0=" + filter0 + ", filter1=" + filter1
				+ ", filter2=" + filter2 + ", filter3=" + filter3 + ", filter4=" + filter4 + ", filter5=" + filter5
				+ ", filter6=" + filter6 + ", filter7=" + filter7 + ", division=" + division + "]";
	}

	
	

}
