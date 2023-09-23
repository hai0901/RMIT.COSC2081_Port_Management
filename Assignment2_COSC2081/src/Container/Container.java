package Container;

import Port.Port;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Container {
    private String id;
    private double weight;

    Container(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }
    private static final String CONTAINER_FILE = "./DataSource/container.txt";



    public static List<String> viewContainers() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(CONTAINER_FILE));
        List<String> containers = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            containers.add(line);
        }
        reader.close();
        return containers;
    }

    public static void addContainer(String containerId, double weight) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(CONTAINER_FILE, true));
        writer.write(containerId + "," + weight + "\n");
        writer.close();
    }

    public static void updateContainer(String containerId, double weight) throws IOException {
        List<String> containers = viewContainers();
        BufferedWriter writer = new BufferedWriter(new FileWriter(CONTAINER_FILE));
        for (String container : containers) {
            String[] parts = container.split(",");
            if (parts[0].equals(containerId)) {
                writer.write(containerId + "," + weight + "\n");
            } else {
                writer.write(container + "\n");
            }
        }
        writer.close();
    }

    public static void deleteContainer(String containerId) throws IOException {
        List<String> containers = viewContainers();
        BufferedWriter writer = new BufferedWriter(new FileWriter(CONTAINER_FILE));
        for (String container : containers) {
            if (!container.startsWith(containerId + ",")) {
                writer.write(container + "\n");
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        // Example usage:
        addContainer("C005", 20);
        List<String> containersAfterAdd = viewContainers();
        updateContainer("C005", 25);
        List<String> containersAfterUpdate = viewContainers();
        deleteContainer("C005");
        List<String> containersAfterDelete = viewContainers();

        System.out.println(containersAfterAdd);
        System.out.println(containersAfterUpdate);
        System.out.println(containersAfterDelete);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract double getShipFuelConsumption(Port A, Port B );

    public abstract double getTruckFuelConsumption( Port A, Port B );

    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }
}


