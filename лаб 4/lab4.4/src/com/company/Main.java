package com.company;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        try {
            ClassTextFile txtF = new ClassTextFile("TASK4.txt");
            System.out.println("Получение объекта из файла");
            Project Project1 = txtF.get();
            System.out.println(Project1);

            ClassSerialization CS = new ClassSerialization("TASK4_SER.txt");
            CS.writeObj(Project1);

            System.out.println();
            System.out.println("Десериализация объекта");
            System.out.println(CS.readObj());

            System.out.println();
            System.out.println("Сериализация листа объектов");

            Scanner scan = new Scanner(System.in);
            System.out.println("Введите название проекта");
            String namePr = scan.nextLine();
            System.out.println("Введите призовой фонд");
            int sum = scan.nextInt();
            System.out.println("Введите экспертную оценку");
            int expertMarK = scan.nextInt();
            ArrayList<Project> Projects = new ArrayList<>();
            Projects.add(Project1);
            Projects.add(new Project(namePr, sum, expertMarK));
            CS.setProjects(Projects);
            CS.writeArr();

            System.out.println("Десериализация листа объектов");
            CS.readArr();
            System.out.println(CS.getProjects());

            scan.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
