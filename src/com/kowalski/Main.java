package com.kowalski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays.asList("Хлеб", "Сок", "Мясо", "Молоко",
                "Сыр", "Шоколад", "Чипсы", "Макароны", "Яйца", "Орехи", "Хлебные сушки", "Хлебные палочки");

        List<String> prodList = new ArrayList<>();

        while (true){
            System.out.println("");
            System.out.println("Выберите операцию: \n1. Добавить\n2. Показать\n3. Удалить \n4. Поиск \n5. Выход");

            try {
            String inputOperation = scanner.nextLine();
            int inputOperationInt = Integer.parseInt(inputOperation);

            if (inputOperationInt <0 || inputOperationInt >5){
                System.out.println("Incorrect input");
            }
                if (inputOperationInt == 1) {
                    System.out.println("Какую покупку хотите добавить?");
                    prodList(products);

                    try {
                    int inputAddProduct = Integer.parseInt(scanner.nextLine());

                        if (inputAddProduct < 0 || inputAddProduct > products.size()) {
                            System.out.println("Incorrect input");
                        } else {
                            prodList.add(products.get(inputAddProduct - 1));
                            System.out.println("Итого в списке покупок: " + prodList.size());
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Не корректный ввод! Введите число от 1 до "+ products.size());
                    }
                }

            if (inputOperationInt == 2){
                System.out.println("Список покупок:");
                prodList(prodList);

            } else if (inputOperationInt == 3){
                System.out.println("Какую покупку хотите удалить? Введите номер или название");
                prodList(prodList);
                String inputDeleteProduct = scanner.nextLine();

                if (prodList.remove(inputDeleteProduct)) {
                    prodList.remove(inputDeleteProduct);
                    System.out.println("Итого в списке покупок: " + prodList.size());
                } else if (Integer.parseInt(inputDeleteProduct) > 0 && Integer.parseInt(inputDeleteProduct) < prodList.size()){
                    prodList.remove(Integer.parseInt(inputDeleteProduct) -1);
                    System.out.println("Итого в списке покупок: " + prodList.size());
                } else {
                    System.out.println("Incorrect input");
                }

            } else if (inputOperationInt == 4){
                System.out.println("Введите текст для поиска: ");
                String inputSearchProduct = scanner.nextLine();
                products.stream()
                        .filter(searchProduct -> searchProduct.toLowerCase().contains(inputSearchProduct.toLowerCase()))
                        .forEach(searchProduct -> System.out.println((products.indexOf(searchProduct) +1) + ". " + searchProduct));

            } else if (inputOperationInt == 5){
                break;
            }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
            }
        }
    }

    public static <T> void prodList(List<T> list){
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
