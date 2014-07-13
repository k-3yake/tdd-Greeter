import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;


public class SandBox {
	
	@Test
	public void Dateの仕様確認() throws Exception {
		System.out.println(new Date());
	}
	
	@Test
	public void SimpleDateFormatの仕様確認() throws ParseException{
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2014-01-02 15:05:06.789");
		System.out.println(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.get(Calendar.MILLISECOND));
	}

	@Test
	public void SimpleDateFormatの仕様確認_年月日を省略した場合() throws ParseException{
		Date date = new SimpleDateFormat("HH:mm:ss.SSS").parse("15:05:06.789");
		System.out.println(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.get(Calendar.MILLISECOND));
	}
	
	@Test
	public void デフォルトロケールの仕様確認() throws Exception {
		System.out.println(Locale.getDefault());
	}

	@Test
	public void ロケールの仕様確認_日本の場合() throws Exception {
		System.out.println(Locale.JAPAN);
		System.out.println(Locale.JAPAN.getLanguage());
		System.out.println(Locale.JAPANESE);
		System.out.println(Locale.US);
		System.out.println(Locale.US.getLanguage());
		System.out.println(Locale.ENGLISH);
	}
}