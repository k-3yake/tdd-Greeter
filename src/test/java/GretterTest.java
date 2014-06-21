import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class GretterTest {

	@Test
	public void 挨拶のテスト_5時丁度の場合_おはようを返す() {
		IAppDate appDate = new IAppDate() {
			@Override
			public Date now() throws ParseException {
				return new SimpleDateFormat("HH:mm:ss.SSS").parse("05:00:00.000");
			}
		};
		String actual = new Gretter(appDate).greet();
		assertThat(actual , is("おはよう"));
	}
}