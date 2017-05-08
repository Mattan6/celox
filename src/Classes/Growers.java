	
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
		
		public Growers(Growers grower){
			this.gID = grower.getgID();
			this.gName = grower.getgName();
			this.gAddress = grower.getgAddress();
			this.gPhone = grower.getgPhone();
			this.plots = grower.getPlots();
		}
	
		public void setgName(String gName) {
			this.gName = gName;
		}


		public void setgAddress(String gAddress) {
			this.gAddress = gAddress;
		}


		public void setgPhone(String gPhone) {
			this.gPhone = gPhone;
		}


		public void setPlots(ArrayList<Plots> plots) {
			this.plots = plots;
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
		
		public String[][] convertToMat(){
			String[][] strMat = new String[4][2];
			strMat[0][0] = "Grower Name";
			strMat[0][1] = this.gName;
			strMat[1][0] = "Grower ID";
			strMat[1][1] = this.gID;
			strMat[2][0] = "Grower Address";
			strMat[2][1] = this.gAddress;
			strMat[3][0] = "Grower Phone";
			strMat[3][1] = this.gPhone;
			
			return strMat;
		}
		
		
	}
	
	
