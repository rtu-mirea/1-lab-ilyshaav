
package com.company;

import java.io.*;
import java.util.Scanner;

public class ClassTextFile {
    String path;

    public ClassTextFile(String path) {
        this.path = path;
        File f = new File(path);
        if (f.exists())
            System.out.println("Файл " + f.getName() + " существует");
    }

    public Project get() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(new File(path)));
        String namePr = sc.nextLine();
        int sum = sc.nextInt();
        int expertMarK = sc.nextInt();

        sc.close();
        return new Project( namePr, sum ,expertMarK);
    }

}