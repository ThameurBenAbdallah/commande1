package com.commercial.commande.models.enums;

public enum Roles {
    ADMIN("Admin"),
    USER("User"),

    MANAGER("Manager");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
