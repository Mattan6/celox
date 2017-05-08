package Classes;

import java.util.Date;

public class Carrots {
	
	private int length;
	private int cShape;
	private int sShape;
	private int diameter;
	private int volume;
	private int filter0;
	private int filter1;
	private int filter2;
	private int filter3;
	private int filter4;
	private int filter5;
	private int filter6;
	private int filter7;
	private int brokenends;
	private int whatClass;
	
	public Carrots(int len, int cs, int ss, int dia, int vol, int fil0, int fil1,
			int fil2, int fil3, int fil4, int fil5, int fil6, int fil7, int broken, int what){
		this.length=len;
		this.cShape=cs;
		this.sShape=ss;
		this.diameter=dia;
		this.volume=vol;
		this.filter0=fil0;
		this.filter1=fil1;
		this.filter2=fil2;
		this.filter3=fil3;
		this.filter4=fil4;
		this.filter5=fil5;
		this.filter6=fil6;
		this.filter7=fil7;
		this.brokenends=broken;
		this.whatClass=what;		
	}

	public int getLength() {
		return length;
	}

	public int getcShape() {
		return cShape;
	}

	public int getsShape() {
		return sShape;
	}

	public int getDiameter() {
		return diameter;
	}

	public int getVolume() {
		return volume;
	}

	public int getFilter0() {
		return filter0;
	}

	public int getFilter1() {
		return filter1;
	}

	public int getFilter2() {
		return filter2;
	}

	public int getFilter3() {
		return filter3;
	}

	public int getFilter4() {
		return filter4;
	}

	public int getFilter5() {
		return filter5;
	}

	public int getFilter6() {
		return filter6;
	}

	public int getFilter7() {
		return filter7;
	}

	public int getBrokenends() {
		return brokenends;
	}

	public int getWhatClass() {
		return whatClass;
	}
	
	
	@Override
	public String toString() {
		return "Carrot [length=" + length + ", cShape=" + cShape + ", sShape=" + sShape + ", diameter=" + diameter
				+ ", volume=" + volume + ", filter0=" + filter0 + ", filter1=" + filter1 + ", filter2=" + filter2
				+ ", filter3=" + filter3 + ", filter4=" + filter4 + ", filter5=" + filter5 + ", filter6=" + filter6
				+ ", filter7=" + filter7 + ", brokenends=" + brokenends + ", whatClass=" + whatClass + "]";
	}
	

}
