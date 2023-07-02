package com.chetan.springboot1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory, can't be blank")
    @NotNull(message = "Name is mandatory, can't be null")
    @Length(min = 1, max=15, message = "Name should be between 1 to 15 characters")
    //message is optional
//    @Email(message = "Not a valid email address")

//    @Positive(message = "Must be a Positive number")
//    @Negative(message = "Must be a Negative number")
//    @PositiveOrZero(message = "Not a Positive or Zero number")
//    @NegativeOrZero(message = "Not a Negative or Zero number")
//    @Past(message = "Must be a past date")
//    @Future(message = "Must be a future date")
//    @PastOrPresent(message = "Must be a past or present date")
//    @FutureOrPresent(message = "Must be a future or present date")
//    @Digits(integer = 2, fraction = 2, message = "Must be a valid number like 15.12 or II.DD where II is integer part and DD is decimal part")
//    @Size(min = 2, max = 10, message = "Must be a valid size between 2 and 10")
    //Difference between @Size and @Length is that @Size is used for collections and @Length is used for Strings
//    @Min(value = 2, message = "Must be a valid number")
//    @Max(value = 10, message = "Must be a valid number")
//    @Range(min = 2, max = 10, message = "Must be a valid number")
//    @Pattern(regexp = "^[a-zA-Z0-9]{2,10}$", message = "Must be a valid pattern")
    private String name;
    private String address;
    private String code;

    public Department() {
    }
    public Department(Long id, String name, String address, String code) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
