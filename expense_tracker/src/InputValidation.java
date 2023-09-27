import java.util.*;
import javax.swing.JOptionPane;

public class InputValidation{

    private boolean valid_amount = false;
    private boolean valid_category = false;
    private String message = "";
    
    /*This funciton validates the amount that the user enters into the amount field by converting the string input amount into an object Double
    and making sure that it is possible for the string to be converted into a number (if not an exception will be thrown). Additionally, the number
    has to follow the > 0 and < 1000 constraints, if it is not followed an exception will be thrown.
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
}