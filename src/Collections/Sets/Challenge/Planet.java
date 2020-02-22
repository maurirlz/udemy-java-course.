package Collections.Sets.Challenge;

import java.util.HashSet;
import java.util.Set;

public class Planet extends HeavenlyBody<Moon> {

    private final Set<Moon> satellites;

    public Planet(String name, double orbitalPeriod, Set<Moon> satellites) {
        super(name, orbitalPeriod);
        this.satellites = new HashSet<>(satellites);
    }


    @Override
    public boolean addSatellites(Moon satellite) {


        return this.satellites.add(satellite);
    }

    @Override
    public Set<? extends HeavenlyBody<Moon>> getSatellites() {

        return new HashSet<>(this.satellites);
    }
}
