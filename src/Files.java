import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
  private static final String DIR_CREATE_SUCCESS = "Добавлен каталог - ";
  private static final String DIR_CREATE_UNSUCCESS = "Не удалось создать каталог - ";
  private static final String FILE_CREATE_SUCCESS = "Добавлен файл - ";
  private static final String FILE_CREATE_UNSUCCESS = "Не удалось создать файл -";

  public static void makeDir(String path, Logger logger) {
    File dir = new File(path);
    if (dir.mkdir()) {
      logger.addToLog(DIR_CREATE_SUCCESS + dir);
      System.out.println(DIR_CREATE_SUCCESS + dir);
    } else {
      logger.addToLog(DIR_CREATE_UNSUCCESS + dir);
      System.out.println(DIR_CREATE_UNSUCCESS + dir);
    }
  }

  public static void makeFile(String path, String fileName, Logger logger) {
    File file = new File(path, fileName);
    try {
      if (file.createNewFile()) {
        logger.addToLog(FILE_CREATE_SUCCESS + file);
        System.out.println(FILE_CREATE_SUCCESS + file);
      } else {
        logger.addToLog(FILE_CREATE_UNSUCCESS + file);
        System.out.println(FILE_CREATE_UNSUCCESS + file);
      }
    } catch (IOException e) {
      logger.addToLog(FILE_CREATE_UNSUCCESS + file + " - " + e.getMessage());
      System.out.println(FILE_CREATE_UNSUCCESS + file + " - " + e.getMessage());
    }
  }

  public static void writeLogFile(String path, String fileName, String text) {
    File file = new File(path, fileName);
    try {
      if (file.createNewFile() || file.exists()) {
        try (FileWriter writer = new FileWriter(file, false)) {
          writer.write(text);
        } catch (IOException e) {
          System.out.println(FILE_CREATE_UNSUCCESS + file + " - " + e.getMessage());
        }
        System.out.println(FILE_CREATE_SUCCESS + file);
      } else {
        System.out.println(FILE_CREATE_UNSUCCESS + file);
      }
    } catch (IOException e) {
      System.out.println(FILE_CREATE_UNSUCCESS + file + " - " + e.getMessage());
    }
  }
}