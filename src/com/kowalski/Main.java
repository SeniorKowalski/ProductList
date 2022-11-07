package com.kowalski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays.asList("Хлеб", "Сок", "Мясо", "Молоко",
                "Сыр", "Шоколад", "Чипсы", "Макароны", "Яйца", "Орехи");
        List<String> prodList = new ArrayList<>();


        while (true){

            System.out.println("");
            System.out.println("Выберите операцию: \n1. Добавить\n2. Показать\n3. Удалить \n4. Выход");

            try {
            String inputOperation = scanner.nextLine();
            int inputOperationInt = Integer.parseInt(inputOperation);

            if (inputOperationInt <0 || inputOperationInt >4){
                System.out.println("incorrect input");
            }

                if (inputOperationInt == 1) {
                    System.out.println("Какую покупку хотите добавить?");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    try {
                    int inputAddProduct = Integer.parseInt(scanner.nextLine());
                        if (inputAddProduct < 0 || inputAddProduct > products.size()) {
                            System.out.println("incorrect input");
                        } else {
                            prodList.add(products.get(inputAddProduct - 1));
                            System.out.println("Итого в списке покупок: " + prodList.size());
                            System.out.println("Dobavlena" + prodList);
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Не корректный ввод! Введите число от 1 до "+ products.size());
                    }
                }

            if (inputOperationInt == 2){
                System.out.println("Список покупок:");
                for (int i = 0; i < prodList.size(); i++) {
                    System.out.println((i +1) +". " + prodList.get(i));
                }

            } else if (inputOperationInt == 3){
                System.out.println("Какую покупку хотите удалить? Введите номер или название");

            } else if (inputOperationInt == 4){
                break;
            }

            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод! Введите число от 1 до 4");
            }





        }

    }
}
