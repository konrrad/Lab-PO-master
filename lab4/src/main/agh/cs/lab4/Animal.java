package agh.cs.lab4;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    public Animal() {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map)
    {
       this.map=map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.map=map;
        this.position=initialPosition;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }


    @Override
    public String toString() {
        position.toString();
    }

    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        } else if (direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
        } else if (direction == MoveDirection.FORWARD) {

            Vector2d potentialPos = this.position.add(this.orientation.toUnitVector());
            if (!(potentialPos.x < 0 || potentialPos.y < 0 || potentialPos.x > 4 || potentialPos.y > 4)&&map.canMoveTo(potentialPos))
                this.position = potentialPos;
        } else if (direction == MoveDirection.BACKWARD) {
            Vector2d potentialPos = this.orientation.toUnitVector().opposite().add(this.position);
            if (!(potentialPos.x < 0 || potentialPos.y < 0 || potentialPos.x > 4 || potentialPos.y > 4)&&map.canMoveTo(potentialPos))
                this.position = potentialPos;
        }


    }
}
