package com.dsm.moi.domains.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "school")
    private String school;

    @Column(name = "profile")
    private String profile;

    @Column(name = "github")
    private String github;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "area")
    private String area;

    @Column(name = "hashtag")
    private String hashtag;

    @Column(name = "star")
    private double star;

    @Column(name = "introduce")
    private String introduce;

    public Student() {}
    public Student(String id, String password, String name, LocalDate birthday, String school, String profile, String github, String phoneNumber, String area, String hashtag, double star, String introduce) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.school = school;
        this.profile = profile;
        this.github = github;
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.hashtag = hashtag;
        this.star = star;
        this.introduce = introduce;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public boolean isNormalInformation() {
        return id != null && password != null && name != null && birthday != null && school != null;
    }

    public boolean existIdPassword() {
        return id != null && password != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", school='" + school + '\'' +
                ", profile='" + profile + '\'' +
                ", github='" + github + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", area='" + area + '\'' +
                ", hashtag='" + hashtag + '\'' +
                '}';
    }
}
