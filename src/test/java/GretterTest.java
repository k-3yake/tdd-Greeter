import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class GretterTest {
	private static final String morningGreet = "おはよう";
	private static final String dayTimeGreet = "こんにちは";
	private static final String eveningGreet = "こんばんは";

	@Test
	public void 挨拶のテスト_5時丁度の場合_おはようを返す() throws ParseException {
		doTestGreet("05:00:00.000", morningGreet);
	}

	@Test
	public void 挨拶のテスト_5時1ミリ秒の場合_おはようを返す() throws ParseException {
		doTestGreet("05:00:00.001", morningGreet);
	}

	@Test
	public void 挨拶のテスト_12時1ミリ秒前の場合_おはようを返す() throws ParseException {
		doTestGreet("11:59:59.999", morningGreet);
	}

	@Test
	public void 挨拶のテスト_12時丁度の場合_こんにちはを返す() throws Exception {
		doTestGreet("12:00:00.000", dayTimeGreet);
	}

	@Test
	public void 挨拶のテスト_12時1ミリ秒の場合_こんにちはを返す() throws Exception {
		doTestGreet("12:00:00.001", dayTimeGreet);
	}

	@Test
	public void 挨拶のテスト_18時1ミリ秒前の場合_こんにちはを返す() throws Exception {
		doTestGreet("17:59:59.999", dayTimeGreet);
	}

	@Test
	public void 挨拶のテスト_18時丁度の場合_こんばんはを返す() throws Exception {
		doTestGreet("18:00:00.000", eveningGreet);
	}

	@Test
	public void 挨拶のテスト_18時1ミリ秒の場合_こんばんはを返す() throws Exception {
		doTestGreet("18:00:00.001", eveningGreet);
	}

	@Test
	public void 挨拶のテスト_5時1ミリ秒前の場合_こんばんはを返す() throws Exception {
		doTestGreet("04:59:59.999", eveningGreet);
	}

	private void doTestGreet(final String time, String expectGreet) throws ParseException {
		IAppDate appDate = new IAppDate() {
			@Override
			public Date now() throws ParseException {
				return new SimpleDateFormat("HH:mm:ss.SSS").parse(time);
			}
		};
		String actual = new Gretter(appDate).greet();
		assertThat(actual , is(expectGreet));
	}
}