
import java.util.Scanner; 
class NegativeNumberException extends Exception {
	
	private double number; 
	
	NegativeNumberException(String message, double number) {
		super(message); 
		this.number = number; 
	}
	
	public double getNumber() {
		return this.number; 
	}
	
	public void setNumber(int number) {
		this.number = number; 
	}
}

class NotANumberException extends Exception { 
	private String string; 
	NotANumberException (String message, String string) {
		super(message); 
		this.string = string; 
		
	}
}

class NumberCheck {
	static void foo (String string) throws NotANumberException{
		boolean isString = false ; 
		
		for (int i = 0; i < string.length(); i++) {
	        
	        if (string.charAt(i) == '-') {
	        	if (string.charAt(i +1 ) < '0' || string.charAt(i +1) > '9') {
		            isString = true; 
		        }
	        	else {
	        		isString = false; 
	        	}
	        }
	        else if (string.charAt(i) < '0' || string.charAt(i) > '9') {
	            isString = true; 
	        }
	        
	        else {
	        	isString = false; 
	        }
	        
	        
	    }
		
		if (isString == true) {
			throw new NotANumberException ("It is not a number", string) ; 
		}
	     
	    
	    
	}
}


class DivisionByZeroException extends Exception { 
	private double number; 
	
	DivisionByZeroException(String message, double number ) {
		super(message); 
		this.number = number; 
	}
	
	public double getNumber() {
		return this.number; 
	}
	
	public void setNumber(int number) {
		this.number = number; 
	}
}

class arithmaticCheck {
	static void foo(double a) throws DivisionByZeroException, NegativeNumberException {
		if (a ==0) {
			throw new DivisionByZeroException("Division By Zero", a); 
		}
		else if ( a < 0) {
			throw new NegativeNumberException("A cannot be Negative", a) ; 
		}
		
		else {
			System.out.println("The number is accepted: " + a) ; 
		}
	}
}


public class ExceptionHandlingPractice extends Exception{
	
	private double number; 
	
	public static void main (String args [])  throws NegativeNumberException, DivisionByZeroException, NotANumberException{
		
		Scanner scan = new Scanner(System.in); 
		
		try {
			String string = scan.nextLine(); 
			NumberCheck.foo(string) ; 
			double a = Double.parseDouble(string); 
			arithmaticCheck.foo(a);
			
		}
		catch (NotANumberException i) {
			System.out.println(i.getMessage()); 
		}
		catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
			System.out.println("the number inputed was: " + e.getNumber()) ;
			e.setNumber(1);
			System.out.println("the number has been reset to: " + e.getNumber()) ; 
		}
		catch (DivisionByZeroException e) {
			System.out.println(e.getMessage()); 
			System.out.println("the number inputed was: " + e.getNumber()) ;
			e.setNumber(1);
			System.out.println("the number has been reset to: " + e.getNumber()) ; 
		}
		finally  {
			System.out.println("End Of Main");
		}
		
		
		
		
		
	}
	
	
}

