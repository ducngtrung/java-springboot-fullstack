package view;

import java.util.Scanner;

import controller.ClassMemberController;
import dto.MemberDto;
import util.Constants;

import org.json.JSONObject;

public class WebView {
    
    private Scanner scanner;
    private MemberDto[] memberList_All;
    
    private ClassMemberController classMemberController;

    // Constructor: initialize Scanner, call Controller
    public WebView() {
        this.scanner = new Scanner(System.in);
        this.memberList_All = null;
        this.classMemberController = new ClassMemberController();
    }
    
    /*
     * display UI
     */
    public void display() {
        boolean isQuit = false;
        while (true) {
            System.out.println("");
            System.out.println("======================================================================================================================");
            System.out.println("Danh sach lop:");
            displayMembers(memberList_All);
            displayMenu();
            System.out.print("Moi ban chon menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu) {
                case 1:{ // refresh list
                    getMemberList();
                    break;
                }
                case 2: { // add teacher
                    addNewTeacher();
                    break;
                }
                case 3: { // add student
                    addNewStudent();
                    break;
                }
                case 4: { // view member by id
                    viewMember();
                    break;
                }
                case 5: { // search member by keyword
                    searchMember();
                    break;
                }
                case 6: { // remove member by id
                    removeMember();
                    break;
                }
                case 7: { // exit 
                    isQuit = true;
                    break;
                }
                default:
                    break;
            }
            if (isQuit == true) {
                break;
            }
        }
        if (isQuit == true) {
            this.quit();
        }
    }

    /*
     * display menu
     */
    private void displayMenu() {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("[1] Refresh list");
        System.out.println("[2] Add Teacher");
        System.out.println("[3] Add Student");
        System.out.println("[4] View member");
        System.out.println("[5] Search member");
        System.out.println("[6] Remove member");
        System.out.println("[7] Exit");
    }

    /*
     * display a list of members
     */
    private void displayMembers(MemberDto[] memberList) {
        System.out.println();
        System.out.printf("%-7s", "ID");
        System.out.printf("%-25s", "Ten");
        System.out.printf("%-15s", "Chuc vu");
        System.out.printf("%-15s", "Gioi tinh");
        System.out.printf("%-15s", "Ngay sinh");
        System.out.printf("%-30s", "Email");
        System.out.printf("%-15s", "SDT");
        System.out.println();
        if (memberList == null || memberList.length == 0) {
            System.out.println("(Khong co thanh vien nao)");
        } else {    
            for (MemberDto member: memberList) {
                if (member != null) {
                    System.out.printf("%-7s", member.id);
                    System.out.printf("%-25s", member.name);
                    System.out.printf("%-15s", member.role);
                    System.out.printf("%-15s", member.gender);
                    System.out.printf("%-15s", member.birthday);
                    System.out.printf("%-30s", member.email);
                    System.out.printf("%-15s", member.phoneNumber);
                    System.out.println();
                }
            }
        }
    }

    /*
     * input teacher info
     */
    private void addNewTeacher() {

        // get teacher info from scanner
        System.out.print("Nhap ten:\n\t");
        String name = this.scanner.nextLine();
        System.out.print("Nhap ngay sinh (dd/MM/yyy):\n\t");
        String birthday = this.scanner.nextLine();
        System.out.print("Nhap gioi tinh (Nam/Nu):\n\t");
        String gender = this.scanner.nextLine();
        System.out.print("Nhap email:\n\t");
        String email = this.scanner.nextLine();
        System.out.print("Nhap so dien thoai:\n\t");
        String phoneNumber = this.scanner.nextLine();
        System.out.print("Nhap so nam kinh nghiem:\n\t");
        String yearOfExperience = this.scanner.nextLine();
        System.out.print("Nhap linh vuc giang day:\n\t");
        String speciality = this.scanner.nextLine();

        // create a teacher JSON object from the above info
        JSONObject teacherInfo = new JSONObject();
        teacherInfo.put("name", name);
        teacherInfo.put("birthday", birthday);
        teacherInfo.put("gender", gender);
        teacherInfo.put("email", email);
        teacherInfo.put("phoneNumber", phoneNumber);
        teacherInfo.put("yearOfExperience", yearOfExperience);
        teacherInfo.put("speciality", speciality);

        // call Controller to add teacher
        JSONObject result = classMemberController.addTeacher(teacherInfo);
        if (result.getInt("status_code") == Constants.OK) {
            if (result.getBoolean("success") == true) {
                System.out.println("Tao teacher thanh cong");
                System.out.println("CHON MENU [1] DE REFRESH");
            } else {
                System.out.println("Tao teacher that bai");
            }
        }  else {
            System.out.println("Co loi o server");
        }
    }
    
