import java.util.List;

public class UserModel implements IUser<User, List<User>> {

    @Override
    public void updateUsername(User obj, List<User> objs) {
        for (int i = 0; i < objs.size(); ++i) {
            if (objs.get(i).getEmail() == obj.getEmail()) {
                objs.set(i, obj);
                System.out.println("<Username updated>");
            }
        }
        
    }

    @Override
    public void updateEmail(User obj, List<User> objs) {
        for (int i = 0; i < objs.size(); ++i) {
            if (objs.get(i).getUsername() == obj.getUsername()) {
                objs.set(i, obj);
                System.out.println("<Email updated>");
            }
        }        
    }

    @Override
    public void updatePassword(User obj, List<User> objs) {
        for (int i = 0; i < objs.size(); ++i) {
            if (objs.get(i).getUsername() == obj.getUsername()) {
                objs.set(i, obj);
                System.out.println("<Password updated>");
            }
        }        
    }

    @Override
    public void insert(User obj, List<User> objs) {
        objs.add(obj);        
    }
}