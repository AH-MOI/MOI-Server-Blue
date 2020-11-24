package com.dsm.moi.utils.form;

import java.util.List;

public class ParticipatingProjectLastResponseForm {
    private List<ParticipatingProjectResponseForm> projects;

    public ParticipatingProjectLastResponseForm() {}
    public ParticipatingProjectLastResponseForm(List<ParticipatingProjectResponseForm> projects) {
        this.projects = projects;
    }

    public List<ParticipatingProjectResponseForm> getProjects() {
        return projects;
    }

    public void setProjects(List<ParticipatingProjectResponseForm> projects) {
        this.projects = projects;
    }
}
