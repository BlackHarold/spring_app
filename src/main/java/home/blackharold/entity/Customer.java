package home.blackharold.entity;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equals to zero")
    @Max(value = 10, message = "must be less than or equals ten")
    private Integer freePasses;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
