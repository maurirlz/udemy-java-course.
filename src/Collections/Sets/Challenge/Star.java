package Collections.Sets.Challenge;

import java.util.Set;

public final class Star extends HeavenlyBody {


    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }

    @Override
    public Set<? extends HeavenlyBody> getSatellites() {
        return null;
    }

    @Override
    public boolean addSatellites(HeavenlyBody satellite) {
        return false;
    }
}
