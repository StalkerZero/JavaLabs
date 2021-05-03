package ru.StalkerNidus.Build;

public enum BuildingType {
    SOCIAL("ОБЩЕСТВЕННОЕ"),
    LIVING("ЖИЛОЕ"),
    INDUSTRIAL("ИНДУСТРИАЛЬНОЕ");

    private final String rus;

    BuildingType(String rus) {
        this.rus = rus;
    }

}
