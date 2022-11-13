package Day10_ArrayList.Quan_Ly_Ho_Dan;

import java.util.ArrayList;
import java.util.Scanner;

// Xây dựng lớp Family gồm: 
// - Số thành viên trong gia đình
// - Số nhà của hộ dân đó
// - Thông tin về mỗi cá nhân trong gia đình
// - Với mỗi cá nhân, quản lý các thông tin như: họ và tên, ngày sinh, nghề nghiệp
//      Yêu cầu: 
//      - Viết chức năng nhập thông tin hộ dân và các thành viên trong hộ dân đó
//      - Hiển thị thông tin chi tiết của hộ dân

public class QuanLyHoDan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so nha: ");
        String houseNumber = input.nextLine();
        System.out.println("Nhap so thanh vien: ");
        int numberOfMembers = input.nextInt();
        input.nextLine();

        // Khai báo 2 thành viên hộ gia đình
        Person person1 = new Person("Nguyen Trung Duc", "29/04/1994", "Data Engineer");
        Person person2 = new Person("Vuong Khanh Huyen", "07/12/1996", "Accountant");

        // Đưa 2 thành viên trên vào ArrayList
        ArrayList<Person> members = new ArrayList<>();
        members.add(person1);
        members.add(person2);

        // Tạo đối tượng Family từ những thông tin trên
        Family family = new Family();
        family.setHouseNumber(houseNumber);
        family.setNumberOfMembers(numberOfMembers);
        family.setMembers(members);

        // In ra thông tin hộ gia đình
        System.out.println(family.toString());

        input.close();
    }
}