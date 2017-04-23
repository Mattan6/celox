package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Sorts {
	
	private List<Carrots> carrots = null;
	private Date startData = new Date();
	private int[] classesOutcome = null;
	private Date endDate = null;
	private Growers grower;
	private Plots plot;
	private List<ClassDetails> classes = new ArrayList<>(); 
	private String comments;
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Sorts(){
		this.startData.getTime();
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

	public List<ClassDetails> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassDetails> classes) {
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

	@Override
	public String toString() {
		return "this Sort is [carrots=" + carrots + ", startData=" + startData + ", classesOutcome="
				+ Arrays.toString(classesOutcome) + "\n, endDate=" + endDate + "\n, grower=" + grower.getGrowerDet() + "\n, plot=" + plot.toString()
				+ "\n, classes=" + classes + "]";
	}
	
	
	

}
