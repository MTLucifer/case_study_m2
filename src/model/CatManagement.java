package model;

import java.util.ArrayList;
import java.util.List;

public class CatManagement implements IManagement<Cat> {
    static List<Cat> cats;


    @Override
    public void add(Cat obj) {
        boolean flag = true;
        for (int i = 0; i < cats.size(); i++) {
            if (obj.getOwnerPhone().equals(cats.get(i).getOwnerPhone())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            cats.add(obj);
        }
    }

    @Override
    public void update(String inputCusPhone, Cat newObj) {

    }

    @Override
    public void delete(String inputCusPhone) {

    }

    @Override
    public List findByPhone(String inputCusPhone) {
        return null;
    }

    @Override
    public List<Cat> findByName(String inputCusName) {
        return null;
    }

    @Override
    public List<Cat> findByCatName(String inputCatName) {
        return null;
    }

    @Override
    public List<Cat> findByCatSpecies(String inputCatSpecies) {
        return null;
    }

    @Override
    public List<Cat> findByCatGender(String inputCatGender) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
