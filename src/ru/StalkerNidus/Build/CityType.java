package ru.StalkerNidus.Build;

public enum CityType {
    VILLAGE("ДЕРЕВНЯ"),
    URBAN_VILLAGE("ДЕРЕВНЯ_ГОРОДСКОГО_ТИПА"),
    TOWN("СРЕДНИЙ"),
    METROPOLIS("МЕГАПОЛИС");

    private final String rus;

    CityType(String rus) {
        this.rus = rus;
    }
}
