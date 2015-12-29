package others;

public class ValidNumber {

    public boolean isNumber(String s) {
    	return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber v = new ValidNumber();
		System.out.println(v.isNumber("3.1"));
		System.out.println(v.isNumber("- 8.9"));
		System.out.println(v.isNumber("2."));
		System.out.println(v.isNumber("abc"));
		System.out.println(v.isNumber("e10"));
		System.out.println(v.isNumber("5e10"));
	}

}
