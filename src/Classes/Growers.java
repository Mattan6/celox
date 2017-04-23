	
	package Classes;
	
	import java.util.ArrayList;
	
	public class Growers {
		private String gID;
		private String gName;
		private String gAddress;
		private String gPhone;
		private ArrayList<Plots> plots = new ArrayList<Plots>();
	
	
		public Growers(String id, String name, String addr, String phone){
			this.gID = id;
			this.gName = name;
			this.gAddress = addr;
			this.gPhone = phone;
		}
	
	
		public Growers(String grower){
			this.gID = grower.substring(grower.lastIndexOf("ID: ")+4, grower.indexOf("  Name: ")).trim();
			this.gName = grower.substring(grower.lastIndexOf("  Name: ")+8, grower.indexOf("  Address: ")).trim();
			this.gAddress = grower.substring(grower.lastIndexOf("  Address: ")+11, grower.indexOf("  Phone Number: ")).trim();
			this.gPhone = grower.substring(grower.lastIndexOf("  Phone Number: ")+16,grower.length()).trim();
	
		}
	
	
		public String getgID() {
			return gID;
		}
	
		public String getgName() {
			return gName;
		}
	
		public String getgAddress() {
			return gAddress;
		}
	
		public String getgPhone() {
			return gPhone;
		}
		
		public ArrayList<Plots> getPlots(){
			return this.plots;
		}
		
		public void addPlot(Plots plot){
			this.plots.add(plot);
		}
		
		public String getGrowerDet(){
			return "ID: " + gID + "  Name: " + gName + "  gAddress: " + gAddress + " gPhone: " + gPhone;
		}
	
		@Override
		public String toString() {
			String grower = "";
			grower = "ID: " + gID + "  Name: " + gName + "  gAddress: " + gAddress + " gPhone: " + gPhone + " Plots: [ ";
			for (Plots p : plots){
				grower += "" + p.toString() + ", " ;
			}
			grower+= "]";
			return grower;
			
		}
	
	}
	
	
