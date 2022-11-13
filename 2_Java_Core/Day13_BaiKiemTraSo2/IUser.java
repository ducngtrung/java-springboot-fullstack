import java.util.List;

public interface IUser<item, list> {
    void updateUsername(item obj, List<item> objs);
    void updateEmail(item obj, List<item> objs);
    void updatePassword(item obj, List<item> objs);
    void insert(item obj, List<item> objs);
}