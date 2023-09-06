package cosc2081_2023_2_GroupName;

public class Container {
    private Integer cNumber;
    private String type;
    private double weight;

    public Container(Integer cNumber, String type, double weight) {
        this.cNumber = cNumber;
        this.type = type;
        this.weight = weight;
    }

    public Integer getcNumber() {
        return cNumber;
    }

    public void setcNumber(Integer cNumber) {
        this.cNumber = cNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Container{" +
                "cNumber=" + cNumber +
                ", type='" + type +
                ", weight=" + weight + '\'' +
                '}';
    }
}
