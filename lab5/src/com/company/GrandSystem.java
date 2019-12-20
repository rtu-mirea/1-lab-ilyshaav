package com.company;
import java.util.ArrayList;


public class GrandSystem {
    ArrayList<Project> projects;
    int minsum;
    int grandfond;

    public GrandSystem(int minsum1, int grandfond1){
        projects = new ArrayList();
        minsum= minsum1;
        grandfond =grandfond1;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project1){
        projects.add(project1);
    }

    public ArrayList<Project> generateResult(){
        ArrayList<Project> winprojects= this.getProjects();
        int sumnum=0;

        for (int i =0; i<winprojects.size();i++ )
            if (winprojects.get(i).getExpertMarK() <= this.minsum)
            {
                winprojects.remove(i);
                i--;
            }
        for (int i =0; i<winprojects.size();i++ )
            sumnum+=winprojects.get(i).getExpertMarK();
        int money=this.grandfond/sumnum;

        for (int i =0; i<winprojects.size();i++ ){
            int x=0;
            x=winprojects.get(i).getExpertMarK()*money;
            winprojects.get(i).setSum(x);
        }
        return winprojects;//лист победителей. Победители- те, кто прошел порог по баллам, между ними и распределяется призовой фонд
    }
}