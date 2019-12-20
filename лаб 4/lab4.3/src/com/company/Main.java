package com.company;


import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        upraz_1();
        upraz_2();
        upraz_3();
    }

    public static void method_output_stream(InputStream in) throws IOException {
        int x;
        while ((x = in.read()) != -1) {
            System.out.print(" " + (char) x);
        }
        System.out.println("\n=========================\n");
    }

    public static void upraz_1() throws IOException {
        try {
            File T1 = new File("T1.txt");
            File T2 = new File("T2.txt");
            Reader reader = new InputStreamReader(new FileInputStream(T1));
            Writer writer = new OutputStreamWriter(new FileOutputStream(T2, true));
            int x;
            while ((x = reader.read()) != -1) {
                writer.write((char) x);
            }
            writer.close();
        }catch (IOException  e){
            e.printStackTrace();
        }
    }
    public static void upraz_2() throws IOException {
        File A = new File("A.txt");
        File B = new File("B.txt");
        BufferedReader inb = new BufferedReader(new InputStreamReader(new FileInputStream(A)), 128);
        BufferedWriter outb  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(B)), 128);
        char buf[] = new char[128];
        int x;
        while ((x = inb.read(buf,0,128)) != -1){
            outb.write(buf);
            outb.newLine();
        }
        outb.close();
    }
    public static void upraz_3() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src\\A.txt"), "UTF-8"));
        System.out.println(Charset.defaultCharset().name());
        String s="";
        String f="";
        while ((s = in.readLine()) != null) {
            f+=s;
        }
        System.out.println(f);
        f="";
        in = new BufferedReader(new InputStreamReader(new FileInputStream("src\\B.txt"), "Windows-1251"));
        while ((s = in.readLine()) != null) {
            f+=s;
        }
        System.out.println(f);
    }
}