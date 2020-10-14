package model;

import java.io.Serializable;

public class Cat implements Serializable {
    private String ownerPhone;
    private String ownerName;
    private String name;
    private int age;
    private boolean gender;
    private String species;
    private float weight;
    private boolean castrated;
    private String hairColor;
    private String timeIn;
    private long price;

    public Cat(String ownerName,String ownerPhone, String name, int age, boolean gender, String species, float weight, boolean castrated, String hairColor, String timeIn, long price) {
        this.ownerPhone = ownerPhone;
        this.ownerName = ownerName;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = species;
        this.weight = weight;
        this.castrated = castrated;
        this.hairColor = hairColor;
        this.timeIn = timeIn;
        this.price = price;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Cat() {}

    public Cat(String ownerName, String ownerPhone,String name, int age, boolean gender, String species, float weight, boolean castrated, String hairColor) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = species;
        this.weight = weight;
        this.castrated = castrated;
        this.hairColor = hairColor;
        this.ownerPhone = ownerPhone;
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isCastrated() {
        return castrated;
    }

    public void setCastrated(boolean castrated) {
        this.castrated = castrated;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

//    @Override
//    public String toString() {
//        return "Cat{" +
//                "ownerPhone='" + ownerPhone + '\'' +
//                ", ownerName='" + ownerName + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", gender=" + gender +
//                ", species='" + species + '\'' +
//                ", weight=" + weight +
//                ", castrated=" + castrated +
//                ", hairColor='" + hairColor + '\'' +
//                '}';
//    }
}

