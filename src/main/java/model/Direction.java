package main.java.model;

import java.util.stream.Stream;

public enum Direction {

    UP("상",0,1)
    ,LEFT("좌",-1,0)
    ,RIGHT("우",1,0)
    ,DOWN("하",0,-1)
    ,LEFT_UP("좌상",-1,1)
    ,RIGHT_UP("우상",1,1)
    ,LEFT_DOWN("좌하",-1,-1)
    ,RIGHT_DOWN("우하",1,-1)
    ,CENTER("시작",0,0);

    private String location;
    private Integer x;
    private Integer y;

    Direction() {
    }

    Direction(String location, Integer x, Integer y) {
        this.location = location;
        this.x = x;
        this.y = y;
    }

    public String getLocation() {
        return location;
    }

    private Integer getX() {
        return x;
    }

    private Integer getY() {
        return y;
    }

    public main.java.model.Point getPoint() {
        return new Point(getX(), getY());
    }

    public Direction getOppositeDirection() {
        int _x = -this.x;
        int _y = -this.y;
        return Stream.of(Direction.values()).filter(dir -> dir.getX() == _x && dir.getY() == _y).findFirst().get();
    }
}

