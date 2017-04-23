package Classes;

public class ClassDetails {
	
	private int lengthFrom;
	private int lengthTo;
	private int diameterFrom;
	private int diameterTo;
	private int broken;
	private int cShape;
	private int sShape;
	private String whatClass;
	
	
	public ClassDetails(int lenF, int lenT, int diaF, int diaT, int bro, int c, int s, String cla){
		this.lengthFrom = lenF;
		this.lengthTo = lenT;
		this.diameterFrom = diaF;
		this.diameterTo = diaT;
		this.broken = bro;
		this.cShape = c;
		this.sShape = s;
		this.whatClass = cla;
	}


	public String getWhatClass() {
		return whatClass;
	}


	public int getLengthFrom() {
		return lengthFrom;
	}


	public int getLengthTo() {
		return lengthTo;
	}


	public int getDiameterFrom() {
		return diameterFrom;
	}


	public int getDiameterTo() {
		return diameterTo;
	}


	public int getBroken() {
		return broken;
	}


	public int getcShape() {
		return cShape;
	}


	public int getsShape() {
		return sShape;
	}


	@Override
	public String toString() {
		return "Class " + whatClass + "[lengthFrom=" + lengthFrom + ", lengthTo=" + lengthTo + ", diameterFrom=" + diameterFrom
				+ ", diameterTo=" + diameterTo + ", broken=" + broken + ", cShape=" + cShape + ", sShape=" + sShape
				+ "]";
	}
	
	

}
