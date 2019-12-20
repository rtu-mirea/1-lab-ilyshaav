package com.company;
import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException, Exception, FileNotFoundException {
        try {
            // Упражнение 1
            // Создать файл в папке приложения с именем MyFile1.txt.
            File F1 = new File("MyFile1.txt");
            F1.createNewFile();
            // Проверить появление файла в папке приложения.
            if(F1.exists()) {
                System.out.println("Существует");
            }
            else{
                System.out.println("Не Существует");
            }
            // Создать файл с именем MyFile2.txt в корне определенного диска.
            File F2 = new File("D:\\MyFile2.txt");
            F2.createNewFile();
            // Проверить появление файла в папке приложения.
            if(F2.exists()) {
                System.out.println("Существует");
            }
            else{
                System.out.println("Не Существует");
            }
            //  Создать файл с именем MyFile3.txt в папке Имя диска\\Имя папки\\Имя файла.
            File F3 = new File("D:\\for_4_laba\\MyFile3.txt");
            F3.createNewFile();
            // Проверить появление файла в папке приложения.
            if(F3.exists()) {
                System.out.println("Существует");
            }
            else{
                System.out.println("Не Существует");
            }
            // Создать папку третьего уровня, например, Первая\\Вторая\\Третья.
            File dir_for_1 = new File("D:\\Directory\\SubDirectory1\\SubDirectory2");
            dir_for_1.mkdirs();
            // Проверить появление папки.
            if(dir_for_1.exists()) {
                System.out.println("Существует");
            }
            else{
                System.out.println("Не Существует");
            }
            // Упражнение 2
            //Проверить, что вызывающий объект содержит имя файла, а не папки и
            // отобразить имя файла, вызывающего объекта и его родительскую папку.
            if(F1.isFile()){
                System.out.println("Это файл");
                System.out.println(F1.getName());
                System.out.println(F3.getParentFile().getName());
            }
            else{
                System.out.println("Это папка");
            }
            // Проверить, что вызывающий объект содержит имя папки, а не файла и
            //отобразить имя файла, вызывающего объекта.
            if(dir_for_1.isDirectory()){
                System.out.println("Это папка");
                System.out.println(dir_for_1.getName());
            }
            else{
                System.out.println("Это файл");
            }
            //	Проверить, что в папке приложения существует файл с именем MyFile1.txt
            if(F1.exists()) {
                System.out.println("Существует");
            }
            else{
                System.out.println("Не Существует");
            }
            // Отобразить полный путь к файлу или папке объекта
            System.out.println(F3.getAbsolutePath());
            //	Отобразить размер файла или папки объекта, указать единицу измерения. Прокомментировать вид файла – папка или файл.
            System.out.println("Размер: " + Long.toString(F3.length()) + " байт");
            if(F3.isFile()){
                System.out.println("Это файл");
            }
            else{
                System.out.println("Это папка");
            }
            //	Добавить в папку приложения еще одну папку.
            File dir_for_3 = new File("Directory");
            dir_for_3.mkdir();
            //	Сформировать массив файлов, находящихся в папке приложения, используя метод list(). Отобразить содержимое массива.
            // Определить количество папок, содержащихся в файле приложения.
            File dir = new File(System.getProperty("user.dir"));
            String[] file_string_list = dir.list();
            System.out.println(Arrays.toString(file_string_list));
            File[] file_file_list = dir.listFiles();
            System.out.println(Arrays.toString(file_file_list));
            int dirs = 0, files = 0;
            for (File file : file_file_list)
            {
                if(file.isDirectory()){
                    dirs++;
                }
                else{
                    files++;
                }
            }
            System.out.println("Файлов: " + files + " Директорий: " + dirs);
            //	Удалить папки и файлы созданные во всех трех упражнениях
            F1.delete();
            F2.delete();
            F3.delete();
            dir_for_1.delete();
            dir_for_3.delete();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
