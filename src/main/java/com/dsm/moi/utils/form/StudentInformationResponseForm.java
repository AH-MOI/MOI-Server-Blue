package com.dsm.moi.utils.form;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

public class StudentInformationResponseForm {

    private String id;
    private String name;
    private LocalDate birthday;
    private String school;
    private String profile;
    private String github;
    private String phoneNumber;
    private String area;
    private String hashtag;
    private double star;

    public StudentInformationResponseForm() {}
    public StudentInformationResponseForm(String id, String name, LocalDate birthday, String school, String profile, String github, String phoneNumber, String area, String hashtag, double star) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.school = school;
        this.profile = profile;
        this.github = github;
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.hashtag = hashtag;
        this.star = star;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }
}
