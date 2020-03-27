package Concurrency.Deadlocks.ComplicatedDeadlock;

public class Main {

    public static void main(String[] args) {

        final PolitePerson carlos = new PolitePerson("Carlos");
        final PolitePerson hugo = new PolitePerson("Hugo");

        new Thread(() -> carlos.sayHello(hugo)).start();

        new Thread(() -> hugo.sayHello(carlos)).start();

    }

    static class PolitePerson {

        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {

            System.out.format("%s: %s " + "has said hello to me%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {

            System.out.format("%s: %s " + "has said hello back to me%n", this.name, person.getName());
        }
    }
}
