import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class GretterTest_parameterization {
	
	@DataPoints
	public static String[][] data = {
		{"05:00:00.000", "おはよう"},
		{"05:00:00.001", "おはよう"},
		{"11:59:59.999", "おはよう"},
		{"12:00:00.000", "こんにちは"},
		{"12:00:00.001", "こんにちは"},
		{"17:59:59.999", "こんにちは"},
		{"18:00:00.000", "こんばんは"},
		{"18:00:00.001", "こんばんは"},
		{"04:59:59.999","こんばんは"}
	};
		
	@Theory
	public void doTestGreet(final String[] data) throws ParseException {
		final int time = 0;
		final int expectGreet = 1;
		IAppDate appDate = new IAppDate() {
			@Override
			public Date now() throws ParseException {

				return new SimpleDateFormat("HH:mm:ss.SSS").parse(data[time]);
			}
		};
		String actual = new Gretter(appDate).greet();
		assertThat(actual , is(data[expectGreet]));
	}
}