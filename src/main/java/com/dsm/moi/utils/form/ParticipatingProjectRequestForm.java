package com.dsm.moi.utils.form;

public class ParticipatingProjectRequestForm {
    private String appliedStudentId;
    private String projectId;

    public ParticipatingProjectRequestForm() {}
    public ParticipatingProjectRequestForm(String appliedStudentId, String projectId) {
        this.appliedStudentId = appliedStudentId;
        this.projectId = projectId;
    }

    public String getAppliedStudentId() {
        return appliedStudentId;
    }

    public void setAppliedStudentId(String appliedStudentId) {
        this.appliedStudentId = appliedStudentId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
