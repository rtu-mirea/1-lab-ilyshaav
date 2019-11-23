package com.company;

 class Project{
     Client autor;
     String namePr;
     int sum;
     int expertMarK;

     public Project(){
      autor=new Client("","",""); namePr=""; sum=0; expertMarK=0;
     }
     public Project(Client client1,String namePr1, int expertMarK1 ){
      autor=client1; namePr=namePr1; sum=0; expertMarK=expertMarK1;
     }

  public Client getAutor() {
   return autor;
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
  public void printProgect(){
      System.out.println("проект "+this.namePr+"\n разработал "+this.autor.getName()+"\n баллов набрал: "+ this.getExpertMarK()+"\n получил приз в размере: "+this.getSum()+" руб.\n");
  }

 }
