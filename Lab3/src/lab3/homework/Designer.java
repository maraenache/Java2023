package lab3.homework;

import java.time.LocalDate;

public class Designer extends Person {

    private String favoriteColor;

    public Designer(String name, int id, LocalDate birthday, String favoriteColor) {
        super(name, id, birthday);
        this.favoriteColor = favoriteColor;
    }

    public Designer(String name, int id, LocalDate birthday, Company company, String favoriteColor) {
        super(name, id, birthday, company);
        this.favoriteColor = favoriteColor;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }


    public String toString() {
        return "Designer | Name: " + getName() + ", ID: " + getId() + ", Favorite color: " + getFavoriteColor() + ", Birthday: " + getBirthday() + ", relationships" +
                " " + getImportance() + ": " + getRelationships();
    }
}
