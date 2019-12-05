package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Main {

    public static void main(String[] args) {
        System.out.println("\nПЕРВОЕ ЗАДАНИЕ");
        Test_string();

        System.out.println("\nВТОРОЕ ЗАДАНИЕ");
        Test_stringBuffer();

        System.out.println("\nТРЕТЬЕ ЗАДАНИЕ");
        Test_regular();



    }

    static void Test_string(){
        String text = new String();
        text="12,8. 13,8. 3A,16. 15,8. 2,10. 5D,16.";
        String n ="8";//ПРОГРАММА НАЙДЕТ КОЛ_ВО ЧИСЕЛ, ИМЕЮЩИХ ЭТУ СИСТЕМУ СЧИСЛЕНИЯ
        text=  text.replace(" ","");

        String [] words = text.split("\\.|,");
        System.out.println(Arrays.toString(words));

        int count =0; int sum=0; int u =0;//СУММА ВСЕХ ЧИСЕЛ В 10-ИЧНОЙ СИСТЕМЕ СЧИСЛЕНИЯ
        for(int i =1 ; i<words.length; i++){
            u = Integer.parseInt(words[i-1], Integer.parseInt(words[i]));
            sum+=u;
            ++i;
        }
        System.out.println("сумма всех чисел в 10-ой системе счисления "+sum);

        for(int i =1; i<words.length; i++){//кол-во чисел в n-ричной системе
            if (  words[i].equals(n))
                ++count;
            ++i;
        }
        System.out.println("кол-во чисел в n-ричной системе "+count);

        String new_text ="";
        for(int i =1; i<words.length; i++){// новая строка из чисел в 16-ичной сис.исч.
            if (  words[i].equals("16"))
                new_text += ", "+words[i-1];
        }
        new_text=new_text.replaceFirst(", ", "");
        System.out.println("строка из 16-ти ричных чисел: "+ new_text);
    }

    static void Test_stringBuffer(){
        int sum=0;
        StringBuffer str_buf = new StringBuffer("");
        StringBuffer str_buf1 = new StringBuffer("");
        str_buf.append("12,8. 13,10. 3A,16. 15,8. 2,10. 5D,16.");
        String text = str_buf.substring(0,str_buf.length());
        text=  text.replace(" ","");
        String [] words = text.split("\\.|,");

        for(int i =1; i<words.length; i++){
            if ( !words[i].equals("10")){
                str_buf1.append(words[i-1]);
                str_buf1.append(",");
                str_buf1.append(words[i]);
                str_buf1.append(". ");
            }
            else {
                int num = Integer.parseInt(words[i-1]);
                str_buf1.append(Integer.toHexString(num));
                str_buf1.append(",16. ");
            }
            ++i;
        }
        System.out.println("Все числа в 10-ичной сс заменены на числа в 16-ти сс " + str_buf1);
        for(int i =1; i<words.length; i++){
            if ( words[i].equals("8")){
                int num = Integer.parseInt(words[i-1]);
                sum+=num;
            }

            ++i;
        }
        str_buf1.append( " "+sum );
        System.out.println("В конец предложения добавлена сумма чисел в 8-сс " + str_buf1);
        
    }

    static void Test_regular(){
        String word1 = "5D,16."; //слово представляет из себя код числа в случайной системе счисления вида 5D,16.
        Pattern pattern = Pattern.compile(",16");//регулярное выражение
        System.out.print("word1 является кодом числа в 16-тиричной системе счисления: ");
        System.out.println(word1.matches(".*,16\\."));

        String word2 ="aaaa bb   ccccccacdddddddd";
        word2= word2.replaceAll("[ \\t\\n\\x0B\\f\\r]", "");
        Pattern p = Pattern.compile("(.)(?=((?!\\1).)*\\1(?!.*\\1))");
        System.out.print("Обработанная строка word2: ");
        for (Matcher m = p.matcher(word2); m.find(); ) {
            System.out.print(m.group());
        }

    }


}
