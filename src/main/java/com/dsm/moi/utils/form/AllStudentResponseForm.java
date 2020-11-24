package com.dsm.moi.utils.form;

import java.util.List;

public class AllStudentResponseForm {

    private List<StudentInformationResponseForm> students;

    public AllStudentResponseForm() {}
    public AllStudentResponseForm(List<StudentInformationResponseForm> students) {
        this.students = students;
    }

    public List<StudentInformationResponseForm> getStudents() {
        return students;
    }

    public void setStudents(List<StudentInformationResponseForm> students) {
        this.students = students;
    }
}
