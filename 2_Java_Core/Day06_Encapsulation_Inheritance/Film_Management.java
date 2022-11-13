package Day06_Encapsulation_Inheritance;

import java.util.Scanner;

import Day06_Encapsulation_Inheritance.Film.Genre;

public class Film_Management {
// Viết chương trình quản lý phim
// Thực hiện:
//     Tạo 2 mảng để quản lý Movie và Series
//     In thông tin phim ra màn hình
//     Nhập vào từ khoá tiêu đề film để tìm (tìm cả movie và series)
//     In ra thông tin film có rating thấp nhất (kiểm tra cả movie và series)
//     In ra thông tin film thuộc thể loại COMEDY có rating thấp nhất
    
    // Phương thức này để sắp xếp các phần tử trong danh sách phim theo thứ tự rating tăng dần
    static void ratingAscending(Film[] films) {
        Film temp;
        int quantity = films.length;
        for (int i = 0; i < (quantity - 1); ++i) {
            for (int j = 0; j < (quantity - i - 1); ++j) {
                if (films[j].getRating() > films[j+1].getRating()) {  // Dùng rating cũng được vì nó không phải là thuộc tính private
                    temp = films[j];
                    films[j] = films[j+1];
                    films[j+1] = temp;
                }
            }
        }
    }

    // Phương thức này để in ra thông tin phim có rating thấp hơn (giữa 1 movie và 1 series)
    static void selectLowerRating(Movie x, Series y) {
        if (x.rating < y.rating) {
            x.printInfo();
        } else if (x.rating == y.rating) {
            x.printInfo();
            y.printInfo();
        } else {
            y.printInfo();
        }
    }

    public static void main(String[] args) {
        // Tạo mảng Movie
        Movie[] movieList = new Movie[5];
        movieList[0] = new Movie("001", "Bullet Train", Genre.ACTION, 
                                "David Leitch", 7.5, 126);
        movieList[1] = new Movie("002", "Get Out", Genre.HORROR, 
                                "Jordan Peele", 7.7, 104);
        movieList[2] = new Movie("003", "The Lost City", Genre.COMEDY, 
                                "Adam Nee", 6.1, 112);
        movieList[3] = new Movie("004", "Jurasic World Dominion", Genre.SCI_FI, 
                                "Colin Trevorrow", 5.7, 147);
        movieList[4] = new Movie("005", "Once Upon A Time In Holywood", Genre.COMEDY, 
                                "Quentin Tarantino", 7.6, 161);
        
        // Tạo mảng Series                    
        Series[] seriesList = new Series[4];
        seriesList[0] = new Series("006", "Stranger Things", Genre.SCI_FI, 
                                "Matt Duffer", 8.7, 35, 51);
        seriesList[1] = new Series("007", "Moon Knight", Genre.ACTION, 
                                "Doug Moench", 7.4, 8, 48);
        seriesList[2] = new Series("008", "Peaky Blinders", Genre.CRIME, 
                                "Steven Knight", 8.8, 36, 60);
        seriesList[3] = new Series("009", "Friends", Genre.COMEDY, 
                                "David Crane", 8.9, 235, 22);
                                
        Scanner input = new Scanner(System.in);

        // In ra danh sách phim (cả movie và series)
        System.out.println("Danh sach phim:");
        System.out.println("\n\tMovie:");
        for (Movie movie: movieList) {
            movie.printInfo();
        }
        System.out.println("\n\n\tSeries:");
        for (Series series: seriesList) {
            series.printInfo();
        }

        // In ra thông tin phim có rating thấp nhất (kiểm tra cả movie và series)
        ratingAscending(movieList);
        ratingAscending(seriesList);
        System.out.println("\n\nPhim co rating thap nhat:");
        selectLowerRating(movieList[0], seriesList[0]);

        // In ra thông tin film thuộc thể loại COMEDY có rating thấp nhất
        ratingAscending(movieList);
        ratingAscending(seriesList);
        int m = 0;
        int s = 0;
        System.out.println("\n\nDao dien the loai COMEDY co rating thap nhat:");
        for (int index=0; index<movieList.length; ++index) { 
            if (movieList[index].getGenre() == Genre.COMEDY) {
                m = index;
                break;
            }
        }
        for (int index=0; index<seriesList.length; ++index) {
            if (seriesList[index].getGenre() == Genre.COMEDY) {
                s = index;
                break;
            }
        }
        selectLowerRating(movieList[m], seriesList[s]);

        // Tìm phim theo tên (tìm theo từ khóa)
        System.out.println("\n\nNhap ten phim can tim: ");
        String keyword = input.nextLine().toLowerCase();
        boolean isFound = false;
        for (Movie movie: movieList) {
            if (movie.titleSearch(keyword)) {
                movie.printInfo();
                isFound = true;
            }
        }
        for (Series series: seriesList) {
            if (series.titleSearch(keyword)) {
                series.printInfo();
                isFound = true;
            }
        }
        if (isFound==false) {
            System.out.println("\tKhong tim thay");
        }

        input.close();
    }
}