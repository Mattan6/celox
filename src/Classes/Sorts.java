package Classes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.naming.ldap.StartTlsRequest;


public class Sorts {
	
	//private SimpleDateFormat oldDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss+00:00");
	private List<Carrots> carrots = new ArrayList<>();
	private Date startData = new Date();   ///////////
	private int[] classesOutcome = new int[7];
	private Date endDate;   ////////////
	private Growers grower;        ////////////
	private Plots plot;           ////////////
	private List<ClassDetails> classes = new ArrayList<>();  ///////////
	private String comments;      ///////////
	
	
	public Sorts(){
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
	

}
