package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class Sorts {

	//private SimpleDateFormat oldDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss+00:00");
	private List<Carrots> carrots = new ArrayList<>();
	private Date startData = new Date();   ///////////
	private int[] classesOutcome = new int[7];
	private float[] classOutcomeWeight = new float[7];
	private Long totalProd  = (long) 0 ;
	private Date endDate;   ////////////
	private Growers grower;        ////////////
	private Plots plot;           ////////////
	private List<ClassDetails> classes = new ArrayList<>();  ///////////
	private String comments;      ///////////


	public Sorts(){
		
	}



	public Sorts(Sorts sort){
		this.carrots=sort.carrots;
		this.startData = sort.startData;
		//this.classesOutcome = sort.classesOutcome;
		this.endDate = sort.endDate;
		this.grower = sort.grower;
		this.plot=sort.plot;
		this.classes = sort.classes;
		this.comments=sort.comments;
		//this.classOutcomeWeight = sort.classOutcomeWeight;
	}

	public void setClassOutcomeWeight(float[] classOutcomeWeight) {
		this.classOutcomeWeight = classOutcomeWeight;
	}
	
	public Long getTotalProd() {
		return totalProd;
	}

	public void setTotalProd(Long totalProd) {
		this.totalProd = totalProd;
	}

	public float[] getClassOutcomeWeight() {
		return classOutcomeWeight;
	}

	public List<ClassDetails> getClasses() {
		return classes;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setCarrots(List<Carrots> carrots) {
		this.carrots = carrots;
	}

	public void addCarrot(Carrots car){
		this.carrots.add(car);
	}

	public List<Carrots> getCarrots() {
		return carrots;
	}


	public Date getStartData() {
		return startData;
	}


	public int[] getClassesOutcome() {
		return classesOutcome;
	}

	public List<ClassDetails> getUserClassDetails() {
		return classes;
	}

	public void setUserClassDetails(List<ClassDetails> classes) {
		this.classes = classes;
	}

	public void setClassesOutcome(int[] classes) {
		this.classesOutcome = classes;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Growers getGrower() {
		return grower;
	}

	public void setGrower(Growers grower) {
		this.grower = grower;
	}

	public Plots getPlot() {
		return plot;
	}

	public void setPlot(Plots plot) {
		this.plot = plot;
	}

	public String getSortDetails(){
		return "Sort Date: " + startData.toString() + "Grower: " + grower.getgName() +" Plot: " + plot.getpName()
		+ "Plot's Speicies: " + plot.getpSpec();

	}

	@Override
	public String toString() {
		return "this Sort is [carrots=" + carrots + ", startData=" + startData + ", classesOutcome="
				+ Arrays.toString(classesOutcome) + "\n, endDate=" + endDate + "\n, grower=" + grower.getGrowerDet() + "\n, plot=" + plot.toString()
				+ "\n, classes=" + classes + "]";
	}


	public String[][] convertClassDetToMat(){
		String[][] strMat = new String[12][7];
		strMat[0][0] = "";
		int d=0;
		for (int i=1;i<7;i++){
			strMat[0][i] = this.classes.get(d++).getWhatClass();
		}

		strMat[1][0] = "Length From";
		strMat[2][0] = "Length To";
		strMat[3][0] = "Diameter From";
		strMat[4][0] = "Diameter To;";
		strMat[5][0] = "Broken;";
		strMat[6][0] = "cShape;";
		strMat[7][0] = "sShape;";
		strMat[8][0] = "Split";
		strMat[9][0] = "Black Spots";
		strMat[10][0] = "Gray Damage ";
		strMat[11][0] = "Crown";

		int j=1;
		for (int i=1;i<7;++i){
			for (int k=0;k<this.classes.size();++k){
				if (this.classes.get(k).getWhatClass().equals(strMat[0][i])){
					strMat[j++][i] = "" + this.classes.get(k).getLengthFrom();
					strMat[j++][i] = "" + this.classes.get(k).getLengthTo();
					strMat[j++][i] = "" + this.classes.get(k).getDiameterFrom();
					strMat[j++][i] = "" + this.classes.get(k).getDiameterTo();
					strMat[j++][i] = "" + this.classes.get(k).getBroken();
					strMat[j++][i] = "" + this.classes.get(k).getcShape();
					strMat[j++][i] = "" + this.classes.get(k).getsShape();
					strMat[j++][i] = "" + this.classes.get(k).getSensitivity()[0];
					strMat[j++][i] = "" + this.classes.get(k).getSensitivity()[1];
					strMat[j++][i] = "" + this.classes.get(k).getSensitivity()[2];
					strMat[j++][i] = "" + this.classes.get(k).getSensitivity()[3];
				}
				j=1;
			}
		}		
		return strMat;
	}

	public String[][] convertCarrotsToMat(){
		
		
		
		if (this.carrots.size()==0){
			Calendar sd = Calendar.getInstance();
			sd.set(2017, Calendar.APRIL, 30, 21, 00);
			Date start = sd.getTime();
			Calendar ed = Calendar.getInstance();
			ed.set(2017, Calendar.APRIL, 30, 22, 59);
			Date end = ed.getTime();
			MachineOutput output = new MachineOutput(start, end);;
			CulcResults res  = new CulcResults(output, this);
			output.fillDetailsDB();
			res.fillDate();
		}
		
		String[][] strMat = new String[this.carrots.size()+1][15];
		//System.out.println("carrots size: "  + this.carrots.size());
		strMat[0][0] = "Length";
		strMat[0][1] = "C-Shape";
		strMat[0][2] = "S-Shape";
		strMat[0][3] = "Diameter";
		strMat[0][4] = "Volume";
		strMat[0][5] = "Brokenends";
		strMat[0][6] = "filter0";
		strMat[0][7] = "filter1";
		strMat[0][8] = "filter2";
		strMat[0][9] = "filter3";
		strMat[0][10] = "filter4";
		strMat[0][11] = "filter5";
		strMat[0][12] = "filter6";
		strMat[0][13] = "filter7";
		strMat[0][14] = "what-Class";

		int j=0, k=0;
		for (int i=1;i<this.carrots.size();++i){
				strMat[i][j++] = "" + this.carrots.get(k).getLength();
				strMat[i][j++] = "" + this.carrots.get(k).getcShape();
				strMat[i][j++] = "" + this.carrots.get(k).getsShape();
				strMat[i][j++] = "" + this.carrots.get(k).getDiameter();
				strMat[i][j++] = "" + this.carrots.get(k).getVolume();
				strMat[i][j++] = "" + this.carrots.get(k).getBrokenends();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter0();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter1();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter2();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter3();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter4();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter5();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter6();
				strMat[i][j++] = "" + this.carrots.get(k).getFilter7();
				strMat[i][j++] = "" + this.carrots.get(k).getWhatClass();
				j=0;
				k++;
		}		
		System.out.println("finish!");
		return strMat;
	}
	
	public String[][] convertClassOutToMat(){
		String[][] strMat = new String[4][8];
		strMat[0][0] = "";
		strMat[0][1] = "W";
		strMat[0][2] = "A";
		strMat[0][3] = "B";
		strMat[0][4] = "C";
		strMat[0][5] = "D";
		strMat[0][6] = "E";
		strMat[0][7] = "F";
		strMat[1][0] = "Division";
		strMat[2][0] = "Weight in Kg";
		strMat[3][0] = "Total Prod - Number Of Carrots";
		
		int j=1, k=0;
		for ( int i=1;i<this.classesOutcome.length+1;++i){
			strMat[j][i] = "" + this.classesOutcome[k++];
		}
		k=0;
		j=2;
		for (int i=1; i<this.classOutcomeWeight.length+1;++i){
			strMat[j][i] = "" + this.classOutcomeWeight[k++];
		}
		
		strMat[3][1] = "" + this.totalProd;
			
		return strMat;
	}


}
