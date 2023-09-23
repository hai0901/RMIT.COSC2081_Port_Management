package FileHandling;

import User.PortManager;

import java.io.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import Container.*;
import Vehicle.*;
import Port.*;

import static java.awt.SystemColor.text;


public class File {
    public static String tripData = null;


    // Write to file
    public static void writeToFile(String fileName, String text, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        writer.write(text);
        writer.newLine();
        writer.close();
    }

    public static void writeToFileAutoDelete(String fileName, String text, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        writer.write(text);
        writer.newLine();
        writer.close();

        // Schedule line deletion after 1 minute
        scheduleLineDeletion(fileName, text, 1);
    }

    public static void scheduleLineDeletion(String fileName, String text, long minutesToKeep) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    removeLineFromFile(fileName, text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, minutesToKeep * 20 * 1000); // set timmer : 10sec
    }

    private static void removeLineFromFile(String fileName, String lineToRemove) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        List<String> updatedLines = new ArrayList<>();
        boolean lineFound = false;

        for (String line : lines) {
            if (!line.equals(lineToRemove)) {
                updatedLines.add(line);
            } else {
                lineFound = true;
            }
        }

        if (lineFound) {
            // Write the updated lines back to the file
            Files.write(path, updatedLines, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }


    // Read from file
    public static void readFromFileAndCreateList(String fileName, ArrayList list) {

    }

    // Update new content to file
    public static void updateToFile(String fileName, ArrayList<PortManager> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (PortManager manager : list) {
            writer.write(manager.toString());
            writer.newLine();
        }
        writer.close();
    }

    public static void fileWriteContainer(ArrayList<Container> list) throws IOException {
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/dContainer.txt", false));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/reContainer.txt", false));
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/lqContainer.txt", false));
        BufferedWriter writer4 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/otContainer.txt", false));
        BufferedWriter writer5 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/osContainer.txt", false));
        for (Container c : list) {
            if (c instanceof DryStorage) {
                writer1.write(c.getId() + "," + c.getWeight());
                writer1.newLine();
            } else if (c instanceof Refrigerated) {
                writer2.write(c.getId() + "," + c.getWeight());
                writer2.newLine();
            } else if (c instanceof Liquid) {
                writer3.write(c.getId() + "," + c.getWeight());
                writer3.newLine();
            } else if (c instanceof OpenTop) {
                writer4.write(c.getId() + "," + c.getWeight());
                writer4.newLine();
            } else {
                writer5.write(c.getId() + "," + c.getWeight());
                writer5.newLine();
            }
        }
        writer1.close();
        writer2.close();
        writer3.close();
        writer4.close();
        writer5.close();
    }
    public static void fileWritePort(ArrayList<Port> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/port.txt", false));
        for (Port port : list) {
            writer.write(port.getpNum() + "," + port.getpName() + "," + port.getpCapacity() + "," + port.getLatitude() + "," + port.getLongitude());
            writer.newLine();
        }
        writer.close();
    }
    public static void fileWriteVehicle(ArrayList<Vehicle> list) throws IOException {
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/bsTruck.txt", false));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/refTruck.txt", false));
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/tankTruck.txt", false));
        BufferedWriter writer4 = new BufferedWriter(new FileWriter("Assignment2_COSC2081/src/DataSource/ship.txt", false));

        for (Vehicle vehicle : list) {
            String PortID;
            if (vehicle.getCurrentPort() == null) {
                PortID = "null";
            } else {
                PortID = vehicle.getCurrentPort().getpNum();
            }
            if (vehicle instanceof BasicTruck) {
                writer1.write(vehicle.getVehID() + "," + vehicle.getName() + "," + vehicle.getCurrentFuel() + "," + vehicle.getCapacityFuel() + "," + PortID);
                writer1.newLine();
            } else if (vehicle instanceof ReeferTruck) {
                writer2.write(vehicle.getVehID() + "," + vehicle.getName() + "," + vehicle.getCurrentFuel() + "," + vehicle.getCapacityFuel() + "," + PortID);
                writer2.newLine();
            } else if (vehicle instanceof TankerTruck) {
                writer3.write(vehicle.getVehID() + "," + vehicle.getName() + "," + vehicle.getCurrentFuel() + "," + vehicle.getCapacityFuel() + "," + PortID);
                writer3.newLine();
            } else {
                writer4.write(vehicle.getVehID() + "," + vehicle.getName() + "," + vehicle.getCurrentFuel() + "," + vehicle.getCapacityFuel() + "," + PortID);
                writer4.newLine();
            }
        }
        writer1.close();
        writer2.close();
        writer3.close();
        writer4.close();
    }
    public static void fileWriteTrip(ArrayList<Trip> list) throws IOException {
        String fileName = "Assignment2_COSC2081/src/DataSource/trip.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

        for (Trip trip : list) {
            tripData = new String(trip.getVehicle().getVehID() + "," + trip.getDepartureDate() + "," + trip.getArrivalDate() + "," + trip.getDeparturePort().getpNum() + "," + trip.getArrivalPort().getpNum() + "," + trip.getStatus());
            writer.write(tripData);
            writer.newLine();
        }

        writer.close();

    }
}
