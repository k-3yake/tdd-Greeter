import java.text.ParseException;
import java.util.Date;


public class AppDate implements IAppDate{

	@Override
	public Date now() throws ParseException {
		return new Date();
	}

}
