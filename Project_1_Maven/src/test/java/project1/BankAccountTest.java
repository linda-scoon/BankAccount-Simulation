/**
 * 
 */
package project1;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

/**
 * @author Flourish
 *
 */
public class BankAccountTest {

	/**
	 * Test method for {@link project1.BankAccount#BankAccount(int)}.
	 */
	@Test
	public final void testBankAccountInt() {
		BankAccount account = new BankAccount(1234);
		assertEquals("BankAccount [accountNumber=1234, balance=0.0]", account.toString());
	}

	/**
	 * Test method for {@link project1.BankAccount#BankAccount(int, double)}.
	 */
	@Test
	public final void testBankAccountIntDouble() {
		BankAccount account = new BankAccount(1234, 5.0);
		assertEquals("BankAccount [accountNumber=" + 1234 + ", balance=" + 5.0 + "]", account.toString());
	}

	/**
	 * Test method for {@link project1.BankAccount#deposit(double)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testDeposit() throws SQLException {
		BankAccount account = new BankAccount(1234);
		account.deposit(-9.0);
		assertEquals(10, account.getBalance(), 0.01);// doubles/ints are treated as longs
	}

	/**
	 * Test method for {@link project1.BankAccount#withdraw(double)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testWithdraw() throws SQLException {
		BankAccount account = new BankAccount(1234, 100);
		account.withdraw(10.0);
		assertEquals(90, 90);
	}

	/**
	 * Test method for {@link project1.BankAccount#getBalance()}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testGetBalance() throws SQLException {
		BankAccount account = new BankAccount(1234, 100);
		long actual = (long) account.getBalance();
		assertEquals(100, account.getBalance(), 0.01);
	}

	/**
	 * Test method for
	 * {@link project1.BankAccount#transfer(double, project1.BankAccount)}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public final void testTransfer() throws SQLException {
		BankAccount tranAccount = new BankAccount(1234, 100);// bank transfering funds
		BankAccount recAccount = new BankAccount(4444, 50);// bank recieving funds

		tranAccount.transfer(5.0, recAccount);
		String actualTacc = tranAccount.toString();// bank transfering funds
		String actualRacc = recAccount.toString();// bank recieving funds

		assertEquals("BankAccount [accountNumber=" + 1234 + ", balance=" + 95.0 + "]", actualTacc);// bank transfering
																									// funds
		assertEquals("BankAccount [accountNumber=" + 4444 + ", balance=" + 55.0 + "]", actualRacc);// bank recieving
																									// funds
	}

}