    /*
     * input student info
     */
    private void addNewStudent() {
        
        // get student info from scanner
        System.out.print("Nhap ten:\n\t");
        String name = this.scanner.nextLine();
        System.out.print("Nhap ngay sinh (dd/MM/yyy):\n\t");
        String birthday = this.scanner.nextLine();
        System.out.print("Nhap gioi tinh (Nam/Nu):\n\t");
        String gender = this.scanner.nextLine();
        System.out.print("Nhap email:\n\t");
        String email = this.scanner.nextLine();
        System.out.print("Nhap so dien thoai:\n\t");
        String phoneNumber = this.scanner.nextLine();
        System.out.print("Dang ky hoc online (Y/N)?\n\t");
        String isOnline = this.scanner.nextLine();
        System.out.print("Nhap background:\n\t");
        String background = this.scanner.nextLine();

        // create a student JSON object from the above info
        JSONObject studentInfo = new JSONObject();
        studentInfo.put("name", name);
        studentInfo.put("birthday", birthday);
        studentInfo.put("gender", gender);
        studentInfo.put("email", email);
        studentInfo.put("phoneNumber", phoneNumber);
        studentInfo.put("isOnline", isOnline);
        studentInfo.put("background", background);

        // call Controller to add student
        JSONObject result = classMemberController.addStudent(studentInfo);
        if (result.getInt("status_code") == Constants.OK) {
            if (result.getBoolean("success") == true) {
                System.out.println("Tao student thanh cong");
                System.out.println("CHON MENU [1] DE REFRESH");
            } else {
                System.out.println("Tao student that bai");
            }
        }  else {
            System.out.println("Co loi o server");
        }
    }

    /*
     * convert a JSON array (of users) to a MemberDto array
     */
    private MemberDto[] JsonToObjects(JSONObject userList) {
        JSONObject[] userListArray = (JSONObject[])userList.get("data"); // the value corresponding to the "data" key of "userList" is a JSON array
        MemberDto[] memberList = new MemberDto[userListArray.length];
        
        int index = 0;
        for (JSONObject userJSON: userListArray) {
            if (userJSON != null) {
                // retrieve user params from JSON object
                String id = userJSON.get("id").toString();
                String name = userJSON.get("name").toString();
                String role = userJSON.get("role").toString();
                String gender = userJSON.get("gender").toString();
                String birthday = userJSON.get("birthday").toString();
                String email = userJSON.get("email").toString();
                String phoneNumber = userJSON.get("phoneNumber").toString();
                
                // create an object (class MemberDto) based on the above params
                MemberDto member = new MemberDto(id, name, role, gender, birthday, email, phoneNumber);

                // Add the new member object to the members list
                memberList[index] = member;
                ++index;
            }
        }
        return memberList;
    }

    /*
     * get the list of all members (including teachers and students)
     */
    private void getMemberList() {
        JSONObject result = classMemberController.getUserJson_All(); // call Controller to get all users
        this.memberList_All = JsonToObjects(result);
    }

    /*
     * view member by id
     */
    private void viewMember() {
        System.out.print("Nhap id cua user can tim: ");
        int idToView = this.scanner.nextInt();
        this.scanner.nextLine();

        // call Controller to view member
        classMemberController.viewUser(idToView);
    }

    /*
     * search member by keyword (name, email, phoneNumber)
     * display member's basic info: id, name, role, gender, email, phoneNumber
     */
    private void searchMember() {
        System.out.print("Nhap keyword can tim (ten, email, so dien thoai): ");
        String keyword = this.scanner.nextLine().toLowerCase();

        // call Controller to get search results
        JSONObject result = classMemberController.getUserJson_Search(keyword);
        MemberDto[] memberList_Search = JsonToObjects(result);
        displayMembers(memberList_Search);
    }

    /*
     * remove member by id
     */
    private void removeMember() {
        System.out.print("Nhap id cua user can xoa: ");
        int idToRemove = this.scanner.nextInt();
        this.scanner.nextLine();

        // call Controller to remove member
        classMemberController.deleteUser(idToRemove);

        // refresh members list
        getMemberList();
        boolean success = true;
        for (MemberDto member: memberList_All) {
            if (Integer.parseInt(member.getId()) == idToRemove) {
                success = false;
                break;
            }
        }
        if (success) {
            System.out.println("Xoa member thanh cong");
        } else {
            System.out.println("Xoa member that bai");
        }
    }

    /*
     * system quit
     */
    private void quit() {
        System.out.println("Hen gap lai !!!");
        this.close();
    }

    /*
     * close scanner
     */
    private void close() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }
}