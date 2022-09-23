public class Main {
  public static void main(String[] args) {
    String startPath = "D://Game";
    String log = "temp.txt";
    String[] level1Dirs = {"src", "res", "savegames", "temp"};
    String[] srcDirs = {"main", "test"};
    String[] fileList = {"Main.java", "Utils.java"};
    String[] resDirs = {"drawables", "vectors", "icons"};

    String path = startPath;

    Logger logger = new Logger(startPath + "//" + log);
    Files.makeDir(path, logger);

    for (String d : level1Dirs) {
      path = startPath + "//" + d;
      Files.makeDir(path, logger);
    }
    for (String d : srcDirs) {
      path = startPath + "//src//" + d;
      Files.makeDir(path, logger);
    }
    for (String f : fileList) {
      path = startPath + "//src//main//";
      Files.makeFile(path + "//" + f, logger);
    }
    for (String d : resDirs) {
      path = startPath + "//res//" + d;
      Files.makeDir(path, logger);
    }
    logger.writeLogFile();
  }
}
