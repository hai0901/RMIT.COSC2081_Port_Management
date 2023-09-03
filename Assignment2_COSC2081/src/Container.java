public class Container {
    /****************
     * Set variable.*
     ****************/

    private String conNum; //container's number
    private String conType; // cotainer type
    private double conWeight; //container weight

    public Container(String conNum, String conType, double conWeight) {
        this.conNum = conNum;
        this.conType = conType;
        this.conWeight = conWeight;
    }

    public String getConNum() {
        return conNum;
    }

    public String getConType() {
        return conType;
    }

    public double getConWeight() {
        return conWeight;
    }

    public void setConNum(String conNum) {
        this.conNum = conNum;
    }

    public void setConType(String conType) {
        this.conType = conType;
    }

    public void setConWeight(double conWeight) {
        this.conWeight = conWeight;
    }
    /****************
     * Set method.*
     ****************/
}
