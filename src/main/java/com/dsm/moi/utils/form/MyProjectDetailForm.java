package com.dsm.moi.utils.form;

import com.dsm.moi.domains.domain.Student;

import java.util.List;

public class MyProjectDetailForm {

    private String title;
    private String content;
    private List<String> hashtag;
    private String writer;
    private List<String> areas;
    private List<String> personnel;
    private List<Student> appliedStudent;

    public MyProjectDetailForm() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getHashtag() {
        return hashtag;
    }

    public void setHashtag(List<String> hashtag) {
        this.hashtag = hashtag;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public List<String> getAreas() {
        return areas;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public List<String> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<String> personnel) {
        this.personnel = personnel;
    }

    public List<Student> getAppliedStudent() {
        return appliedStudent;
    }

    public void setAppliedStudent(List<Student> appliedStudent) {
        this.appliedStudent = appliedStudent;
    }
}
