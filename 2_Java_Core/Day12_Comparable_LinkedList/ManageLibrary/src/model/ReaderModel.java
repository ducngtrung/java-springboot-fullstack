package model;

import view.IService;

import java.util.List;

public class ReaderModel implements IService<Reader, List<Reader>> {
    @Override
    public void insert(Reader obj, List<Reader> objs) {
        objs.add(obj);
    }

    @Override
    public void delete(Reader obj, List<Reader> objs) {
        objs.remove(obj);
    }

    @Override
    public void update(Reader obj, List<Reader> objs) {
        for (int i = 0; i < objs.size(); ++i) {
            if (objs.get(i).getId() == obj.getId()) {
                objs.set(i, obj);
                System.out.println("\tReader updated");
            }
        }
    }
}