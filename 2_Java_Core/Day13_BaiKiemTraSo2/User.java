public class User {
    private String username;
    private String email;
    private String password;
    
    // Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter
    public String getUsername() {
        return this.username;
    }
    public String getEmail() {
        return this.email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Check if passwordToCheck is this user's password
    public boolean isCorrectPassword(String passwordToCheck) {
        if (password.equals(passwordToCheck)) {
            return true;
        }
        return false;
    }

    // Check if emailToCheck is this user's email
    public boolean isCorrectEmail(String emailToCheck) {
        if (email.equals(emailToCheck)) {
            return true;
        }
        return false;
    }

    // Display user info
    public void display() {
        System.out.printf("\tUsername: %-15s Email: %-30s Password: %-15s\n", 
                            username, email, password);
    }
}