package org.launchcode.Songs4Soldiers.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int userId;

    @NotBlank(message = "Username is required")
    @NotNull
    //@Email(message = "Invalid username. Please enter a valid email.")
    @Size(min = 3, max = 55, message = "Username must be between 7 and 55 characters long")
    private String username;

    @NotNull
    private String pwHash;

    @Email(message = "Invalid email. Try again.")
    @Size(min = 7, max = 55, message = "Email must be between 7 and 55 characters long")
    private String email;

    @Size(min = 10, max = 12, message = "Too many digits! format: 000-555-1234")
    private String phone;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){}

    public User(int userId, String username, String password, String email, String phone) {
        this.userId = userId;
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.phone = phone;
    }

    public User (String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    //Getters and setters

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public int getUserID() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && getUsername().equals(user.getUsername()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, getUsername(), getEmail());
    }
}