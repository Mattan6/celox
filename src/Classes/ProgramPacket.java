package Classes;

import java.util.ArrayList;
import java.util.List;

public class ProgramPacket {
	
	private List<String> classQualityFilterName = new ArrayList<>();
	private List<Integer> classQualityFilterValue = new ArrayList<>();


	public ProgramPacket(){
		
	}
	
	public ProgramPacket(ProgramPacket pro){
		this.classQualityFilterName = pro.classQualityFilterName;
		this.classQualityFilterValue = pro.classQualityFilterValue;
		
	}

	public List<String> getClassQualityFilterName() {
		return classQualityFilterName;
	}

	public List<Integer> getClassQualityFilterValue() {
		return classQualityFilterValue;
	}

	@Override
	public String toString() {
		return "ProgramPacket [classQualityFilterName=" + classQualityFilterName + ", classQualityFilterValue="
				+ classQualityFilterValue + "]";
	}
	
	
	
	
}
