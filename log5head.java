import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class log5head implements log{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BG = "\u001b[40m";
    private static log5head uniqueInstance = null;
    private log5head() {}
    public static log5head getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new log5head();
            System.out.println("Using Java "+System.getProperty("java.version")+", "+System.getProperty("os.name")+" ver "+System.getProperty("os.version")+" "+System.getProperty("os.arch")+ANSI_RESET);
        }
        return uniqueInstance;
    }
    public void info(String message) {
        System.out.println(formattedTime()+ " [info] " + message + ANSI_RESET);
    }
    public void debug(String message) {
        System.out.println(ANSI_WHITE+ formattedTime()+ " [debug] " + message + ANSI_RESET);
    }
    public void error(String message) {
        System.out.println(ANSI_RED+ formattedTime()+ " [error] " + message + ANSI_RESET);
    }
    public void warn(String message) {
        System.out.println(ANSI_YELLOW+ formattedTime()+ " [warn] " +message + ANSI_RESET);
    }
    public void fatal(String message) {
        System.err.println(ANSI_BLACK_BG+ANSI_RED+ formattedTime()+ " [FATAL] " + message + ANSI_RESET);
    }
    public String formattedTime(){
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return currentTime.format(formatter);
    }
}
