package pl.polsl.okeke.fabian.exceptions;

/**
 * To throw exception related to bank account
 *
 * @author Okeke Fabian
 * @version 1.0
 *
 */
public class BankAccountException extends Exception {


    /**
     *
     * @param message ships the messages from exceptions.
     */
    public BankAccountException(String message) {

        super(message);
    }

}
