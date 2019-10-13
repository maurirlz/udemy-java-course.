package ObjectOrientedProgramming.ClassesObjectsConstructors.Inheritance;

public class Executable {
    public static void main(String[] args) {

        Animal animal = new Animal("Animal",1,1,5,5);
        Dog dog = new Dog("Yorkie",1,20,20,"long silky",2,4,1,20);
        dog.run(10);
        dog.move(40);

    }
}
