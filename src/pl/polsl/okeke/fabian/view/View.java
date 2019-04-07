package pl.polsl.okeke.fabian.view;


import pl.polsl.okeke.fabian.model.Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *View class handling UI
 *
 * @author Okeke Fabian
 * @version 1.0
 */
public class View {
    /**
     * Scanner used for reading from standard input stream
     */
    private final Scanner scanner = new Scanner ( System.in );

    /**
     * Instructs the user on what to enter about the instructions and transactions available to him
     */
    public void nextTransaction() {
        System.out.println ( "***************************" );
        System.out.println ( "Please enter a number from 1 to 6 to proceed to a transaction" );
    }

    /**
     * Options available for the user to select
     */
    public void options() {
        System.out.println ( "Main Menu\n 1.Add Account \n 2.Check balance \n 3.Deposit\n 4.Withdrawal\n 5.Check all accounts \n 6.Exit " );
        nextTransaction ();
    }

    /**
     * Read single integer used by the user to decide actions
     * while to keep on running even after the exception is caught
     * @return int  value
     * @throws InputMismatchException thrown if the given amount is not an integer
     */
    public int readInt() {

        while(true){
            try {
                return scanner.nextInt ();
            } catch (InputMismatchException e){
                System.out.println ("Please enter an Integer");
                scanner.next();
                }
            }

    }

    /**
     * Read string used by the user to decide account number and name
     *
     * @return int  value
     * @throws InputMismatchException thrown if the given name or account number entered is not a string
     */
    public String readString(){
        try {
            return scanner.next ();
        } catch (InputMismatchException e){
            return "Please enter a String  next time";
        }
    }

    /**
     * Used to create the account of the user
     * @param bank takes attributes and adds to Bank class
     */
    public Bank createAccount(Bank bank){
        System.out.println ( "Enter Account No: " );
        bank.setAccountNumber (readString ());
        System.out.println( "Enter Name: " );
        bank.setName (readString ());
        System.out.print ( "Enter Balance: " );
        bank.setBalance (readInt () );

        System.out.println ( bank.getAccountNumber () + "," + bank.getName () + "," + bank.getBalance ());
        return bank;
     }



    /**
     * Displays balance of the user on standard output
     * @param bank taking from the Bank class and saving the field bank
     */
    public void displayBalance(Bank bank){
        System.out.println (bank.getAccountNumber ()+","+bank.getName ()+","+"your current balance is "+bank.getBalance ());
    }

    /**
     * Displays message on standard output
     * @param message to display system output of transactions
     */
    public void displayMessage(String message){
        System.out.println (message);
    }

}
