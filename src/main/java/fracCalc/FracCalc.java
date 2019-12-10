/**
 * @author Mr. Rasmussen
 */


package fracCalc;
import java.util.*;
public class FracCalc {
 
 public static void main(String[] args) {
 // TODO: Read the input from the user and call produceAnswer with an equation
	 Scanner s = new Scanner(System.in);
 	System.out.println("Welcome to the Frac Calc Calculator");
 	System.out.print("Enter an expression: ");
 	String expression = s.nextLine();
 	while(!expression.equalsIgnoreCase("quit")) {
 	System.out.println(produceAnswer(expression));
 	System.out.print("Enter an expression: ");
 	expression = s.nextLine();
 	}

               }
 
 // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
 // test your code
 // This function takes a String 'input' and produces the result
 //
 // input is a fraction string that needs to be evaluated. For your program, this
 // will be the user input.
 // e.g. input ==> "1/2 + 3/4"
 //
 // The function should return the result of the fraction after it has been
 // calculated
 // e.g. return ==> "1_1/4"
     public static String produceAnswer(String input) {
              // TODO: Implement this function to produce the solution to the input
 
              // Parsing one line of input
       int space = input.indexOf(" "); // find the index of the first space
       String operandOne = input.substring(0, space); // substring of beginning to space before operator
 
       String newString1 = input.substring(space + 1, input.length());
       int space2 = newString1.indexOf(" "); // find the index of the second space
       String operator = newString1.substring(0, space2); // operator is between the first space and the second space
 
       String newString2 = newString1.substring(space2, newString1.length());
       String operandTwo = newString2.substring(space2, newString2.length()); // substring of space after operator to the end
                                                                                                                                                                                                                                                                                                            
 
                // Multiple operations
        while (operandTwo.indexOf(" ") > 0) {
        int space3 = operandTwo.indexOf(" ");
        String value = operandTwo.substring(0, space3);
        String new_String3 = operandTwo.substring(space3 + 1, operandTwo.length());
        int space4 = new_String3.indexOf(" ");
        String operator2 = new_String3.substring(space4 - 1, space4);
        operandTwo = new_String3.substring(space4 + 1, new_String3.length());
        String new_equation = operandOne + " " + operator + " " + value;
        operandOne = produceAnswer(new_equation);
        operator = operator2;
          }
 
                 // Parsing fractions: Operand 1
        String whole1 = operandOne; // hi_
        String num1 = "";
        String denom1 = "";
        int slash1 = operandOne.indexOf("/");
 
        if (slash1 > 0) {
        int underscore1 = operandOne.indexOf("_");
        if (underscore1 > 0) {
        whole1 = operandOne.substring(0, underscore1);
        num1 = operandOne.substring(underscore1 + 1, slash1);
        denom1 = operandOne.substring(slash1 + 1, operandOne.length());
         } else {
        whole1 = "0";
        num1 = operandOne.substring(underscore1 + 1, slash1);
        denom1 = operandOne.substring(slash1 + 1, operandOne.length());
            }
 
            } else {
            num1 = "0";
            denom1 = "1";
                              }
 
            // Parsing fractions: Operand 2
             String whole2 = operandTwo;
             String num2 = "";
             String denom2 = "";
             int slash2 = operandTwo.indexOf("/");
 
             if (slash2 > 0) {
             int underscore2 = operandTwo.indexOf("_");
             if (underscore2 > 0) {
             whole2 = operandTwo.substring(0, underscore2);
             num2 = operandTwo.substring(underscore2 + 1, slash2);
             denom2 = operandTwo.substring(slash2 + 1, operandTwo.length());
             } else {
             whole2 = "0";
             num2 = operandTwo.substring(underscore2 + 1, slash2);
             denom2 = operandTwo.substring(slash2 + 1, operandTwo.length());
              }
 
             } else {
             num2 = "0";
              denom2 = "1";
                              }
             
             
                              // change strings to integers
                              int intwhole1 = Integer.parseInt(whole1);
                              int intnum1 = Integer.parseInt(num1);
                              int intdenom1 = Integer.parseInt(denom1);
 
                              int intwhole2 = Integer.parseInt(whole2);
                              int intnum2 = Integer.parseInt(num2);
                              int intdenom2 = Integer.parseInt(denom2);
 
                              // convert to improper fraction
                              intnum1 += intdenom1 * Math.abs(intwhole1);
                              if (intwhole1 < 0) {
                                 intnum1 *= -1;
                              }
 
                              intnum2 += intdenom2 * Math.abs(intwhole2);
                              if (intwhole2 < 0) {
                                intnum2 *= -1;
                              }
 
                              int finalnum = 0;
                              int finaldenom = 0;
                              int finalwhole = 0;
 
                              // if denominator equals 0, quit
                              if (intdenom1 == 0 || intdenom2 == 0) {
                                             return "Invalid";
                              }
 
                              // if operator is incorrect, quit
                              if (operator.length() > 1) {
                                             return "Invalid";
                              }
 
                              // addition calculation
                              // multiply whole values to fraction to get a common denominator
                              if (operator.equals("+")) {
                                   intnum1 *= intdenom2;
                                    intnum2 *= intdenom1;
                                             finalnum = intnum1 + intnum2;
                                             finaldenom = intdenom1 * intdenom2;
                              }
 
                              // subtraction calculation
                              if (operator.equals("-")) {
                                intnum1 *= intdenom2;
                                intnum2 *= intdenom1;
                                             finalnum = intnum1 - intnum2;
                                             finaldenom = intdenom1 * intdenom2;
                              }
 
                              // multiplication calculation
                              if (operator.equals("*")) {
                                             finalnum = intnum1 * intnum2;
                                             finaldenom = intdenom1 * intdenom2;
                                             if (intnum1 == 0 || intnum2 == 0) {
                                                            return 0 + "";
                                             }
                              }
 
                              // division calculation
                              if (operator.equals("/")) {
                                             finalnum = intnum1 * intdenom2;
                                             finaldenom = intdenom1 * intnum2;
                              }
 
                              // make numerator negative instead of the denominator
                              if (finaldenom < 0 && finalnum > 0) {
                                             finaldenom *= -1;
                                             finalnum *= -1;
                              }
 
                              // convert to mixed fraction if numerator is positive
                              while (finalnum / finaldenom >= 1) {
                                             finalnum -= finaldenom;
                                             finalwhole += 1;
                              }
 
                              // convert to mixed fraction if numerator is negative
                              while (finalnum / finaldenom <= -1) {
                                             finalnum += finaldenom;
                                             finalwhole -= 1;
                              }
 
                              // remove signs from numerator and denominator if there is a whole number
                              if (finalwhole != 0) {
                                             finalnum = Math.abs(finalnum);
                                             finaldenom = Math.abs(finaldenom);
                              }
 
                              // reduce fraction
                              int gcd = 1;
                              for (int i = 1; i <= Math.abs(finalnum) && i <= Math.abs(finaldenom); i++) {
                                             if (finalnum % i == 0 && finaldenom % i == 0)
                                                            gcd = i;
                              }
                              finalnum /= gcd;
                              finaldenom /= gcd;
 
                              // final output
                              if (finalwhole == 0) {
                                             if (finalnum == 0) {
                                                            return "0";
                                             } else {
                                                            return finalnum + "/" + finaldenom;
                                             }
              } else if (finalnum == 0 || finaldenom == 1) {
              return finalwhole + "";
         } else {
        return finalwhole + "_" + finalnum + "/" + finaldenom;
                   }
           }
}
 
// TODO: Fill in the space below with any helper methods that you think you will need


