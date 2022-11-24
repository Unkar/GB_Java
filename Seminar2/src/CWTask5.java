//Напишите метод, который вернет содержимое текущей папки в виде массива строк.
//        Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
//        Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class CWTask5 {
    public static void main(String[] args) {
        String[] files = getFiles();
        writeFiles(files);
    }

    private static String[] getFiles() {
        File file = new File("C:\\Users\\User\\Desktop\\Seminar2\\src");
        return file.list();
    }

    private static void writeFiles(String[] files) {
        try (FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\Seminar2\\src\\files.txt")) {
            for (String file : files) {
                writer.write(file + "\n");
            }
        } catch (IOException e) {
            try (FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\Seminar2\\src\\log.txt")) {
                writer.write(e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }