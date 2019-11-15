/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*; 
public class FracCalc {

    public static void main(String[] args)
    {
    	System.out.println("Welcome to the Frac Calc Calculator");
    	Scanner userInput = new Scanner(System.in);
    	System.out.print("Enter an expression");
    	String expression = userInput.nextLine();
    	System.out.println(produceAnswer(expression));
        // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String expression) {
        String fraction = "";
        String operator = "";
        String fraction2 = "";
        int i = 0;
        while (fraction.equals("")) {
        	if (expression.charAt(i) == (' ')) {
        		fraction = expression.substring(0, i);
        		operator = expression.substring(i + 1, i + 2);
        		fraction2 = expression.substring(i + 3);
        			
      		} else {
       			i++;
       		}
    	// TODO: Implement this function to produce the solution to the input


        }
        return fraction2;
    // TODO: Fill in the space below with any helper methods that you think you will need

    }
}
