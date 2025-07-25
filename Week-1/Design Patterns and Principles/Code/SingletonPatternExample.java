class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Starting the application");
        logger2.log("Performing an operation");

        if (logger1 == logger2) {
            System.out.println("Both loggers are the same instance");
        } else {
            System.out.println("Different logger instances exist");
        }
    }
}
