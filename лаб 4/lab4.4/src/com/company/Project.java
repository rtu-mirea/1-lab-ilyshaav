package com.company;

import java.io.Serializable;

public class Project implements Serializable {

    String namePr;
    int sum;
    int expertMarK;

    Project(String namePr, int sum, int expertMarK){
        this.namePr = namePr;
        this.sum = sum;
        this.expertMarK = expertMarK;
    }

    public void setnamePr(String namePr) {
        this.namePr = namePr;
    }

    public void setsum(int sum) {
        this.sum = sum;
    }

    public void setexpertMarK(int expertMarK)  {
        this.expertMarK = expertMarK;
    }

    @Override
    public String toString() {
        return "{Название: " + namePr +" Призовой фонд: " + sum + " Экспертная оценка: " + expertMarK + "}";
    }

}