package com.company;

import java.io.*;
import java.util.*;


public class Main {
    private static LinkedList list;
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException, Exception, FileNotFoundException {
        System.out.println("Введите название файла");
        file_drive file = new file_drive(in.nextLine());
        int nn=0;
        while(nn !=7){
            System.out.println("Введите номер операции");
            System.out.println("1) Консольный ввод обьекта");
            System.out.println("2) Найти пациента");
            System.out.println("3) Вывести все");
            System.out.println("4) Определить, наблюдаются ли два пациента в одной поликлинике.");
            System.out.println("5) Данные по поликлинике");
            System.out.println("6) Заменить оценку в записи с заданным номером на новую");
            System.out.println("7) Выход");
            nn=Integer.parseInt(in.nextLine());
            switch(nn){
                case(1):
                    consol_input(file);
                    break;
                case(2):
                    get_rat_f(file);
                    break;
                case(3):
                    print_all(file);
                    break;
                case(4):
                    same_hospital(file);
                    break;
                case(5):
                    print_clinic(file);
                    break;
                case(6):
                    file.change();
                    file.print_charged_rat();
                    break;

                case(7):
                    return;
            }
        }
    }
    public static void consol_input(file_drive file) throws IOException {
        String CN,S,N,P,A,W,D,No;
        System.out.println("Введите номер карты");
        CN=in.nextLine();
        System.out.println("Введите фамилию пациента");
        S=in.nextLine();
        System.out.println("Введите имя пациента");
        N=in.nextLine();
        System.out.println("Введите отчество пациента");
        P=in.nextLine();
        System.out.println("Введите адрес пациента");
        A=in.nextLine();
        System.out.println("Введите место работы");
        W=in.nextLine();
        System.out.println("Введите дату последней флюорографии");
        D=in.nextLine();
        System.out.println("Введите номер поликлиники");
        No=in.nextLine();
        file.write( new Patient_Card(Integer.parseInt(CN),S,N,P,A,W,D,No));
    }
    public static void print_all(file_drive file) throws IOException {
        list=file.make_list();
        Patient_Card cur;
        for (Object value : list) {
            cur = (Patient_Card) value;
            System.out.println(cur.printing());
        }
    }
    public static void get_rat_f(file_drive file) throws IOException {
        String n;
        System.out.println("Введите номер карты");
        n=in.nextLine();
        String x = file.get_rat(n);
        if(x != "-1") {
            System.out.print(x);
        }
        else
        {
            System.out.println("Такого пациента не найдено");
        }
    }
    public static void same_hospital(file_drive file) throws IOException {
        String cn;
        System.out.println("Введите номер карты");
        cn=in.nextLine();
        if(file.check_hospital_for_2(cn,in.nextLine())){
            System.out.println("Одинаковая поликлиника");
        }
        else{
            System.out.println("не одинаковая поликлиника");
        }
    }
    public static void print_clinic(file_drive file) throws IOException {
        System.out.println("Введите поликлинику");
        list=file.patient(in.nextLine());
        Patient_Card cur;
        for (Object o : list) {
            cur = (Patient_Card) o;
            System.out.println(cur.printing());
        }
    }
    public static void change_numbers(file_drive file) throws IOException {
        Patient_Card cur;
        for (Object o : list) {
            cur = (Patient_Card) o;
            System.out.println(cur.printing());
        }
    }
}
