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
	private int[] sensitivity = new int[4];
	
	
	public ClassDetails(int lenF, int lenT, int diaF, int diaT, int bro, int c, int s, String cla, int[] sens){
		this.lengthFrom = lenF;
		this.lengthTo = lenT;
		this.diameterFrom = diaF;
		this.diameterTo = diaT;
		this.broken = bro;
		this.cShape = c;
		this.sShape = s;
		this.whatClass = cla;
		this.sensitivity = sens;
	}


	public int[] getSensitivity() {
		return sensitivity;
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
				+ "]" + "sensitivity: [ Split: " + sensitivity[0] +" Black-spots: " + sensitivity[1] + " Gray damage: " + sensitivity[2] + 
				" Crown: " + sensitivity[3] + " ]";
	}
	

}
