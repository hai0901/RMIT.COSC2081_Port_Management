public enum ContainerType {
    DRY_STORAGE("Dry Storage"),
    OPEN_TOP("Open Top"),
    OPEN_SIDE("Open Side"),
    REFRIGERATED("Refrigerated"),
    LIQUID("Liquid");

    private final String displayName;

    ContainerType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}