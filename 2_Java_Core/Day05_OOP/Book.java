package Day05_OOP;

public class Book {
    public String code;     
    public String name;
    public String author;
    public String type;
    public String publisher;
    public int year;

    public Book(String code, String name, String author, String type, String publisher, int year) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.type = type;
        this.publisher = publisher;
        this.year = year;
    }

    public boolean typeSearch(String keyword) {
        boolean result = this.type.toLowerCase().contains(keyword);
        return result;
    }

    public boolean checkPublishYear(int year) {
        boolean result = (this.year==year);
        return result;
    }
}