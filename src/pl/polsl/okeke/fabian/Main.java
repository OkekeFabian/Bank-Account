package pl.polsl.okeke.fabian;
import pl.polsl.okeke.fabian.exceptions.BankAccountException;
import pl.polsl.okeke.fabian.view.View;
import pl.polsl.okeke.fabian.model.Bank;
import java.util.*;


/**
 * Main class playing the role of a controller
 *
 * @author Okeke Fabian
 * @version 1.0
 */

public class Main {
    /**
     * Main program method
     *
     * @param args
     */
    public static void main(String[] args) {
        View view = new View ();

        int amt;

        TreeMap <String, Bank> bankTreeMap = new TreeMap <> ();

        int ch;
        if(args.length == 3) {
            Bank bank = new Bank ();
            bank.setAccountNumber ( args[0] );
            bank.setName ( args[1] );
            try {
                bank.setBalance ( Integer.parseInt ( args[2] ) );
            } catch(NumberFormatException e) {
                bank.setBalance ( 0 );
            }
            bankTreeMap.put ( bank.getAccountNumber (), bank );
        }
        do {
            view.options ();
            ch = view.readInt ();
            Bank temp;
            switch (ch) {
                case 1:
                    Bank bank = new Bank ();
                    temp = view.createAccount ( bank );
                    bankTreeMap.put ( temp.getAccountNumber (), temp );
                    break;

                case 2:
                    view.displayMessage ( "enter your account number" );
                    bank = bankTreeMap.get ( view.readString () );
                    view.displayBalance ( bank );
                    view.nextTransaction ();
                    break;


                case 3:
                    view.displayMessage ( "enter your account number" );
                    bank = bankTreeMap.get ( view.readString () );
                    view.displayMessage ( "Enter amount to be deposited " );
                    amt = view.readInt ();
                    try {
                        bank.deposit ( amt );
                        view.displayMessage ( "you have deposited " + amt );
                    } catch (BankAccountException e) {
                        view.displayMessage ( e.getMessage () );
                    }
                    view.nextTransaction ();
                    break;

                case 4:
                    view.displayMessage ( "Enter Amount U Want to withdraw : " );
                    amt = view.readInt ();
                    view.displayMessage ( "enter your account number" );
                    bank = bankTreeMap.get ( view.readString () );
                    try {
                        bank.withdrawal ( amt );
                        view.displayMessage ( "you have withdrawn " + amt );
                    } catch (BankAccountException e) {
                        view.displayMessage ( e.getMessage () );
                    }
                    view.nextTransaction ();
                    break;


                case 5:
                    for (Bank acct : bankTreeMap.values ()) {
                        view.displayMessage ( acct.toString ());
                    }
                    view.nextTransaction ();
                    break;

                case 6:
                    view.displayMessage ( "Good Bye.." );
                    break;



            }
        } while (ch != 5);  //run loop until menu 5 is  pressed

    }
}
