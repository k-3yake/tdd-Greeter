import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Gretter {
	private IAppDate appDate;
	final Integer morningStart = 50000000;
	final int dayTimeStart = 120000000;
	final int eveningStart = 180000000;
	
	public Gretter(IAppDate appDate) {
		this.appDate = appDate;
	}

	public String greet() throws ParseException {
		Integer time = Integer.parseInt(new SimpleDateFormat("HHmmssSSS").format(appDate.now()));
		if(morningStart <= time && time < dayTimeStart){
			return "おはよう";
		} else if(dayTimeStart <= time && time < eveningStart){
			return "こんにちは";
		}else{
			return "こんばんは";
		}
	}
}