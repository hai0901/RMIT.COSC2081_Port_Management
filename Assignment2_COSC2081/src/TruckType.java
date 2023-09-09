public enum TruckType  {
    BASIC("Basic Truck", ContainerType.DRY_STORAGE, ContainerType.OPEN_TOP, ContainerType.OPEN_SIDE),
    REEFER("Reefer Truck", ContainerType.REFRIGERATED),
    TANKER("Tanker Truck", ContainerType.LIQUID);
    private final String displayName;
    private final ContainerType[] allowedContainerTypes;

    TruckType(String displayName, ContainerType... allowedContainerTypes) {
        this.displayName = displayName;
        this.allowedContainerTypes = allowedContainerTypes;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ContainerType[] getAllowedContainerTypes() {
        return allowedContainerTypes;
    }

}

