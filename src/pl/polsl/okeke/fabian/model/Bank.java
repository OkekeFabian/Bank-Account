package pl.polsl.okeke.fabian.model;


import pl.polsl.okeke.fabian.exceptions.BankAccountException;

/**
 * model class Bank in charge of transactions of the customer
 *
 *
 * @author Okeke Fabian
 * @version 1.0
 *
 */


public class Bank {
    /**
     * Account number of the customer
     */
    private String accountNumber;
    /**
     * Name of the customer
     */
    private String name;
    /**
     * Amount of money in the customers account
     */
    private long balance;


    //getters and setters for fields in the Bank class

    /**
     *
     * @return the account number of the User
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     *
     * @param accountNumber to set  account number to account
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name of the user is set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return balance entered by user
     */

    public long getBalance() {
        return balance;
    }

    /**
     *
     * @param balance of the user is set
     */
    public void setBalance(long balance) {
        this.balance = balance;
    }


    /**
     * Calculates the amount of money the customer deposits into his account
     * @param amt the amount of money the customer wants to deposit
     * @return the new balance after the customer deposits
     * @throws BankAccountException when the exception that the amount must not be less than or equal to zero is breached by the user
     */
    public long deposit(long amt) throws BankAccountException
    {
        if (amt <= 0) {

                throw new BankAccountException ( "unable to deposit zero źł" );
            }

        this.balance=balance+amt;
        return this.balance;


    }

    /**
     * Calculates the amount of money the customer withdraws from his account
     * @param amt the amount of money the customer wants to withdraw
     * @return true only if the amount to be withdrawn is less than balance
     * @throws BankAccountException when the exception balance must not be less than the amount in the account of the user is broken by the user
     */
    public boolean withdrawal(long amt) throws BankAccountException
    {

        if(this.balance>=amt)
        {

            this.balance-=amt;
            return true;
        }
        else
        {
            throw new BankAccountException ( "insufficient fund" );
        }
    }

    /**
     *
     * @return the information of the account information of various Users
     */
    @Override
    public String toString() {
        return "Bank{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

