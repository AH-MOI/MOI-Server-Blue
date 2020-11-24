package com.dsm.moi.utils.form;

import org.hibernate.mapping.Join;

import java.time.LocalDate;

public class JoinRequestForm {

    private String id;
    private String password;
    private String confirmPassword;
    private String name;
    private LocalDate birthday;
    private String school;

    public JoinRequestForm() {}
    public JoinRequestForm(String id, String password, String confirmPassword, String name, LocalDate birthday, String school) {
        this.id = id;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.birthday = birthday;
        this.school = school;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "JoinRequestForm{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", school='" + school + '\'' +
                '}';
    }
}
