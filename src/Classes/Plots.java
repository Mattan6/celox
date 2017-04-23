
package Classes;

public class Plots {
	
	private String pName;
	private String pSize;
	private String pSpec;

	public Plots(String name, String size, String spec)
	{
		this.pName = name;
		this.pSize = size;
		this.pSpec = spec;
	}

	public Plots()
	{

	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getpSpec() {
		return pSpec;
	}

	public void setpSpec(String pSpec) {
		this.pSpec = pSpec;
	}
	
	@Override
	public String toString() {
		return "Name: " + pName + " , Size: " + pSize + " , pSpec: " + pSpec;
	}


}

