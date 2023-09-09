public class Container {
    /****************
     * Set variable.*
     ****************/

    private String conNum; //container's number
    private ContainerType conType; // container's type
    private double conWeight; //container weight

    public Container(String conNum, String conType, double conWeight, ContainerType ContainerType) {
        this.conNum = conNum;
        this.conType = ContainerType;
        this.conWeight = conWeight;
    }

    public String getConNum() {
        return conNum;
    }

    public ContainerType getConType() {
        return conType;
    }

    public double getConWeight() {
        return conWeight;
    }

    public void setConNum(String conNum) {
        this.conNum = conNum;
    }

    public void setConType(ContainerType conType) {
        this.conType = conType;
    }

    public void setConWeight(double conWeight) {
        this.conWeight = conWeight;
    }

    @Override
    public String toString() {
        return "Container{" +
                "conNum='" + conNum + '\'' +
                ", conType=" + conType +
                ", conWeight=" + conWeight +
                '}';
    }
}
