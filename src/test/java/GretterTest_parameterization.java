import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GretterTest_parameterization {

	@RunWith(Theories.class)
	public static class 時間帯ごとの挨拶のテスト {
		
		private static final String morningGreet = "おはよう";
		private static final String dayTimeGreet = "こんにちは";
		private static final String eveningGreet = "こんばんは";
		
		@DataPoints
		public static String[][] data = {
			{"05:00:00.000", morningGreet},
			{"05:00:00.001", morningGreet},
			{"11:59:59.999", morningGreet},
			{"12:00:00.000", dayTimeGreet},
			{"12:00:00.001", dayTimeGreet},
			{"17:59:59.999", dayTimeGreet},
			{"18:00:00.000", eveningGreet},
			{"18:00:00.001", eveningGreet},
			{"04:59:59.999", eveningGreet}
		};
			
		@Theory
		public void 朝昼晩の時間帯で挨拶は変わる(final String[] data) throws ParseException {
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
}