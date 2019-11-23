package com.company;

public class Main {

    public static void main(String[] args) {
	
        Client us1=new Client("Anton","anton123","12345");
        Client us2=new Client("Ilya","ilyshaav","dwjg3954");
        Client us3=new Client("Evgeniy","destroyer999","09090909");

        Project pr1=new Project(us1,"The World",7);
        Project pr2=new Project(us2,"green",3);
        Project pr3=new Project(us3,"Ocean",9);

        GrandSystem grandSystem=new GrandSystem(5,40000);
        grandSystem.addProject(pr1);
        grandSystem.addProject(pr2);
        grandSystem.addProject(pr3);
        grandSystem.addUser(us1);
        grandSystem.addUser(us2);
        grandSystem.addUser(us3);

        //pr1.printProgect();/можно вывести все данные о проекте
        for (int i =0; i< grandSystem.generateResult().size(); i++){//вывод результатов конкурса, победителями считаются те-кто прошел порог баллов
            grandSystem.generateResult().get(i).printProgect();
        }

    }
}
