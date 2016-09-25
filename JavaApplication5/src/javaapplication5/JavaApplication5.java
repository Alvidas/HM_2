/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Альвидас
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        Scanner scan=null;
        try {
            scan = new Scanner(new File("in.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        }
       
        scan.useLocale(Locale.US);
    
        int a = 0;
        int b = 0;
        
        while(a == 0 || b == 0 &&scan.hasNext()){
            a = scan.nextInt();
            scan.next();
            b = scan.nextInt();
        }
        scan.close();
        
        if(a<1000 && a>0){
            if (b<1000 && b>0){
               System.out.println("Числа считаны верно."); 
            }else{
                System.out.println("в - ведено не верно!");
                System.exit(1);
            }
        }else{
            System.out.println("a - ведено не верно!");
            System.exit(1);
        }
        
        Random random = new Random();
        int x = a+random.nextInt(b);
        System.out.println(x);
        
        PrintWriter pw = new PrintWriter( new FileWriter("out.txt", true));
   
        System.out.println("Отгадайте число ["+ a + ";" + b + "]");
        
        pw.println("["+a+":"+b+"]");
        
        System.out.print("Введите количество попыток: ");
        Scanner scann = new Scanner(System.in);
        int q = scann.nextInt();
        pw.println("Количество попыток: "+q);
        
        
        for(int i=0; i<q+1; i++){
            System.out.print("Число: ");
            int w = scann.nextInt();
            if(w>x){
                System.out.println("Меньше");
                pw.println(w+" Меньше");
            }
            else if(w<x){
                System.out.println("Больше");
                pw.println(w+" Больше");
            }
            else {
                System.out.println("Верно!!!");
                pw.println(w+" Верно!!!");
                pw.println("Отгадано за: "+ i+1);
                break;
            }
           if(i==q){
               System.out.println("Нет ответа:(");
               pw.println("Нет ответа:(");
           } 
        }
    pw.close();
    scann.close();
    
    }
    
}
