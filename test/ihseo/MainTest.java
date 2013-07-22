package ihseo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import programming.p110103.Main;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() throws IOException {
		// String INPUT_FILENAME = "samples/110103.inp";
		// String OUTPUT_FILENAME = "samples/110103.oup";
		String INPUT_FILENAME = "test/p110103/sample.in";
		String OUTPUT_FILENAME = "test/p110103/sample.out";

		// Setup
		FileInputStream in = new FileInputStream(INPUT_FILENAME);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		PrintStream oldOut = System.out;
		System.setOut(new PrintStream(out));

		// Run
		Main.main(null);
		String result = out.toString();

		// Test
		System.setOut(oldOut);

		int lineNo = 1;
		BufferedReader brForExpectedResult = new BufferedReader(new FileReader(
				OUTPUT_FILENAME));
		BufferedReader brForActualResult = new BufferedReader(new StringReader(
				result));
		String lineForExpectedResult;
		String lineForActualResult;
		while ((lineForExpectedResult = brForExpectedResult.readLine()) != null) {
			System.out.println("Trying to test line number: " + lineNo);
			lineForActualResult = brForActualResult.readLine();
			assertThat(lineForActualResult, is(lineForExpectedResult));
			lineNo++;
		}
		assertThat(brForActualResult.readLine(), is(nullValue()));
	}

}
