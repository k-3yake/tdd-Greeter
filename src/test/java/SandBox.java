import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}