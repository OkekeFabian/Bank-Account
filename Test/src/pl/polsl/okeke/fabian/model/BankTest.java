package src.pl.polsl.okeke.fabian.model;

import org.junit.Before;
import org.junit.Test;
import pl.polsl.okeke.fabian.exceptions.BankAccountException;
import pl.polsl.okeke.fabian.model.Bank;

import static org.junit.Assert.*;

public class BankTest {


    Bank bank;

    @Before
    public void setup(){
        Bank bank = new Bank ();
    }



    @Test
    public void deposit(){
        Bank bank = new Bank ();
        bank.setBalance ( 100 );
        try {
            long amount = bank.deposit ( 10 );
            assertEquals ( "check deposit",110,amount );
        } catch (BankAccountException ignored) {
            fail("There should be no exception");
        }

        try {
            bank.deposit ( 0 );
            bank.deposit ( -1 );
            fail ( "should have failed" );
        } catch (BankAccountException ignored) {

        }

    }

    @Test
    public void withdraw(){
        Bank bank = new Bank ();
        bank.setBalance ( 100 );

        try {
             bank.withdrawal ( 10 );
             assertEquals ( "withdraw",90,bank.getBalance () );
        } catch (BankAccountException ignored) {
              fail ( "could not withdraw" );
        }

        try {
            bank.withdrawal ( 0 );
            bank.withdrawal ( -1 );
      //      fail ( "should have failed" );
        } catch (BankAccountException ignored){
        }
    }
}