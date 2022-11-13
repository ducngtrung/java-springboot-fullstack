package repository;

import model.User;

public class UserRepository {
    
    // variable to count the number of users
    public static int USER_COUNT = 0;

    // array to manage users (teachers and students)
    public static User[] userList;

    // array to store deleted IDs (to be reused when adding new user)
    public static int[] deletedIDs = new int[100];
    public static int indexDelID = 0;

    // Constructor: initialize user array
    public UserRepository() {
        userList = new User[100];
    }

    // Check if there's any deleted ID that hasn't been reused
    public boolean hasDeletedID() {
        boolean result = false;
        for (int i=0; i < deletedIDs.length; ++i) {
            if (deletedIDs[i] != 0) {
                result = true;
            }
        }
        return result;
    }
    
    /*
     * add new user to Repository
     * @param: user
     */
    public void addUser(User user) {
        int id = 0;
        if ( !hasDeletedID() ) { // if there's no deleled ID then use (USER_COUNT + 1) as new ID for new user
            id = USER_COUNT + 1; // get new ID
            user.setId(id);      // set new ID to new user
            userList[USER_COUNT] = user; // add new user to userList
        } else {                 // if there's a deleted ID then reuse it for new user
            for (int i = 0; i < deletedIDs.length; ++i) {
                if (deletedIDs[i] != 0) {
                    id = deletedIDs[i];
                    user.setId(id);
                    userList[(deletedIDs[i])-1] = user;
                    deletedIDs[i] = 0; // "erase" the deleted ID after reuse it
                    break;
                }
            }
        }
        ++USER_COUNT;
    }

    /*
     * delete user by id
     * @param: id
     * @return: user to be deleted
     */
    public User deleteUser(int id) {
        User userToDelete = null;
        for (int i = 0; i < userList.length; ++i) {
            if ((userList[i] != null) && (userList[i].getId() == id)) {
                userToDelete = userList[i]; // make a copy of the user to be deleted
                userList[i] = null;         // delete the user from userList
                break;
            }
        }
        --USER_COUNT;
        
        // if there's no deleled ID then reset the index of this array
        if ( !hasDeletedID() ) {
            indexDelID = 0;
        }

        // add the id to the deletedIDs array
        deletedIDs[indexDelID] = id;
        ++indexDelID;

        return userToDelete;
    }

    /*
     * retrieve users list
     * @return: array of users
     */
    public User[] getAllUsers() {
        int index = 0;
        User[] currentUserList = new User[USER_COUNT];
        for (User user: userList) {
            if (user != null) {
                currentUserList[index] = user;
                ++index;
            }
        }
        return currentUserList;
    }

    /*
     * get user by id
     * @param: id
     * @return: user
     */
    public User getUserByID(int id) {
        User userToView = null;
        for (User user: userList) {
            if ((user != null) && (user.getId() == id)) {
                userToView = user;
            }
        }
        return userToView;
    }

    /*
     * search user by keyword (users that have name, email, or phoneNumber containing the keyword)
     * put search results into an array of users
     * @param: keyword
     * @return: array of users
     */
    public User[] keywordSearch(String keyword) {
        int index = 0;
        User[] userSearchResult = new User[USER_COUNT];
        for (User user: userList) {
            if (user != null) {
                if (user.getName().toLowerCase().contains(keyword)
                    || user.getEmail().toLowerCase().contains(keyword)
                    || user.getPhoneNumber().contains(keyword)) {
                            userSearchResult[index] = user;
                            ++index;
                }
            }
        }
        return userSearchResult;   
    }
}