package view;

import java.util.List;

public interface IService<item, list> {
    void insert(item obj, List<item> objs);
    void delete(item obj, List<item> objs);
    void update(item obj, List<item> objs);
}