package com.kowalski;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> prodList = new ArrayList<>();

        while (true) {
            System.out.println("");
            System.out.println("Выберите операцию: \n1. Добавить\n2. Показать\n3. Удалить \n4. Поиск \n5. Выход");
            try {
                String inputOperation = scanner.nextLine();
                int inputOperationInt = Integer.parseInt(inputOperation);

                if (inputOperationInt < 0 || inputOperationInt > 5) {
                    System.out.println("Incorrect input");
                } else if (inputOperationInt == 1) {
                    addProduct(scanner, prodList);
                    continue;
                } else if (inputOperationInt == 2) {
                    System.out.println("Список покупок:");
                    prodList(prodList);

                } else if (inputOperationInt == 3) {
                    deleteProduct(scanner, prodList);

                } else if (inputOperationInt == 4) {
                    searchProduct(scanner, prodList);

                } else if (inputOperationInt == 5) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
            }
        }
    }

    private static void searchProduct(Scanner scanner, List<String> prodList) {
        System.out.println("Введите текст для поиска: ");
        String inputSearchProduct = scanner.nextLine();
        prodList.stream()
                .filter(searchProduct -> searchProduct.toLowerCase().contains(inputSearchProduct.toLowerCase()))
                .forEach(searchProduct -> System.out.println((prodList.indexOf(searchProduct) + 1) + ". " + searchProduct));
    }

    private static void deleteProduct(Scanner scanner, List<String> prodList) {
        System.out.println("Какую покупку хотите удалить? Введите номер или название");
        prodList(prodList);
        String inputDeleteProduct = scanner.nextLine();

        if (prodList.remove(inputDeleteProduct)) {
            prodList.remove(inputDeleteProduct);
            System.out.println("Итого в списке покупок: " + prodList.size());
        } else if (Integer.parseInt(inputDeleteProduct) > 0 && Integer.parseInt(inputDeleteProduct) < prodList.size()) {
            prodList.remove(Integer.parseInt(inputDeleteProduct) - 1);
            System.out.println("Итого в списке покупок: " + prodList.size());
        } else {
            System.out.println("Incorrect input");
        }
    }

    private static boolean addProduct(Scanner scanner, List<String> prodList) {
        System.out.println("Какую покупку хотите добавить?");
        String inputAddProduct = scanner.nextLine();
        prodList.add(inputAddProduct);
        return false;
    }

    public static <T> void prodList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
