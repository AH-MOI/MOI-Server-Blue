package com.dsm.moi.domains.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "closing_date")
    private LocalDate closingDate;

    @ManyToOne
    @JoinColumn(name = "writer", referencedColumnName = "id")
    private Student writer;

    @Column(name = "personnel")
    private String personnel;

    @Column(name = "hashtag")
    private String hashtag;

    @Column(name = "profile")
    private String profile;

    public Project() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public Student getWriter() {
        return writer;
    }

    public void setWriter(Student writer) {
        this.writer = writer;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
