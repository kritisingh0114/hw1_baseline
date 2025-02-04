import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // create a new InputValidation object
      InputValidation validator = new InputValidation();

      //validate input for amount (after converting amount to string)
      validator.amountFunction(String.valueOf(amount));

      //validate input for category (after converting amount to string)
      validator.categoryFunction(category);

      //Throw exception if needed
      validator.throwException();

      // Call controller to add transaction
      view.addTransaction(t);
    });

  }

}