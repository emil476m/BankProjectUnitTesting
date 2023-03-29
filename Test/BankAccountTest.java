import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {


    @Test
    void testValidConstructor(){
        // Arrange - setup our test objects etc.
        int aCNumber = 42;
        int initialBalance = 231567543;
        BankAccount ba = new BankAccount(aCNumber, initialBalance);

        // Act + assert
        BankAccount notExpectedresult = null;

        // extra assert
        Assertions.assertNotEquals(notExpectedresult, ba);

    }


    @Test
    void getAccountNumber() {
        // Arrange - setup our test objects etc.
        int aCNumber = 42;
        BankAccount ba = new BankAccount(aCNumber);

        // Act + assert
        int actualACNumber = ba.getAccountNumber();
        int expectedACNumber = aCNumber;


        // extra assert
        Assertions.assertEquals(expectedACNumber, actualACNumber);
    }

    @Test
    void testValidDeposit() {
        // Arrange - setup our test objects etc.
        int aCNumber = 42;
        int initialBalance = 0;
        BankAccount ba = new BankAccount(aCNumber, initialBalance);

        // Act + assert

        double expectedACBalance = 66666666.124123;
        ba.deposit(expectedACBalance);
        double actualACBalance = ba.getBalance();


        // extra assert
        Assertions.assertEquals(expectedACBalance, actualACBalance);


    }

    @Test
    void testValidWithdraw() {
        // Arrange - setup our test objects etc.
        int aCNumber = 42;
        double initialBalance = 6000.43;
        BankAccount ba = new BankAccount(aCNumber, initialBalance);

        // Act + assert

        double withdrawAmount = 3000.01;
        double expectedACBalance = 3000.42;
        ba.withdraw(withdrawAmount);
        double actualACBalance = ba.getBalance();


        // extra assert
        Assertions.assertEquals(expectedACBalance, actualACBalance);
    }

    @Test
    void testValidSetInterestRate() {
        // Arrange - setup our test objects etc.
        int aCNumber = 42;
        int initialBalance = 0;
        BankAccount ba = new BankAccount(aCNumber, initialBalance);

        // Act + assert

        double newACInterestRate = 10;
        double expectedACInterestRate = 0.1;
        ba.setInterestRate(newACInterestRate);
        double actualACInterestRate = ba.getInterestRate();


        // extra assert
        Assertions.assertEquals(expectedACInterestRate, actualACInterestRate);

        // Act + assert

        double newACInterestRateV2 = 0.03;
        double expectedACInterestRateV2 = 0.03;
        ba.setInterestRate(newACInterestRateV2);
        double actualACInterestRateV2 = ba.getInterestRate();


        // extra assert
        Assertions.assertEquals(expectedACInterestRateV2, actualACInterestRateV2);
    }

    @Test
    void testInValidSetInterestRate() {
        // Arrange - setup our test objects etc.
        int aCNumber = 42;
        int initialBalance = 0;
        BankAccount ba = new BankAccount(aCNumber, initialBalance);

        // Act + assert
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ba.setInterestRate(10.9);
        });

        String expectedMessage = "Not a proper interest rate. What are you? a loanshark?";
        String actualMessage = ex.getMessage();

        // extra assert
        Assertions.assertEquals(expectedMessage, actualMessage);

        // Act + assert
        Exception exV2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ba.setInterestRate(0.9);
        });

        String expectedMessageV2 = "Not a proper interest rate. What are you? a loanshark?";
        String actualMessageV2 = exV2.getMessage();

        // extra assert
        Assertions.assertEquals(expectedMessageV2, actualMessageV2);
    }

    @Test
    void testValidAddInterest() {
        // Arrange - setup our test objects etc.
        int aCNumber = 42;
        double initialBalance = 6000;
        BankAccount ba = new BankAccount(aCNumber, initialBalance);

        // Act + assert

        // Default interest is 0.01, (6000 * 0.01) + 6000 = 6060

        double expectedACBalance = 6060;
        ba.addInterest();
        double actualACBalance = ba.getBalance();


        // extra assert
        Assertions.assertEquals(expectedACBalance, actualACBalance);
    }
}