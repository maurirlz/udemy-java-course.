package BasicInputAndOutput.InputAndOutput;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

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
