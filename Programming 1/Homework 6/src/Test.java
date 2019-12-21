
public class Test {
	
	public static void main(String[] args) {
		
		
		String str = "9s9fs697df9s59df";
		
		@SuppressWarnings("unused")
		
		
		
		
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				count++;
			}
		}
		
		

	}
	
	
	public boolean isDotComString(String str) {
		if(str.toLowerCase().endsWith(".com")) {
			return true;
		}
		return false;
	}
	
}
