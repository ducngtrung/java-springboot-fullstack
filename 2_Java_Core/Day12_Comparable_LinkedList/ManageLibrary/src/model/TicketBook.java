package model;

import java.util.Date;

public class TicketBook {
    private Reader reader;
    private Book book;
    private Date fromDate;
    private Date toDate;

    // Constructor
    public TicketBook(Reader reader, Book book) {
        this.reader = reader;
        this.book = book;
    }

    @Override
    public String toString() {
        return "TicketBook{" +
                "reader=" + reader +
                ", book=" + book +
                ", fromDate=" + toDate +
                ", toDate=" + fromDate  +
                '}';
    }
}