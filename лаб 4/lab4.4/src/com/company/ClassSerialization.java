
package com.company;

import java.io.*;
import java.util.ArrayList;

public class ClassSerialization {
    String path;
    ArrayList<Project> Projects;

    public ClassSerialization(String path) {
        this.path = path;
    }

    public void setProjects(ArrayList<Project> Projects) {
        this.Projects = Projects;
    }

    public void writeObj(Project pr) throws IOException{
        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path));
        OOS.writeObject(pr);

        OOS.close();
    }

    public Project readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));
        Project res = (Project)OIS.readObject();

        OIS.close();
        return res;
    }

    public void writeArr() throws IOException{
        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path));
        OOS.writeObject(Projects);

        OOS.close();
    }

    public void readArr() throws IOException, ClassNotFoundException {
        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));
        Projects = (ArrayList<Project>)OIS.readObject();

        OIS.close();
    }

    public ArrayList<Project> getProjects() {
        return Projects;
    }

}