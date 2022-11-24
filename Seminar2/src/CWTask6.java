//Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
//        1 Расширение файла: txt
//        2 Расширение файла: pdf
//        3 Расширение файла:
//        4 Расширение файла: jpg

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CWTask6 {
    public static getFileTitle(String[] files) {
        for (String file : files) {
            if (file.contains(".")) {
                System.out.println(file.substring(file.lastIndexOf(".") + 1));
            } else {
                System.out.println("No extension");
            }
        }
    }

}
