package Day10_ArrayList.Quan_Ly_San_Pham;

import java.util.ArrayList;
import java.util.Scanner;

// Viết chương trình quản lý sản phẩm của một cửa hàng gồm các thông tin:
//     id, tên sản phẩm , mô tả, số lượng, giá bán, đơn vị tính
// 1 - Xem danh sách sản phẩm
// 2 - Tìm sản phẩm theo tên
// 3 - Tìm sản phẩm theo id để:
//     3.1: Xóa sản phẩm
//     3.2: Cập nhật số lượng sản phẩm
// 4 - Tìm các sản phẩn có số lượng dưới 5
// 5 - Tìm sản phẩm theo mức giá:
//     5.1: Dưới 50.000
//     5.2: Từ 50.000 đến dưới 100.000
//     5.3: Từ 100.000 trở lên

public class ProductManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("001", "scissors", 15, 15000, "pair"));
        productList.add(new Product("002", "notebook", 10, 60000, "dozen"));
        productList.add(new Product("003", "headphone", 5, 2000000, "set"));
        productList.add(new Product("004", "wine", 7, 750000, "bottle"));
        productList.add(new Product("005", "perfume", 3, 4500000, "bottle"));
        productList.add(new Product("006", "toothpaste", 25, 30000, "tube"));
        productList.add(new Product("007", "paper", 2, 75000, "roll"));

        System.out.println("\n===================================");
        System.out.println("1 - XEM DANH SACH SAN PHAM");
        displayProductList(productList);
        pause(scanner);

        System.out.println("\n===================================");
        System.out.println("2 - TIM SAN PHAM THEO TEN");
        System.out.print("Nhap keyword can tim:\n\t");
        String keyword = scanner.nextLine();
        boolean isFound = false;
        for (Product product: productList) {
            if (product.hasKeywordName(keyword)) {
                product.display();
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\t(Khong tim thay)");
        }
        pause(scanner);
        
        System.out.println("\n===================================");
        System.out.println("3 - TIM SAN PHAM THEO ID");
        System.out.print("Nhap id can tim:\n\t");
        String idToSearch = scanner.nextLine();
        isFound = false;
        for (Product product: productList) {
            if (product.hasKeywordID(idToSearch)) {
                product.display();
                isFound = true;
                System.out.println("[3.1] Xoa san pham theo id nay");
                System.out.println("[3.2] Cap nhat so luong san pham theo id nay");
                System.out.print("Vui long chon:\n\t");
                String selectedMenu = scanner.nextLine();
                switch (selectedMenu.toLowerCase()) {
                    case "3.1": {
                        productList.remove(product);
                        System.out.println("Product removed");
                        displayProductList(productList);
                        break;
                    }
                    case "3.2": {
                        System.out.print("Nhap so luong moi: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine();
                        product.setQuantity(newQuantity);
                        System.out.println("Product updated");
                        product.display();
                        displayProductList(productList);
                        break;
                    }
                }
            }
        }
        if (isFound==false) {
            System.out.println("\t(Khong tim thay)");
        }
        pause(scanner);
        
        System.out.println("\n===================================");
        System.out.println("4 - TIM SAN PHAM CO SO LUONG DUOI 5");
        isFound = false;
        for (Product product: productList) {
            if (product.getQuantity() < 5) {
                product.display();
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\t(Khong tim thay)");
        }
        pause(scanner);

        System.out.println("\n===================================");
        System.out.println("5 - TIM SAN PHAM THEO MUC GIA");
        System.out.println("5.1 - Duoi VND 50,000");
        productsInPriceRange(productList, 0, 50000);
        System.out.println("5.2 - Tu VND 50,000 den duoi VND 100,000");
        productsInPriceRange(productList, 50000, 100000);
        System.out.println("5.3 - Tu VND 100,000 tro len");
        productsInPriceRange(productList, 100000, 0);
        pause(scanner);

        scanner.close();
    }

    // Break after each section
    static void pause(Scanner scanner) {
        System.out.print("\nEnter de tiep tuc");
        scanner.nextLine();
    }

    // Display product list
    static void displayProductList(ArrayList<Product> productList) {
        System.out.println("Product list:");
        for(Product product: productList) {
            product.display();
        }
    }

    // Show products in the defined price range
    static void productsInPriceRange(ArrayList<Product> productList, long lowerLimit, long upperLimit) {
        boolean isFound = false;
        for (Product product: productList) {
            if (upperLimit == 0) {
                if (product.getUnitPrice() >= lowerLimit) {
                    product.display();
                    isFound = true;
                }
            } else {
                if ((product.getUnitPrice() >= lowerLimit) && (product.getUnitPrice() < upperLimit)) {
                    product.display();
                    isFound = true;
                }
            }
        }
        if (isFound==false) {
            System.out.println("\t(Khong tim thay)");
        }
    }
}