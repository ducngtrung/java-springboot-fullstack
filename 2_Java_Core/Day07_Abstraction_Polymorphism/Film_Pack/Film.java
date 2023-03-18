package Day07_Abstraction_Polymorphism.Film_Pack;

public class Film {
// Tạo class Film gồm các thuộc tính:
//     id (String)
//     tiêu đề (String)
//     thể loại (enum: HORROR (kinh dị), COMEDY (hài hước), DOCUMENTATRY (tài liệu), bạn có thể bổ sung thêm )
//     tên đạo diễn (String)
//     rating (double)

// Khai báo access modifier cho các thuộc tính của class là private hoặc protected, KHÔNG DÙNG public
// Khai báo các getter/setter cho class
    enum Genre {HORROR, COMEDY, DOCUMENTATRY, ACTION, SCI_FI, CRIME}
    protected String id;
    protected String title;
    protected Genre genre;
    protected String director;
    protected double rating;

    //Constructor để nhập thông tin film
    public Film(String id, String title, Genre genre, String director, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
    }

    // Getter để lấy thông tin từ các thuộc tính private 
    public String getID() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Genre getGenre() {
        return genre;
    }
    public String getDirector() {
        return director;
    }
    public double getRating() {
        return rating;
    }

    // Setter để gán giá trị cho các thuộc tính private
    public void setID(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title= title;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public void setDirector(String director) {
        this.director= director;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    // Phương thức này để tìm phim theo tên
    public boolean titleSearch(String keyword) {
        boolean result = this.title.toLowerCase().contains(keyword);
        return result;
    }
}