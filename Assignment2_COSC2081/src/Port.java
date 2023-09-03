public class Port {
    /****************
     * Set variable.*
     ****************/

    private String pNum; //port's number
    private String pName; //port's name
    private double pCapacity; //port's capacity
    private boolean landing; //port's landing ability
    private int numCon; // number of containers
    private int numVeh; // number of vehicles
    private Location location; // the location
    private int numDryCon; //number of Dry storage conatiner
    private int numTopCon; //number of Open top container
    private int numSideCon; //number of Open Side container
    private int numReCon; // number of Refrigerated container
    private int numLiquidCon; // number of Liquid container


    public Port(String pNum, String pName, double pCapacity, boolean landing, int numCon, int numVeh, Location location, int numDryCon, int numTopCon, int numSideCon, int numReCon, int numLiquidCon) {
        this.pNum = pNum;
        this.pName = pName;
        this.pCapacity = pCapacity;
        this.landing = landing;
        this.numCon = numCon;
        this.numVeh = numVeh;
        this.location = location;
        this.numDryCon = numDryCon;
        this.numTopCon = numTopCon;
        this.numSideCon = numSideCon;
        this.numReCon = numReCon;
        this.numLiquidCon = numLiquidCon;
    }

    public String getpNum() {
        return pNum;
    }

    public String getpName() {
        return pName;
    }

    public double getpCapacity() {
        return pCapacity;
    }

    public boolean isLanding() {
        return landing;
    }

    public int getNumCon() {
        return numCon;
    }

    public int getNumVeh() {
        return numVeh;
    }

    public Location getLocation() {
        return location;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpCapacity(double pCapacity) {
        this.pCapacity = pCapacity;
    }

    public void setLanding(boolean landing) {
        this.landing = landing;
    }

    public void setNumCon(int numCon) {
        this.numCon = numCon;
    }

    public void setNumVeh(int numVeh) {
        this.numVeh = numVeh;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // type of containers
    public int getNumDryCon() {
        return numDryCon;
    }

    public void setNumDryCon(int numDryCon) {
        this.numDryCon = numDryCon;
    }

    public int getNumTopCon() {
        return numTopCon;
    }

    public void setNumTopCon(int numTopCon) {
        this.numTopCon = numTopCon;
    }

    public int getNumSideCon(){
        return numSideCon;
    }

    public void setNumSideCon(int numSideCon){
        this.numSideCon =numSideCon;
    }
    public int getNumReCon() {
        return numReCon;
    }

    public void setNumReCon(int numReCon) {
        this.numReCon = numReCon;
    }

    public int getNumLiquidCon() {
        return numLiquidCon;
    }

    public void setNumLiquidCon(int numLiquidCon) {
        this.numLiquidCon = numLiquidCon;
    }

    /****************
     * Set method.*
     ****************/

}