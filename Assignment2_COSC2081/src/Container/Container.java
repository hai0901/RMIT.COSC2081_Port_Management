package Container;

public abstract class Container {

    /****************
     * Set variable.*
     ****************/

    private String conNum; //container's number

    private double conWeight; //container weight

    public Container(String conNum, double conWeight) {
        this.conNum = conNum;

        this.conWeight = conWeight;
    }

    public String getConNum() {
        return conNum;
    }



    public double getConWeight() {
        return conWeight;
    }

    public void setConNum(String conNum) {
        this.conNum = conNum;
    }



    public void setConWeight(double conWeight) {
        this.conWeight = conWeight;
    }

    @Override
    public String toString() {
        return "Container.Container{" +
                "conNum='" + conNum + '\'' +
                ", conWeight=" + conWeight +
                '}';
    }
}
