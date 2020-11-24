package com.dsm.moi.utils.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException() {
        super("Project ID에 해당하는 프로젝트를 찾을 수 없습니다.");
    }
}
