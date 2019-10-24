package agh.cs.lab4;

public class RectangularMap implements IWorldMap {

    Animal[][] map;
    private final int width;
    private final int height;
    public void RectangularMap(int width,int height)
    {
        this.map=new Animal[width-1][height-1];
        this.width=width;
        this.height=height;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!isOccupied(position)&&position.precedes(position.upperRight())&&position.follows(position.lowerLeft()))
                return true;
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(this.objectAt(position)==null)    return false;
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.map[position.x][position.y];
    }
}
