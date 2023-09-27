import java.util.*;
import javax.swing.JOptionPane;

public class InputValidation{

    private boolean valid_amount = false;
    private boolean valid_category = false;
    private String message = "";
    
    /*This funciton validates the amount that the user enters into the amount field by converting the string input amount into an object Double
    and making sure that it is possible for the string to be converted into a number. Additionally, the number has to follow the > 0 and < 1000 constraints.
    Input:
    String amount: This is the amount that the user entered into the amount field
    Return:
    Void
    */ 
    public void amountFunction(String amount){
        valid_amount = true;
        // Try catch block for valid numbers
        try{
            Double amt = Double.parseDouble(amount);
        }
        catch(NumberFormatException e){
            valid_amount = false;
            message = message + "Please make sure that the amount is a valid number. ";
            return;
        }

        // If input does not follow constraints, update the message
        if(Double.parseDouble(amount) < 0 || Double.parseDouble(amount) >= 1000){
            valid_amount = false;
            message = message + "The price should between 1 (inclusive) and 999 (inclusive). ";
        }
    }

    /*This funciton validates the category that the user enters into the category field checking that the category is
    one of the 5 valid categories
    Input:
    String category: This is the category that the user entered into the category field
    Return:
    Void
    */ 
    public void categoryFunction(String category){
        valid_category = true;
        // List of valid categories
        List<String> categories = Arrays.asList("food", "travel","entertainment","bills","other");
        // if the input category is not valid, update message
        if(!(categories.contains(category.toLowerCase()))){
            valid_category = false;
            message = message + "The category should be any of these: food, travel, bills, entertainment, other.";

        }
    }

    /*This funciton will throw an Arithmetic expression if either the amount or category is not valid. It will
    also open a pop up and display informtion to the user about which field is incorrect
    Input:
    None
    Return:
    Void
    */ 
    public void throwException(){
        // If input is not valid (either for amount or category), display message to user (pop up)
        if(!valid_amount || !valid_category) {
            JOptionPane.showMessageDialog(null, message);
            throw new ArithmeticException(message);
        }
    }
}