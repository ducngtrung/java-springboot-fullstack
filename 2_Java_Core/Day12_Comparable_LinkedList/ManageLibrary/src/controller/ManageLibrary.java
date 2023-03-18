package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Tạo 1 list book
        Book book = new Book(1,"sach1","subject1","author1",4);
        Book book2 = new Book(2,"sach2","subject2","author2",6);
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
        bookListDisplay(books);

        //Tạo list reader
        Reader reader = new Reader(1,"address1","name1","phone1");
        Reader reader2 = new Reader(2,"address2","name2","phone2");
        List<Reader> readers = new ArrayList<>();
        readers.add(reader);
        readers.add(reader2);
        readertListDisplay(readers);

        //Tạo 1 list ticket
        TicketBook ticketBook = new TicketBook(reader,book);
        TicketBook ticketBook2 = new TicketBook(reader2,book2);
        List<TicketBook> ticketBooks = new ArrayList<>();
        ticketBooks.add(ticketBook);
        ticketBooks.add(ticketBook2);

        //Test insert book
        System.out.println("Đầu tiên test chức năng insert book nè ...");
        System.out.println("Nhập tên sách nhanh hộ cái:");
        String name= scanner.nextLine();
        System.out.println("Nhập tên tác giả đi:");
        String auth= scanner.nextLine();
        System.out.println("Rồi nhập tiêu đề đi:");
        String title= scanner.nextLine();
        BookModel model = new BookModel();
        Book book3 = new Book(3,name,title,auth,2);
        model.insert(book3,books);
        bookListDisplay(books);

        //Test update book
        System.out.println("Giờ test chức năng update book nè ...");
        System.out.println("Nhập id muốn update nào");
        int idUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sách nhanh hộ cái:");
        String name4= scanner.nextLine();
        System.out.println("Nhập tên tác giả đi:");
        String auth4= scanner.nextLine();
        System.out.println("Rồi nhập tiêu đề đi:");
        String title4= scanner.nextLine();
        Book book4 = new Book(idUpdate,name4,title4,auth4,4);
        model.update(book4,books);
        bookListDisplay(books);

        //Test delete book
        System.out.println("Giờ test chức năng delete chứ j ...");
        System.out.println("Nhập id muốn delete nào");
        int idDel = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < books.size(); ++i) {
            if (books.get(i).getId() == idDel) {
                model.delete(books.get(i), books);
                System.out.println("\tBook deleted");
            }
        }
        bookListDisplay(books);

        //================================================
        //Test insert Reader
        System.out.println("Đầu tiên test chức năng insert Reader nè ...");
        System.out.println("Nhập tên nhanh hộ cái:");
        String nameR= scanner.nextLine();
        System.out.println("Nhập địa chỉ đi:");
        String address= scanner.nextLine();
        System.out.println("Rồi nhập phone đi:");
        String phone= scanner.nextLine();
        ReaderModel readerModel = new ReaderModel();
        Reader reader3 = new Reader(3,address,nameR,phone);
        readerModel.insert(reader3,readers);
        readertListDisplay(readers);

        //Test update reader
        System.out.println("Giờ test chức năng update reader nè ...");
        System.out.println("Nhập id muốn update nào");
        int idRUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên nhanh hộ cái:");
        String nameR3= scanner.nextLine();
        System.out.println("Nhập địa chỉ đi:");
        String address3= scanner.nextLine();
        System.out.println("Rồi nhập phone đi:");
        String phone3= scanner.nextLine();
        Reader reader4 = new Reader(idRUpdate,address3,nameR3,phone3);
        readerModel.update(reader4,readers);
        readertListDisplay(readers);

        //Test delete reader
        System.out.println("Giờ test chức năng delete chứ j ...");
        System.out.println("Nhập id muốn delete nào");
        int idRDel = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < readers.size(); ++i) {
            if (readers.get(i).getId() == idRDel) {
                readerModel.delete(readers.get(i), readers);
                System.out.println("\tReader deleted");
            }
        }
        readertListDisplay(readers);
        
        scanner.close();
    }

    // Display books list
    static void bookListDisplay(List<Book> books) {
        for (Book book: books) {
            System.out.println(book.toString());
        }
    }

    // Display readers list
    static void readertListDisplay(List<Reader> readers) {
        for (Reader reader: readers) {
            System.out.println(reader.toString());
        }
    }
}