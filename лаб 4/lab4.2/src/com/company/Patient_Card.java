package com.company;

public class Patient_Card {
    String  Surname, Name, Patronymic, Address, Work, Date, HospitalNum;
    int CardNumber;
    Patient_Card(int CardNumber, String Surname, String Name,String Patronymic, String Address, String Work, String Date, String HospitalNum){
        this.CardNumber=CardNumber;
        this.Surname=Surname.substring(0, 1).toUpperCase() + Surname.substring(1);
        this.Name=Name.substring(0, 1).toUpperCase() + Name.substring(1);
        this.Patronymic=Patronymic.substring(0, 1).toUpperCase() + Patronymic.substring(1);
        this.Address=Address;
        this.Work=Work;
        this.Date=Date;
        this.HospitalNum=HospitalNum;
    }
    public String printing(){
        String pr= String.valueOf(CardNumber) + " " + Surname + " " + Name + " " + Patronymic + " " + Address + " " + Work+" "+Date+" "+HospitalNum;
        return pr;
    }
}
