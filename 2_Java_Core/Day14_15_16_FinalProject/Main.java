import view.View;

public class Main {
    public static void main(String[] args) {
        // Call View
        View view = new View();

        // Display view to user
        try {
            view.showHomeScreen();
        } catch (Exception exception) {
            // code to handle errors in the "try" block
            System.out.println("Something went wrong");
        }
    }
}