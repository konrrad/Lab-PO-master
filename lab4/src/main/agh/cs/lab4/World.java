package agh.cs.lab4;


public class World {

    public static void main(String[] args) {

        final Animal animal = new Animal();
        final MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection direction : directions) {
            animal.move(direction);
            System.out.println(animal);
        }


    }
}
