public class Logger {
  private final String LOG_FILE;
  private StringBuilder log;

  public Logger(String LOG_FILE) {
    this.LOG_FILE = LOG_FILE;
    log = new StringBuilder();
  }

  public void addToLog(String text) {
    log.append(text).append("\n");
  }

  public void writeLogFile() {
    Files.writeLogFile(LOG_FILE, log.toString());
  }
}
