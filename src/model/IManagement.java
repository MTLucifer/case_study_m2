package model;

import java.util.List;

public interface IManagement<C> {
    void add(C obj);

    void update(String inputCusPhone, C newObj);

    void delete(String inputCusPhone);

    List<C> findByPhone(String inputCusPhone);
    List<C> findByName(String inputCusName);
    List<C> findByCatName(String inputCatName);
    List<C> findByCatSpecies(String inputCatSpecies);
    List<C> findByCatGender(String inputCatGender);

    List<C> findAll();
    
}
