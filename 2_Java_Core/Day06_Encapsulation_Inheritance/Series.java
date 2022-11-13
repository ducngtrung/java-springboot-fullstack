package Day06_Encapsulation_Inheritance;

public class Series extends Film{
// Tạo class Series kế thừa Film và có thêm thuộc tính:
//     số tập (int)
//     thời lượng trung bình (int) (tính theo phút)

// Khai báo access modifier cho các thuộc tính của class là private hoặc protected, KHÔNG DÙNG public
// Khai báo các getter/setter cho class
    private int episodes;       // số tập
    private int avg_duration;   // thời lượng trung bình (tính theo phút)
    
    // Constructor để nhập thông tin movie
    public Series(String id, String title, Genre genre, String director, double rating,
                 int episodes, int avg_duration) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.episodes = episodes;
        this.avg_duration = avg_duration;
    }

    // Getter để lấy thông tin từ thuộc tính private 
    public int getEpisodes() {
        return episodes;
    }
    public int getAvgDuration() {
        return avg_duration;
    }

    // Setter để gán giá trị cho thuộc tính private
    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }
    public void setAvgDuration(int avg_duration) {
        this.avg_duration = avg_duration;
    }

    // Phương thức này để in ra thông tin phim
    public void printInfo() {
        System.out.print("\n\t" + this.id + " - " + this.title + " - " + this.genre
                            + " - Directed by: " + this.director + " - " + this.episodes + " episodes x "
                            + this.avg_duration + " min" + " - Rated " + this.rating);
    }
}