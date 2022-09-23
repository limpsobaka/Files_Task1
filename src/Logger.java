public class Logger {
  private final String LOG_FILE;
  private final String LOG_PATH;
  private StringBuilder log;

  public Logger(String LOG_PATH, String LOG_FILE) {
    this.LOG_FILE = LOG_FILE;
    this.LOG_PATH = LOG_PATH;
    log = new StringBuilder();
  }

  public void addToLog(String text) {
    log.append(text).append("\n");
  }

  public void writeLogFile() {
    Files.writeLogFile(LOG_PATH, LOG_FILE, log.toString());
  }
}
