import view.WebView;

public class Main8 {
    public static void main(String[] args) {
        // call View
        WebView view = new WebView();
        
        // display view to user
        try {
            view.display();
        } catch (Exception exception) {
            // code to handle errors in the "try" block
            System.out.println("Something went wrong");
            System.out.println(exception.getStackTrace());
        }
    }
}