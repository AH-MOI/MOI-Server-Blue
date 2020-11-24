package com.dsm.moi.utils.form;

import java.time.LocalDate;
import java.util.List;

public class ParticipatingProjectResponseForm {

    private String title;
    private String content;
    private List<String> hashtag;
    private LocalDate closingDate;
    private String writer;

    public ParticipatingProjectResponseForm() {}
    public ParticipatingProjectResponseForm(String title, String content, List<String> hashtag, LocalDate closingDate, String writer) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.closingDate = closingDate;
        this.writer = writer;
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

    public List<String> getHashtag() {
        return hashtag;
    }

    public void setHashtag(List<String> hashtag) {
        this.hashtag = hashtag;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
