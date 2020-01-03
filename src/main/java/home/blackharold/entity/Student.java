package home.blackharold.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String checkBox;


    private LinkedHashMap<String, String> countries;

    private List<String> buttonsList;

    public List<String> getCheckBoxes() {
        return checkBoxes;
    }

    public void setCheckBoxes(List<String> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    private List<String> checkBoxes;

    public Student() {
//        populate country options: used ISO country code
        countries = new LinkedHashMap<>();
        countries.put("BR", "Brazil");
        countries.put("FR", "France");
        countries.put("DE", "Germany");
        countries.put("RU", "Russia");
        countries.put("IN", "India");
        countries.put("US", "United States of America");

        buttonsList = new ArrayList<>();
        buttonsList.add("Java");
        buttonsList.add("Python");
        buttonsList.add("C#");
        buttonsList.add("PHP");

        checkBoxes = new ArrayList<>();
        checkBoxes.add("Linux");
        checkBoxes.add("Windows");
        checkBoxes.add("Mac OS");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public LinkedHashMap<String, String> getCountries() {
        return countries;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }


    public List<String> getButtonsList() {
        return buttonsList;
    }

    public void setButtonsList(List<String> buttonsList) {
        this.buttonsList = buttonsList;
    }

    public String getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }

}
