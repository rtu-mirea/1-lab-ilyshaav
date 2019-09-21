package com.company;
import java.util.Scanner;

public class Array {
    private int[] arr ;

    public void InputArr(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите " + this.arr.length + " числа : ");            //заполнение массива
        for(int i =0; i <this.arr.length; i++){
            this.arr[i] = sc.nextInt();
        }
        //sc.close();
    }

    public void setArr(int[] arr) {                             //инициализация поля массивом
        this.arr = arr;
    }
    public int[] getArr() {                             //инициализация поля массивом
        return this.arr;
    }


    public void OutArr() {
        System.out.print("Массив: ");                            //Вывод массива >
        for (int itVar : this.arr)
            System.out.print( itVar + " ");
    }

    public void OutArrReverse() {
        System.out.println("Массив: ");                            //Вывод массива >
        for(int i =this.arr.length-1; i >= 0 ; i--){
                System.out.print( this.arr[i]+ " ");
             }
    }

    public int CountPower(int power) {
        int count = 0;
        int pow = power;
        for (int i =0; i< this.arr.length;i++) {
            if ( isPower( getArr()[i], pow)  ==1)
                count+=1;
        }
        return count;
    }

    static int isPower(int number, int power ) {
        double i = number;
        int check = 1;
        while (i > 1.0) {
            if (i % power != 0) {
                check = 0;
            }
            i = i / power;
        }
        return check;
    }

    public void order() {
        int first = this.getArr()[0];
        int j = 0;
        int[] arrn = new int[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            if (this.getArr()[i] > first) {
                arrn[j] = getArr()[i];
                ++j;
            }
        }
        for (int i = 0; i < this.arr.length; i++) {
            if (this.getArr()[i] <= first) {
                arrn[j] = getArr()[i];
                ++j;
            }
        }
        this.arr=arrn;
        System.out.print("Упорядоченный ");
        this.OutArr();
    }



}
