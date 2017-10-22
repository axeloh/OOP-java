package patterns.delegation;

import java.util.ArrayList;
import java.util.List;

public class FilteringLogger implements ILogger {

	ILogger logger;
	List<String> severities;
	
	public FilteringLogger(ILogger logger, String... severities) {
		this.severities = new ArrayList<>();
		this.logger = logger;
		for (int i = 0; i < severities.length; i++) {
			this.severities.add(severities[i]);
		}
	}
	
	public boolean isLogging(String severity) {
		return (severities.contains(severity));
	}
	
	public boolean setIsLogging(String severity, boolean value) {
		if (value) {
			if (!severities.contains(severity)) {
				severities.add(severity);
				return true;
			}
		}
		else {
			if (severities.contains(severity)) {
				severities.remove(severity);
				return false;
			}
		}
		return false;
	}
	
	@Override
	public void log(String severity, String message, Exception exception) {
		if (logger == null) {
			throw new NullPointerException("Logger er ikke satt.");
		}
		if (severities.contains(severity)) {
			logger.log(severity, message, exception);
		}
	}
	
	
	

}
