package com.dsm.moi.utils.form;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

public class StudentInformationResponseForm {

    private String password;
    private String name;
    private LocalDate birthday;
    private String school;
    private String profile;
    private String github;
    private String phoneNumber;
    private String area;
    private String hashtag;

    public StudentInformationResponseForm() {}
    public StudentInformationResponseForm(String password, String name, LocalDate birthday, String school, String profile, String github, String phoneNumber, String area, String hashtag) {
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.school = school;
        this.profile = profile;
        this.github = github;
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.hashtag = hashtag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}
