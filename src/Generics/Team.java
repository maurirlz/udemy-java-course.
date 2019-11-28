package Generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    private int played = 0;
    private int won = 0;
    private int tied = 0;
    private int lost = 0;

    private List<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {

        if (members.contains(player)) {

            System.out.println(player.getName() + " is already on the team");
            return false;
        } else {

            members.add(player);
            System.out.println(player.getName() + " picked for team: " + this.name);
            return true;
        }
    }

    public int numPlayer() {

        return this.members.size();
    }

    public void matchResult(Team<T> oponent, int ourScore, int theirScore) {

        String message;
        if (ourScore > theirScore) {
            message = " beat ";
            this.won++;
        } else if (ourScore == theirScore) {
            message = " draw with";
            this.tied++;
        } else {
            message = " lost to";
            this.lost++;
        }

        this.played++;
        if (oponent != null) {

            System.out.println(this.getName() + message + oponent.getName());
            oponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {

        return (this.won * 2) + this.tied;
    }

    @Override
    public int compareTo(@NotNull Team<T> o) {

        if (this.ranking() > o.ranking()) {

            return -1;
        } else if (this.ranking() == 0) {

            return 0;
        } else {

            return 1;
        }
    }
}
