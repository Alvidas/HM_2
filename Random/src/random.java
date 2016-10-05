import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
/**
 * Created by Альвидас on 05.10.2016.
 */
public class random {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scan=null;
        try {
            scan = new Scanner(new File("in.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
            System.exit(2);
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
        int x = a+random.nextInt(b-a);
        System.out.println(x);

        PrintWriter pw = new PrintWriter( new FileWriter("out.txt", true));

        System.out.println("Отгадайте число ["+ a + ";" + b + "]");

        pw.println("["+a+":"+b+"]");

        System.out.print("Введите количество попыток (>3,<20): ");
        Scanner scann = new Scanner(System.in);
        int q=0;
        try{
            q = scann.nextInt();
            if(q<21 && q>2){
                pw.println("Количество попыток: "+q);//3 to 20
            }else{
                System.out.println("Неверный интервал");
                System.exit(1);
            }
        }catch(InputMismatchException r){
            System.out.println("Неверное число");
            System.exit(10);
        }

        int y = q;
        int z = 0;
        for(int i=1; i<1000; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число: ");
            int w;
            int e;
            int h;
            h=i-z;
            if (sc.hasNextInt()) {
                w = sc.nextInt();
                if (w > x) {
                    e = y - i;
                    pw.println("Попытка номер: " + h);
                    System.out.println("Меньше");
                    System.out.println("Осталось попыток: " + e);
                    pw.println(w + " Меньше");
                } else if (w < x) {
                    e = y - i;
                    pw.println("Попытка номер: " + h);
                    System.out.println("Больше");
                    System.out.println("Осталось попыток: " + e);
                    pw.println(w + " Больше");
                } else {
                    System.out.println("Верно!!!");
                    System.out.println("Отгадано за: " + h);
                    pw.println(w + " Верно!!!");
                    pw.println("Отгадано за: " + h);
                    break;
                }
                if (i == y) {
                    System.out.println("Нет ответа:( Число: " + x);
                    pw.println("Нет ответа:( Число: " + x);
                    break;
                }
            } else {
                System.out.println("Число введено не верно");
                y++;
                z++;
            }
            //sc.close();
        }
        pw.close();
        scann.close();

    }
}
