package service;

import model.Student;
import model.Teacher;
import model.User;
import repository.UserRepository;

public class ClassMemberService {
    
    private UserRepository userRepository;

    // Constructor: call Repository
    public ClassMemberService() {
        this.userRepository = new UserRepository();
    }

    /*
     * add new student to the user repository
     * @param: student object
     * @return: user id
     */
    public int addNewStudent(Student student) {
        System.out.print("...Adding new student:\n\t");
        student.printInfo();
        userRepository.addUser(student);
        return student.getId();
    }

    /*
     * add new teacher to the user repository
     * @param: teacher object
     * @return: user id
     */
    public int addNewTeacher(Teacher teacher) {
        System.out.print("...Adding new teacher:\n\t");
        teacher.printInfo();
        userRepository.addUser(teacher);
        return teacher.getId();
    }

    /*
     * get users list
     * @return: array of users
     */
    public User[] getUserList() {
        User[] userList = userRepository.getAllUsers();
        return userList;
    }

    /*
     * search user by keyword (name, email, phoneNumber)
     * @param: keyword
     * @return: array of users
     */
    public User[] searchUserByKeyword(String keyword) {
        User[] userSearchResult = userRepository.keywordSearch(keyword);
        return userSearchResult;
    }

    /*
     * view user by Id
     * @param: id
     */
    public void viewUser(int id) {
        User userToView = userRepository.getUserByID(id);
        if (userToView == null) {
            System.out.println("\tKhong ton tai id nay");
        } else {
            if (userToView instanceof Student) {
                System.out.print("Student:  ");
            } else if (userToView instanceof Teacher) {
                System.out.print("Teacher:  ");
            }
            userToView.printInfo();
        }
    }

    /*
     * delete user by Id
     * @param: id
     */
    public void deleteUser(int id) {
        System.out.print("...Removing member:\n\t");
        User userToDelete = userRepository.deleteUser(id);
        if (userToDelete == null) {
            System.out.println("Khong ton tai id nay");
        } else {
            userToDelete.printInfo();
        }
    }
}