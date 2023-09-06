package cosc2081_2023_2_GroupName;

import java.util.ArrayList;

public class Port {
    private String name;
    private Integer pNumber;
    private double storingCap;
    private boolean landingAbi;
    private ArrayList<Vehicle> numberVeh;
    private ArrayList<Container> numberContain;



    Port() {
        this.name = "none";
    }
    Port(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Port{" +
                "name='" + name + '\'' +
                '}';
    }
}
