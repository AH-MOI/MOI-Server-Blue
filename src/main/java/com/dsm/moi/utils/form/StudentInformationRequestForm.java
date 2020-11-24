package com.dsm.moi.utils.form;

public class StudentInformationRequestForm {

    private String phoneNumber;
    private String area;
    private String hashtag;
    private String github;
    private String profile;
    private String introduce;

    public StudentInformationRequestForm() {}
    public StudentInformationRequestForm(String phoneNumber, String area, String hashtag, String github, String profile, String introduce) {
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.hashtag = hashtag;
        this.github = github;
        this.profile = profile;
        this.introduce = introduce;
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

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "StudentInformationRequestForm{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", area='" + area + '\'' +
                ", hashtag='" + hashtag + '\'' +
                ", github='" + github + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
