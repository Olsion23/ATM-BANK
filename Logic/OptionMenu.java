package Logic;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validate Login Information customer number and pin number */

    public void getLogin() throws IOException {
      int x = 1;
      do {
        try {
          data.put(1234568, 1234);
          data.put(87654321, 4321);

          System.out.println("Welcome to American Bank!");

          System.out.println("Enter Your Customer Number: ");
          setCustomerNumber(menuInput.nextInt());

          System.out.println("Enter Your Pin Number: ");
          setPinNumber(menuInput.nextInt());
        } catch (Exception e) {
          System.out.println("\n" + "Invalid character(s). Only Numbers" + "\n");
          x = 2;
        }
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
          if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber());
          getAccountType();
        }
        System.out.println("\n" + "Wrong Customer Number Or Pin Number" + '\n');
      } while (x == 1);
    }
    /* Display Account Type Menu */
  public void getAccountType(){
    System.out.println("Select The Account You Want To Access: ");
    System.out.println("Type 1 - Checking Account");
    System.out.println("Type 2 - Saving Account");
    System.out.println("Type 3 - Exit");
    System.out.println("Choice: ");
    int selection = menuInput.nextInt();
    switch (selection){
      case 1:
        getChecking();
        break;
      case 2:
        getSaving();
        break;
      case 3:
        System.out.println("Thank You For Choosing American Bank, Bye!");
        break;
      default:
        System.out.println("Invalid Choice" + "\n");
        getAccountType();
    }
  }
  /* Display Checking Account Menu WIth Selection */
  public void getChecking(){
    System.out.println("Checking Account: ");
    System.out.println("Type 1 - View Balance");
    System.out.println("Type 2 - Withdraw Funds");
    System.out.println("Type 3 - Deposit Funds");
    System.out.println("Type 4 - Exit");
    System.out.println(" Choice: ");
    int selection = menuInput.nextInt();
    switch (selection){
      case 1:
        System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
        getAccountType();
        break;
      case 2:
        getCheckingWithdrawInput();
        getAccountType();
        break;
      case 3:
        getCheckingDepositInput();
        getAccountType();
        break;
      case 4:
        System.out.println("Thank You For Choosing American Bank!");
        break;
      default:
        System.out.println("Invalid Choice" + "\n");
        getChecking();
    }
  }
  /* Display Saving Account Menu With Selections */
  public void getSaving(){
    System.out.println("Saving Account: ");
    System.out.println("Type 1 - View Balance");
    System.out.println("Type 2 - Withdraw Funds");
    System.out.println("Type 3 - Deposit Funds");
    System.out.println("Type 4 - Exit");
    System.out.println(" Choice: ");

    int selection = menuInput.nextInt();
    switch (selection){
      case 1:
      System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
      getAccountType();
      break;
      case 2:
        getSavingWithdrawInput();
        getAccountType();
        break;
      case 3:
        getCheckingDepositInput();
        getAccountType();
        break;
      case 4:
        System.out.println("Thank You For Choosing American Bank");
        break;
      default:
        System.out.println("Invalid Choice" + "\n");
        getSaving();
    }
  }

}
