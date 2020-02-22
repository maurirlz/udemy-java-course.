package Collections.Sets.Challenge;

import java.util.Set;

public class Moon extends HeavenlyBody<Moon> {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }

    @Override
    public Set<? extends HeavenlyBody<Moon>> getSatellites() {
        return null;
    }

    @Override
    public boolean addSatellites(Moon satellite) {

        System.out.println("Moons can't have Satellites!");
        return false;
    }

}
