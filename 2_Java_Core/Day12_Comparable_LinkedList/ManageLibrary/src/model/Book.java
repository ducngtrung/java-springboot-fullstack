package model;

public class Book {
    private int id;
    private String name;
    private String author;
    private String subject;
    private int numberOfBook;

    // Constructor
    public Book(int id, String name, String subject, String author, int numberOfBook) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.subject = subject;
        this.numberOfBook=numberOfBook;
    }

    // Getter
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", numberOfBook=" + numberOfBook +
                '}';
    }
}