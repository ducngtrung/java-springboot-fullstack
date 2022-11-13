package Day07_Abstraction_Polymorphism.Film_Pack;

import Day07_Abstraction_Polymorphism.Film_Pack.Film.Genre;

public class Film_Management {
// Thực hiện tạo 1 mảng chung để quản lý Movie và Series
// In thông tin phim ra màn hình
    public static void main(String[] args) {
        // Khởi tạo mảng chung thuộc kiểu Film để quản lý cả Movie và Series
        Film[] filmList = new Film[10];
        
        // 2 phần tử đầu tiên của mảng lần lượt thuộc kiểu Movie và Series
        Movie m0 = new Movie("010", "Black Phone", Genre.HORROR, 
                            "Scott Derrickson", 7.0, 103);
        Series s1 = new Series("011", "Money Heist", Genre.ACTION, 
                            "Alex Pina", 8.2, 41, 69);
        filmList[0] = m0;
        filmList[1] = s1;
        
        // Phần tử thứ 5 của mảng không thuộc cụ thể kiểu Movie hay Series
        Film newFilm = new Film("012", "Man vs. Bee", Genre.COMEDY, "David Kerr", 6.8);
        filmList[4] = newFilm;

        for (Film film: filmList) {
            if (film != null) {
            // Vì mảng filmList có 10 phần tử nhưng ở trên chỉ khai báo 3 phần tử nên cần có điều kiện này
                System.out.println(film.id);
                if (film instanceof Movie) {
                    Movie movie = (Movie)film;      // Ép kiểu (downcasting) cho đối tượng từ Film xuống Movie
                    System.out.println("Movie: " + movie.getTitle() + " - " + movie.getDuration() + " min");
                    // phần tử phải thuộc kiểu Movie thì mới gọi được phương thức getDuration()
                } else if (film instanceof Series) {
                    Series series = (Series)film;   // Ép kiểu (downcasting) cho đối tượng từ Film xuống Series
                    System.out.println("Series: " + series.getTitle() + " - " + series.getEpisodes() + " eps");
                    // phần tử phải thuộc kiểu Series thì mới gọi được phương thức getEpisodes()
                } else {
                    System.out.println("Film: " + film.title + " - khong biet thuoc loai doi tuong nao");
                }
            }
        }
    }
}