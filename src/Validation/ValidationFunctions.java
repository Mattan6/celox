package Validation;

public class ValidationFunctions {
	/**
	 * this function checks the id for 9 digits and only digits
	 *  
	 *  
	 * @param id
	 * @return boolean 
	 */
	public boolean  checkId(String id){
		if (id.length()==9)
			if (id.matches("[0-9]+"))
				return true;
		return false;
	}
	
	
	/**
	 * this function check cellular phone number to be 10 digits
	 * and checks if it starts with 05 at the beginning and only digits 
	 * @param phone
	 * @return
	 */
	
	public boolean  checkCellular(String phone){
		if (phone.length()==10)
			if (phone.matches("05[0-9]+"))
				return true;
		return false;
	} 
	
	
	/**
	 * this function check home phone number to be 9 digits
	 * and checks if it starts with 0 at the beginning and only digits 
	 * @param phone
	 * @return
	 */
	public boolean  checkHomePhone(String phone){
		if (phone.length()==9)
			if (phone.matches("0[0-9]+"))
				return true;
		return false;
	} 
	
	
	/**
	 * this function checks the address to be under 150 letters 
	 * and checks if its build only from letters and digits
	 * 
	 * @param addr
	 * @return
	 */
	public boolean checkAddress(String addr){
		if (addr.length()<150)
			if (addr.matches("[a-zA-Z0-9 ]+"))
				return true;
		return false;
		
	}
	
	
	/**
	 * this function checks the name to be under 25 letters 
	 * and checks if its build only from letters 
	 * @param name
	 * @return
	 */
	public boolean checkName(String name){
		if (name.length()<25)
			if (name.matches("[a-zA-Z ]+"))
				return true;
		return false;
		
	}
	
	public boolean checkString(String str){
		if (str.length()<150)
			if (str.matches("[a-zA-Z0-9 ]+"))
				return true;
		return false;
		
	}
	

}
