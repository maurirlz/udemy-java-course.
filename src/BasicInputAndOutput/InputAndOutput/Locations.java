package BasicInputAndOutput.InputAndOutput;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        // Character writing using FileWriter and BufferedWriter

//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//            BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//
//            for (Location location : locations.values()) {
//
//                locFile.write(location.getLocationID() + " - " + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//
//                    if (!direction.equalsIgnoreCase("q")) {
//
//                        dirFile.write(location.getLocationID() + " - " + direction + " - " + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }

        // Byte stream wiriting using DataOutputStream with BufferedOutputStream and FileOutputStream

//        try (DataOutputStream locFIle = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//
//
//            for (Location location : locations.values()) {
//
//                locFIle.writeInt(location.getLocationID());
//                locFIle.writeUTF(location.getDescription());
//                System.out.println("writing location " + location.getLocationID() + " : " + location.getDescription());
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits");
//                locFIle.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()) {
//
//                    if (!direction.equalsIgnoreCase("q")) {
//
//                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
//                        locFIle.writeUTF(direction);
//                        locFIle.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {

            for (Location location : locations.values()) {

                locFile.writeObject(location);
            }
        }
    }

    static {

//        try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"));
//             BufferedReader dirFIle = new BufferedReader(new FileReader("directions_big.txt"))){
//
//            scanner.useDelimiter(",");
//
//            while (scanner.hasNextLine()) {
//
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//
//                Map<String, Integer> tempExit = new LinkedHashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//
//            // read exits
//
//            String input;
//
//            while ((input = dirFIle.readLine()) != null) {
//
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + " : " + direction + " : " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//
//            }
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }

//        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
//
//            boolean eof = false;
//
//            while (!eof) {
//
//                try {
//
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//
//                    System.out.println("Read location " + locID + " : " + description);
//                    System.out.println("Found " + numExits + " exits");
//
//                    for (int i = 0; i < numExits; i++) {
//
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//
//                    locations.put(locID, new Location(locID, description, exits));
//                } catch (EOFException e) {
//
//                    eof = true;
//                }
//            }
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {

            boolean eof = false;

                while (!eof) {
                    try {

                        Location location = (Location) locFile.readObject();
                        System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                        System.out.println("Found " + location.getExits().size() + " exits");

                        locations.put(location.getLocationID(), location);
                    } catch (EOFException e) {

                        eof = true;
                    }
                }
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public int size() {

        return locations.size();
    }

    @Override
    public boolean isEmpty() {

        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {

        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {

        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {

        return locations.get(key);
    }

    @Nullable
    @Override
    public Location put(Integer key, Location value) {

        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {

        return locations.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {

        locations.clear();
    }

    @NotNull
    @Override
    public Set<Integer> keySet() {

        return locations.keySet();
    }

    @NotNull
    @Override
    public Collection<Location> values() {

        return locations.values();
    }

    @NotNull
    @Override
    public Set<Entry<Integer, Location>> entrySet() {

        return locations.entrySet();
    }
}
