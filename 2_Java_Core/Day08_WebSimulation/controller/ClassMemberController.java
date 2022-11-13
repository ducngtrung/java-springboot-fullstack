package controller;

import java.time.LocalDate;

import org.json.JSONObject;

import model.Gender;
import model.Student;
import model.Teacher;
import model.User;
import service.ClassMemberService;
import util.Constants;
import util.DateTimeUtil;

public class ClassMemberController {
    
    private ClassMemberService classMemberService;

    // Constructor: call Service
    public ClassMemberController() {
        this.classMemberService = new ClassMemberService();
    }

    /*
     * add new student
     * @param: student as JSON object
     * @return: result as JSON object
     */
    public JSONObject addStudent(JSONObject studentInfo) {
        // retrieve student params from JSON object
        String name = studentInfo.get("name").toString();
        LocalDate birthday = DateTimeUtil.convertStringToLocalDate(studentInfo.get("birthday").toString());
        Gender gender = studentInfo.get("gender").toString().toLowerCase().equals("nam") ? Gender.MALE : Gender.FEMALE;
        String email = studentInfo.get("email").toString();
        String phoneNumber = studentInfo.get("phoneNumber").toString();
        boolean isOnline = studentInfo.get("isOnline").toString().toLowerCase().equals("y") ? true : false;
        String background = studentInfo.get("background").toString();
        
        // create a student object based on the above params
        Student student = new Student(0, name, birthday, gender, email, phoneNumber, isOnline, background);

        // call Service to add the new student object to user repository and get user ID
        int id =  classMemberService.addNewStudent(student);
        System.out.println("\tnew user id: " + id);
        
        // return result as JSON object with 3 keys: "status_code", "success", "message"
        JSONObject result = new JSONObject();
        result.put("status_code", Constants.OK);
        if (id > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        return result;
    }

    /*
     * add new teacher
     * @param: teacher as JSON object
     * @return: result as JSON object
     */
    public JSONObject addTeacher(JSONObject teacherInfo) {
        // retrieve teacher params from JSON object
        String name = teacherInfo.get("name").toString();
        LocalDate birthday = DateTimeUtil.convertStringToLocalDate(teacherInfo.get("birthday").toString());
        Gender gender = teacherInfo.get("gender").toString().toLowerCase().equals("nam") ? Gender.MALE : Gender.FEMALE;
        String email = teacherInfo.get("email").toString();
        String phoneNumber = teacherInfo.get("phoneNumber").toString();
        int yearOfExperience = Integer.parseInt(teacherInfo.get("yearOfExperience").toString());
        String speciality = teacherInfo.get("speciality").toString();
        
        // create a teacher object based on the above params
        Teacher teacher = new Teacher(0, name, birthday, gender, email, phoneNumber, yearOfExperience, speciality);
        
        // call Service to add the new teacher object to user repository and get user ID
        int id =  classMemberService.addNewTeacher(teacher);
        System.out.println("\tnew user id: " + id);
        
        // return result as JSON object with 3 keys: "status_code", "success", "message"
        JSONObject result = new JSONObject();
        result.put("status_code", Constants.OK);
        if (id > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        return result;
    }

    /*
     * get a JSON array of users from a list of users
     * @param: list of users
     * @return: a JSON object containing only 1 element:
     *      key = "data"
     *      value = a JSON array of users
     */
    public JSONObject getUserJsonArray(User[] userList) {
        JSONObject userListJSON = new JSONObject(); // this JSON object will actually store a JSON array as value
        JSONObject[] temp = new JSONObject[userList.length]; // JSON array to store userJSON objects
        
        int index = 0;
        for (User user: userList) {
            if (user != null) {
                // retrieve user params
                int id = user.getId();
                String name = user.getName();
                String role = "";
                if (user instanceof Teacher) {
                    role = "Giao vien";
                } else if (user instanceof Student) {
                    role = "Sinh vien";
                }
                String gender = (user.getGender() == Gender.MALE) ? "nam" : "nu";
                String birthday = DateTimeUtil.convertLocalDateToString(user.getBirthday());
                String email = user.getEmail();
                String phoneNumber = user.getPhoneNumber();

                // create a JSON object based on the above params
                JSONObject userJSON = new JSONObject();
                userJSON.put("id", id);
                userJSON.put("name", name);
                userJSON.put("role", role);
                userJSON.put("gender", gender);
                userJSON.put("birthday", birthday);
                userJSON.put("email", email);
                userJSON.put("phoneNumber", phoneNumber);
                
                // Add the new JSON object to the JSON array
                temp[index] = userJSON;
                ++index;
            }
        }

        // Put the JSON array "temp" as value of the JSON object "userListJSON"
        userListJSON.put("data", temp);
        return userListJSON;
    }

    /*
     * get a list of all users
     * @return: users list as JSON array
     */
    public JSONObject getUserJson_All() {
        User[] users = classMemberService.getUserList(); // call Service getUserList to get a list of all users
        JSONObject usersJSON = getUserJsonArray(users); // convert the above list into JSON array
        return usersJSON;
    }

    /*
     * search user by keyword (name, email, phoneNumber)
     * get a list of users from search results
     * @param: keyword
     * @return: users list as JSON array
     */
    public JSONObject getUserJson_Search(String keyword) {
        // call Service searchByKeyword to get a list of users from search results
        User[] userSearch = classMemberService.searchUserByKeyword(keyword);
        
        // convert the above list into JSON array
        JSONObject userSearchJSON = getUserJsonArray(userSearch);
        return userSearchJSON;
    }

    /*
     * view user by id
     * @param: id
     */
    public void viewUser(int id) {
        classMemberService.viewUser(id);
    }

    /*
     * delete user by id
     * @param: id
     */
    public void deleteUser(int id) {
        classMemberService.deleteUser(id);
    }
}