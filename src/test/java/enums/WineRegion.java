package enums;

public enum WineRegion {
    Kuban("Кубань"),
    Crimean("Крым"),
    Samara("Самара");

    public final String value;

    WineRegion(String value) {
        this.value = value;
    }
}
