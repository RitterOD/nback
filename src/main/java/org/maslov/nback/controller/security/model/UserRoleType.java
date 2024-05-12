package org.maslov.nback.controller.security.model;

public enum UserRoleType {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");
    private String id;

    UserRoleType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
