package ObjectOrientedProgramming.Polymorphism;

class Movie {
    private String movieName;

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public String moviePlot() {
        return "No plot here";
    }

    public String getMovieName() {
        return movieName;
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String moviePlot() {
        return "A shark eats a lot  of people.";
    }
}

class IndependenceDay extends Movie {

    public IndependenceDay() {
        super("Independence day");
    }

    @Override
    public String moviePlot() {
        return "Aliens attempt to take over the earth.";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze runner");
    }

    @Override
    public String moviePlot() {
        return "Kids try and escape a maze.";
    }
}

class StarWars extends Movie {

    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String moviePlot() {
        return "Imperial forces try to take over the universe.";
    }
}

class ForgettableMovie extends Movie {

    public ForgettableMovie() {
        super("Forgettable  movie");
    }

    // no plot method.
}

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #"
                    + i +
                    ": " + movie.getMovieName() + "\n"
                    + "Plot: " + movie.moviePlot() + "\n");
        }

    }

    public static Movie randomMovie() {

        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated  was: " + randomNumber);

        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return  new StarWars();
            case 5:
                return  new ForgettableMovie();
        }
        return null;
    }
}

