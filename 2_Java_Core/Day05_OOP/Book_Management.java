package Day05_OOP;

import java.util.Scanner;

public class Book_Management {
// Viết chương trình quản lý sách. Biết sách gồm các thông tin sau:
//      mã sách, tên sách, tác giả, thể loại, nhà xuất bản, năm xuất bản
// Thực hiện:
// - Tạo mảng để quản lý sách
// - Tìm sách theo tên
// - Tìm sách theo thể loại
// - Liệt kê các sách xuất bản trong năm nay
    public static void main(String[] args) {
        // Tạo mảng để quản lý sách
        Book[] bookList = new Book[5];
        bookList[0] = new Book("001", 
                            "Java Core", "Nguyen Xuan Nam", 
                            "sach lap trinh", "TechMaster", 2022);
        bookList[1] = new Book("002", 
                            "Web Can Ban", "Tao Thuy Quynh", 
                            "sach tham khao", "TechMaster", 2021);
        bookList[2] = new Book("003", 
                            "Java Nang Cao", "Nguyen Trung Duc", 
                            "sach lap trinh", "NXB Tre", 2020);
        bookList[3] = new Book("004", 
                            "Toan Cao Cap", "Nguyen Vu Luong", 
                            "sach giao khoa", "NXB DHQGHN", 2022);
        bookList[4] = new Book("005", 
                            "De Men Phieu Luu Ky", "To Hoai", 
                            "truyen thieu nhi", "NXB Giao Duc", 1990);
        
        // Dùng for each để in ra các tên sách            
        System.out.println("Cac sach trong thu vien:");
        for (Book book: bookList) {
            System.out.println("\t" + book.code
                                + " - " + book.name 
                                + " - " + book.type 
                                + " - " + book.year
                                + " - " + book.author
                                + " - " + book.publisher);
        }

        Scanner input = new Scanner(System.in);

        // Tìm sách theo tên (dùng vòng lặp for)
        System.out.println("Nhap tu khoa ten sach: ");
        String keywordName = input.nextLine().toLowerCase();
        boolean isFound = false;
        for (int index=0; index<bookList.length; ++index) {
            Book book = bookList[index];
            String name = book.name.toLowerCase();
            if (name.contains(keywordName)) {
                System.out.println("\tMa sach " + book.code + " - " + book.name);
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhong tim thay");
        }

        // Tìm sách theo thể loại (dùng for each và phương thức typeSearch(String) đã tạo sẵn ở class Book)        
        System.out.println("Nhap tu khoa the loai sach: ");
        String keywordType = input.nextLine().toLowerCase();
        isFound = false;
        for (Book book: bookList) {
            if (book.typeSearch(keywordType)) {
                System.out.println("\tMa sach " + book.code + " - " + book.name + " - " + book.type);
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhong tim thay");
        }

        // Liệt kê các sách xuất bản trong năm nay
        System.out.println("Cac sach xuat ban trong nam 2022:");        
        for (Book book: bookList) {
            if (book.checkPublishYear(2022)) {
                System.out.println("\t" + book.code
                                     + " - " + book.name 
                                     + " - " + book.type 
                                     + " - " + book.year
                                     + " - " + book.author
                                     + " - " + book.publisher);
            }
        }
        
        input.close();
    }
}