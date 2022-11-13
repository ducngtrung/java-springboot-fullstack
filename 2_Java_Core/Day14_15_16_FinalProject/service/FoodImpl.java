package service;

import java.util.List;
import java.util.Scanner;

import model.Food;
import model.Shop;
import repository.Repository;
import view.IFood;

public class FoodImpl implements IFood {

    public List<Shop> getShopList() {
        return Repository.shopList;
    }

    @Override
    public void searchFood(Scanner scanner) {
        System.out.println("\n===== TIM KIEM MON AN =====");
        System.out.println();
        System.out.print("Nhap tu khoa can tim theo ten mon:\n\t");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("Ket qua tim kiem:");
        System.out.printf("\t%-10s", "ID shop");
        System.out.printf("%-25s", "Ten shop");
        System.out.printf("%-10s", "ID mon");
        System.out.printf("%-25s", "Ten mon");
        System.out.printf("%-15s", "Don gia (VND)");
        System.out.printf("%-15s", "So luong ton");
        System.out.println();

        boolean isFound = false;
        for (Shop shop: getShopList()) {
            for (Food food: shop.getFoodList()) {
                if (food.hasKeyword(keyword)) {
                    System.out.printf("\t%-10s", shop.getId());
                    System.out.printf("%-25s", shop.getName());
                    food.display();
                    System.out.println();
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("\t(Khong co mon nao)");
        }
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }
}