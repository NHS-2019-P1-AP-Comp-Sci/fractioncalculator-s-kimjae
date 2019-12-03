/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*; 
public class FracCalc {

    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Welcome to the Frac Calc Calculator");
    	System.out.print("Enter an expression: ");
    	String expression = s.nextLine();
    	while(!expression.equalsIgnoreCase("quit")) {
    	System.out.println(produceAnswer(expression));
    	System.out.print("Enter an expression: ");
    	expression = s.nextLine();
    	}
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
    public static String produceAnswer(String str) {
        // TODO: Implement this function to produce the solution to the input

        String OperandOne = "";
        String operator = "";
        String OperandTwo = "";
        int i = 0;
        while (OperandOne == "") {
               if (str.charAt(i) == (' ')) {
                      OperandOne = str.substring(0, i);
                      operator = str.substring(i + 1, i + 2);
                      OperandTwo = str.substring(i + 3, str.length());

               } else {
                      i++;

               }
        }
        String OperandWhole1 = findWhole(OperandOne);
        String OperandNum1 = findNum(OperandOne);
        String OperandDenom1 = findDenom(OperandOne);

        String OperandWhole2 = findWhole(OperandTwo);
        String OperandNum2 = findNum(OperandTwo);
        String OperandDenom2 = findDenom(OperandTwo);

        int firstWhole = Integer.parseInt(OperandWhole1);
        int firstNum = Integer.parseInt(OperandNum1);
        int firstDenom = Integer.parseInt(OperandDenom1);
        int secondWhole = Integer.parseInt(OperandWhole2);
        int secondNum = Integer.parseInt(OperandNum2);
        int secondDenom = Integer.parseInt(OperandDenom2);

        firstNum += firstDenom * Math.abs(firstWhole);
        if (firstWhole < 0) {
               firstNum *= -1;
        }

        secondNum += secondDenom * Math.abs(secondWhole);
        if (secondWhole < 0) {
               secondNum *= -1;

        }

        int finalWhole = 0;
        int finalNum = 0;
        int finalDenom = 0;

        if (operator.equals("+")) {
               firstNum *= secondDenom;
               secondNum *= firstDenom;

               int tempDenom = firstDenom;
               firstDenom *= secondDenom;
               secondDenom *= tempDenom;

               finalNum = firstNum + secondNum;
               finalDenom = firstDenom;

        }
        if (operator.equals("-")) {
               firstNum *= secondDenom;
               secondNum *= firstDenom;

               int tempDenom = firstDenom;
               firstDenom *= secondDenom;
               secondDenom *= tempDenom;

               finalNum = firstNum - secondNum;
               finalDenom = secondDenom;
        }
        if (operator.contentEquals("*")) {
               finalNum = firstNum * secondNum;
               finalDenom = firstDenom * secondDenom;
        }
        if (operator.contentEquals("/")) {
               finalNum = firstNum * secondDenom;
               finalDenom = firstDenom * secondNum;
        }

        while (finalNum / finalDenom >= 1) {
               finalNum -= finalDenom;
               finalWhole += 1;
        }

        while (finalNum / finalDenom <= -1) {
               finalNum += finalDenom;
               finalWhole -= 1;
        }

        if (finalWhole != 0) {
               finalNum = Math.abs(finalNum);
               finalDenom = Math.abs(finalDenom);

        }
        if (finalWhole == 0) {
               return finalNum + "/" + finalDenom;

        } else if (finalNum == 0 && finalDenom == 1) {
               return finalWhole + "";
        } else {
               return finalWhole + "_" + finalNum + "/" + finalDenom;
        }

        // TODO: Fill in the space below with any helper methods that you think you will
        // need

  }

  public static String findWhole(String str) {
        if (str.contains("_")) {
               return str.substring(0, str.indexOf('_'));
        } else if (str.contains("/")) {
               return "0";
        } else
               return str;
  }

  public static String findNum(String str) {
        if (str.contains("_")) {
               return str.substring(str.indexOf('_') + 1, str.indexOf('/'));
        } else if (str.contains("/")) {
               return str.substring(0, str.indexOf('/'));

        } else {
               return "0";
        }
  }

  public static String findDenom(String str) {
        if (str.contains("/")) {
               return str.substring(str.indexOf("/") + 1);
        } else {
               return "1";
        }
  }
}

