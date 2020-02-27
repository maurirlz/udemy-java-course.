package BasicInputAndOutput.RandomAcessFile;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

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

        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {

            rao.writeInt(locations.size()); // point 1
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);

            long indexStart = rao.getFilePointer();

            int startPointer = locationStart;
            rao.seek(startPointer);

            for (Location location : locations.values()) {

                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction : location.getExits().keySet()) {

                    if (!direction.equalsIgnoreCase("q")) {

                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart);

            for (Integer locationID : index.keySet()) {

                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }
        }
    }

    // 1. The first four bytes will contain the number of locations (bytes 0 through 3)
    // 2. The next four bytes will contain the start of the locations section (bytes 4 through 7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long),  It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700/



    static {

        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while (ra.getFilePointer() < locationStartPoint) {

                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }


        } catch (IOException e) {

            System.out.println("IOException in static initializer: " + e.getMessage());
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
