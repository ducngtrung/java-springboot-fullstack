package Day10_ArrayList.Quan_Ly_Trung_Tam_Dao_Tao;

import java.util.ArrayList;

public class School {
    private String adminName;
    private ArrayList<ClassRoom> classRoomList;
    
    // Constructor
    public School(String adminName, ArrayList<ClassRoom> classRoomList) {
        this.adminName = adminName;
        this.classRoomList = classRoomList;
    }

    // Display School info, including ClassRoom list and Student list
    public void display() {
        System.out.println("\nTRUNG TAM TECHMASTER");
        System.out.println("Quan ly lop: " + adminName);
        for (ClassRoom classRoom: classRoomList) {
            classRoom.display();
        }
    }
}