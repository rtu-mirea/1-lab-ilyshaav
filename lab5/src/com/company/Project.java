package com.company;

class Project{

    String namePr;
    int sum;
    int expertMarK;

    public Project(){
         namePr=""; sum=0; expertMarK=0;
    }
    public Project(String namePr1, int expertMarK1 ){
         namePr=namePr1; sum=0; expertMarK=expertMarK1;
    }

    public String getNamePr() {
        return namePr;
    }

    public int getSum() {
        return sum;
    }

    public int getExpertMarK() {
        return expertMarK;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "проект "+this.namePr+"\n баллов набрал: "+ this.getExpertMarK()+"\n получил приз в размере: "+this.getSum()+" руб.\n";
    }

    public void printProgect(){
        System.out.println("проект "+this.namePr+"\n баллов набрал: "+ this.getExpertMarK()+"\n получил приз в размере: "+this.getSum()+" руб.\n");
    }

}