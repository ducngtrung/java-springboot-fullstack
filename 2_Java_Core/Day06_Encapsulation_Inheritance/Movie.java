package Day06_Encapsulation_Inheritance;

public class Movie extends Film {
// Tạo class Movie kế thừa Film và có thêm thuộc tính:
//     thời lượng (int) (tính theo phút)

// Khai báo access modifier cho các thuộc tính của class là private hoặc protected, KHÔNG DÙNG public
// Khai báo các getter/setter cho class
    private int duration;   // thời lượng (tính theo phút)

    // Constructor để nhập thông tin movie
    public Movie(String id, String title, Genre genre, String director, double rating,
                 int duration) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.duration = duration;
    }
    
    // Getter để lấy thông tin từ thuộc tính private 
    public int getDuration() {
        return duration;
    }

    // Setter để gán giá trị cho thuộc tính private
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Phương thức này để in ra thông tin phim
    public void printInfo() {
        System.out.print("\n\t" + this.id + " - " + this.title + " - " + this.genre
                            + " - Directed by: " + this.director + " - " + this.duration + " min"
                            + " - Rated " + this.rating);
    }
}