package com.company;
import java.io.*;
import java.util.*;

public class file_drive {
    static File file;
    DataOutputStream outfile;
    static DataInputStream infile;
    RandomAccessFile rand_ac;
    static final int lengthrecord=40;
    String y;
    file_drive(String name) throws IOException {
        file = new File(name);
        outfile = new DataOutputStream(new FileOutputStream(file,true));
        infile = new DataInputStream(new FileInputStream(file));
        rand_ac = new RandomAccessFile("file_for_raac.txt", "rw");
        if(file.exists()){
            System.out.println("Файл существует");
        }
        else
        {
            if(file.createNewFile()){
                System.out.println("Файл успешно создан");
            }
            else
            {
                System.out.println("Файл не создан");
            }
        }
    }
    static String[] make_split() throws IOException {
        infile = new DataInputStream(new FileInputStream(file));
        String temp = "";
        try {
            while (true) {
                temp += infile.readUTF();
            }
        }catch(EOFException e){}
        catch(IOException e){
            System.out.println("Достигнут конец файла");
        }
        return temp.split(";");
    }
    LinkedList make_list() throws IOException {
        LinkedList<Patient_Card> list= new LinkedList<Patient_Card>();
        String[] splitted=make_split();
        int len=splitted.length-1;
        for (int i=0;i<len;i+=8){
            list.add(new Patient_Card(Integer.parseInt(splitted[i]),splitted[i+1],splitted[i+2],splitted[i+3],splitted[i+4],splitted[i+5],splitted[i+6],splitted[i+7]));
        }
        return list;
    }
    void write(Patient_Card obj) throws IOException {
        String temp = obj.CardNumber + ";" + obj.Surname + ";" + obj.Name + ";" + obj.Patronymic + ";" + obj.Address + ";"+ obj.Work + ";"+ obj.Date + ";"+ obj.HospitalNum + ";";
        outfile.writeUTF(temp);
    }
    void close() throws IOException {
        outfile.close();
    }
    String get_rat(String num) throws IOException {
        String[] splitted=make_split();
        int len=splitted.length-1;
        for (int i=0;i<len;i+=6){
            if(splitted[i].equals(num)){
                return (splitted[i+1]+" "+splitted[i+2]+" "+" "+splitted[i+3]);
            }
        }
        return "-1";
    }
    void print_charged_rat() throws IOException {

        FileInputStream infile_raac = new FileInputStream("file_for_raac.txt");
        String temp = "";
        int x;
        while ((x = infile_raac.read())!=-1){
            temp += ((char)x);
        }
        System.out.println(temp);
    }
    Boolean check_hospital_for_2(String cn1,String cn2) throws IOException {
        String clinic_1 = null,clinic_2 = null;
        String[] splitted=make_split();
        int len=splitted.length-1;
        for (int i=0;i<len;i+=8){
            if(splitted[i].equals(cn1)){
                clinic_1=splitted[i + 7];
            }
            if(splitted[i].equals(cn2)){
                clinic_2=splitted[i + 7];
            }
        }
        return clinic_1.equals(clinic_2);
    }
    LinkedList patient(String clnc) throws IOException {
        LinkedList<Patient_Card> list= new LinkedList<Patient_Card>();
        String[] splitted=make_split();
        int len=splitted.length-1;
        for (int i=0;i<len;i+=8){
            if(splitted[i+7].equals(clnc)){
                list.add(new Patient_Card(Integer.parseInt(splitted[i]),splitted[i+1],splitted[i+2],splitted[i+3],splitted[i+4],splitted[i+5],splitted[i+6],splitted[i+7]));
            }
        }
        return list;
    }
    void change() throws IOException{
        LinkedList<Patient_Card> list1= new LinkedList<Patient_Card>();
        String t="                                                                                                                              ";
        int l;
        String[] splitted=make_split();
        int len=splitted.length-1;
        for (int i=0;i<len;i+=8) {
            if (Integer.parseInt(splitted[i]) % 2 != 0) {
                list1.add(new Patient_Card(Integer.parseInt(splitted[i])+10,splitted[i+1],splitted[i+2],splitted[i+3],splitted[i+4],splitted[i+5],splitted[i+6],splitted[i+7]));
            }
        }
        for(Patient_Card element : list1){
            rand_ac.writeBytes(element.printing() + "\n");
        }
    }
}

