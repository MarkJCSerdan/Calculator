package Calculator;

import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);
    double n1, n2, total=0;
    byte op;
    char res;
    Calculator(){

        getData();

        do{
            popTryAgain();

        }while (popTryAgain()==3);

    }

    void getData(){
        System.out.println("Calculator");
        System.out.print("Enter first number: ");
        n1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        n2 = sc.nextDouble();
        System.out.println("Select operator");

        do {
            System.out.println("1. Addition\n2.Subtraction\n3.Multiplication\n4.Division");
            op = sc.nextByte();
        } while (op <= 0 || op >= 5);

        switch (op) {
            case 1:
                total = n1 + n2;
                break;
            case 2:
                total = n1 - n2;
                break;
            case 3:
                total = n1 * n2;
                break;
            case 4:
                total = n1 / n2;
                break;
        }
        System.out.println(total);
    }

    int popTryAgain(){
        System.out.print("Try again? y/n");
        res = sc.next().charAt(0);
        if(res=='y' || res=='Y') {
            getData();
        }else if(res=='n' || res=='N'){
            System.out.println("Hope it helps!");
            System.exit(0);
        }
        return 3;
    }
}
