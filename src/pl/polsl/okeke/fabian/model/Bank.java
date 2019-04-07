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
     * @param accountNumber to give number to account
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }



    /**
     * Calculates the amount of money the customer deposits into his account
     * @param amt the amount of money the customer wants to deposit
     * @return the new balance after the customer deposits
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

    @Override
    public String toString() {
        return "Bank{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

