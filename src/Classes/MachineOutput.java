package Classes;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Handlers.*;

public class MachineOutput {

	private SimpleDateFormat oldDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private List<ProductList> details = new ArrayList<>();
	private List<ProgramPacket> packet = new ArrayList<>();
	private String StartDate="";
	private String endDate="";
	
	public MachineOutput(Date start, Date end){
		this.StartDate = oldDate.format(start);
		this.endDate = oldDate.format(end);
		
	}
	
	public MachineOutput(String start, String end){
		this.StartDate = oldDate.format(start);
		this.endDate = oldDate.format(end);
	}

	public List<ProductList> getDetails() {
		return details;
	}

	public List<ProgramPacket> getPacket() {
		return packet;
	}

	public String getStartDate() {
		return StartDate;
	}

	public String getEndDate() {
		return endDate;
	}
	
	public void  fillDetailsDB(){
		SendServer get = new SendServer();
		details = get.getPackets(this.StartDate, this.endDate);
	}
	
	public void fillProgramDB(){
		SendServer get = new SendServer();
		packet = get.getProg(this.StartDate, this.endDate);
	}

	@Override
	public String toString() {
		String str =  "MachineOutput [details= ";
		for (ProductList p: details){
			str+= "\n" + p.toString();
		}
		String str1 = "packet= ";
		for (ProgramPacket p: packet){
			str1+= "\n" + p.toString();
		}
		return str + "\n " + str1 +  "\nStartDate=" + StartDate + ", endDate="
				+ endDate + "]";
	}
	
	
	
	
	
}
