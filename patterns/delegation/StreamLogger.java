package patterns.delegation;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamLogger implements ILogger{
	
	private OutputStream stream;
	private String formatString;
	
	
	public StreamLogger(OutputStream stream) {
		this.stream = stream;
		formatString = "%s: %s, (%s)";
	}
	
	@Override
	public void log(String severity, String message, Exception exception) {
		if (stream == null) {
			throw new NullPointerException("Outputstream er ikke gitt.");
		}
		PrintWriter writer = new PrintWriter(stream);
		writer.write(String.format(formatString, severity, message, exception) + '\n');
		writer.flush();
		writer.close();
	}
	
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
	
	public static void main(String[] args) {
		StreamLogger logger = new StreamLogger(System.out);
		logger.log(ILogger.INFO, "Denne meldingen er til informasjon og skrives til System.out", null);
		StreamLogger logger2 = new StreamLogger(System.err);
		logger2.log(ILogger.WARNING, "Denne meldingen er til advarsel og skrives til System.err", null);
	}
	

}
