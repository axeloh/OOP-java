package patterns.delegation;

public class DistributingLogger implements ILogger {
	
	private ILogger errorLogger; 
	private ILogger warningLogger; 
	private ILogger infoLogger;
	
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
		this.errorLogger = errorLogger;
		this.warningLogger = warningLogger;
		this.infoLogger = infoLogger;
	}
	
	public void setLogger(String severity, ILogger logger) {
		if (severity.equals("info")) {
			infoLogger = logger;
		}
		else if (severity.equals("warning")) {
			warningLogger = logger;
		}
		else {
			errorLogger = logger;
		}
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		if (severity.equals("info")) {
			infoLogger.log(severity, message, exception);
		}
		else if (severity.equals("warning")) {
			warningLogger.log(severity, message, exception);
		}
		else {
			errorLogger.log(severity, message, exception);
		}
		
	}
	

}
