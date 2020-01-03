package home.blackharold.entity;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;


    @Min(value = 0, message = "must be greater than or equals to zero")
    @Max(value = 10, message = "must be less than or equals ten")
    private int freePasses;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @Pattern(regexp = "^[0-9]{6}", message = "only 6 digits")
    private String postalCode;

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
//        lastName = lastName.replaceAll(" ", "");
        System.out.println("|"+lastName+"|");
        this.lastName = lastName;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
