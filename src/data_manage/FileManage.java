package data_manage;

import javafx.collections.ObservableList;
import model.Cat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManage {
    public void writeToFile(String pathname, ObservableList<Cat> catList) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(pathname);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Cat cat : catList) {
                objectOutputStream.writeObject(cat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert objectOutputStream != null;
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public List<Cat> readFile(String pathname) {
        List<Cat> cats = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathname);
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (true) {
                cats.add((Cat) objectInputStream.readObject());
            }
        } catch (EOFException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert objectInputStream != null;
        }
        return cats;
    }
}
