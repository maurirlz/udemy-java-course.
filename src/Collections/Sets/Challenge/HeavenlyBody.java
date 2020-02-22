package Collections.Sets.Challenge;

import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody<T extends HeavenlyBody<T>>  {

    /*
        Modify the previous HeavenlyBody example so that the HeavenlyBody
        class also has a "bodyType" field. This field will store the
        type of HeavenlyBody (such as STAR, PLANET, MOON, etc).

        You can include as many types as you want, but must support at
        least PLANET and MOON.

        For each of the types that you support, subclass the HeavenlyBody class
        so that your program can create objects of the appropriate type.

        Although astronomers may shudder at this, our solar systems will
        allow two bodies to have the same name as long as they are not the
        same type of body: so you could have a star called "BetaMinor" and
        an asteroid also called "BetaMinor", for example.

        Hint: This is much easier to implement for the Set than it is for the Map,
        because the Map will need a key that uses both fields.

        There is a restriction that the only satellites that planets can have must
        be moons. Even if you don't implement a STAR type, though, your program
        should not prevent one being added in the future (and a STAR's satellites
        can be almost every kind of HeavenlyBody).

        Test cases:
        1. The planets and moons that we added in the previous video should appear in
        the solarSystem collection and in the sets of moons for the appropriate planets.

        2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.

        3. Attempting to add a duplicate to a Set must result in no change to the set (so
        the original value is not replaced by the new one).

        4. Attempting to add a duplicate to a Map results in the original being replaced
        by the new object.

        5. Two bodies with the same name but different designations can be added to the same set.

        6. Two bodies with the same name but different designations can be added to the same map,
        and can be retrieved from the map.
*/

    private final String name;
    private final String bodyType;
    private final double orbitalPeriod;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }

    public String getBodyType() {
        return bodyType;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getKeyName() {

        return name + " " + bodyType;
    }

    public abstract Set<? extends HeavenlyBody<T>> getSatellites();

    public abstract boolean addSatellites(T satellite);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeavenlyBody<?> that = (HeavenlyBody<?>) o;
        return Double.compare(that.getOrbitalPeriod(), getOrbitalPeriod()) == 0 &&
                getName().equals(that.getName()) &&
                getBodyType().equals(that.getBodyType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBodyType(), getOrbitalPeriod());
    }
}
