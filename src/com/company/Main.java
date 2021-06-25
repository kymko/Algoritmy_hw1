package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] banknotes = {1, 3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
        int[] quantites = {10, 5, 5, 3, 2, 1, 2, 3, 3, 2, 0, 2};
        int totalAvailable = 0;
        String result = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму для снятия!");
        int withdraw = scanner.nextInt();

        int remainToGive = withdraw;

        for (int i = 0; i < banknotes.length; i++) {
            totalAvailable = totalAvailable + banknotes[i] * quantites[i];
        }
        if (remainToGive > totalAvailable) {
            System.out.println("Не достаточно средств для снятия!");
        } else {
            for (int i = banknotes.length - 1; i >= 0; i--) {
                if (remainToGive >= banknotes[i]) {
                    int quantity = remainToGive / banknotes[i];
                    if (quantity <= quantites[i]) {
                        result = result + " " + quantity + " x " + banknotes[i];
                        quantites[i] = quantites[i] - quantity;
                        remainToGive = remainToGive - quantity * banknotes[i];
                        if (remainToGive == 0) {
                            break;
                        }
                    } else {
                        result = result + " " + quantites[i] + " x " + banknotes[i];
                        remainToGive = remainToGive - quantites[i] * banknotes[i];
                        quantites[i] = 0;
                    }
                }
            }
        }

        if (remainToGive == 0) {
            System.out.println("Вы получили: " + result + " Всего: " + withdraw);
        } else if (totalAvailable > withdraw - remainToGive)
            System.out.println("Вы можете снять только:" + (remainToGive));

        System.out.println("Введите годовую зарплату");
        Scanner scanner2 = new Scanner(System.in);
        int userInput = scanner2.nextInt();
        int salary = userInput;


        if (userInput > 0){
            int halfPersent= salary *50/100;
            int bonusFive = halfPersent * 5 / 100;
            System.out.println("Ваша годовая зарплата:" + userInput + " Бонус 5 %:" + bonusFive);

            halfPersent = salary*30/100;
            bonusFive = halfPersent *8/100;
            System.out.println("Ваша годовая зарплата:" + userInput + " Бонус 8 %:" + bonusFive);


            halfPersent = salary*20/100;
            bonusFive = halfPersent *10/100;
            System.out.println("Ваша годовая зарплата:" + userInput + " Бонус 10 %:" + bonusFive);

        }





    }
}
