package project1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * @author Flourish
 *
 */
public class AppTest {

	@Test
	public void test() {
		PrintStream oldOut = System.out;
		OutputStream testOS = new ByteArrayOutputStream();
		PrintStream testOut = new PrintStream(testOS);
		System.setOut(testOut);
		App.main(null);
		assertEquals(testOS.toString().trim(), "Hello World!");
		System.setOut(oldOut);
	}

}
