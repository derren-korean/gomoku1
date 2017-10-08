package main.java.model;

public enum Direction {

    UP("상",2)
    ,LEFT("좌",4)
    ,RIGHT("우",8)
    ,DOWN("하",16)
    ,LEFT_UP("좌상",32)
    ,RIGHT_UP("우상",64)
    ,LEFT_DOWN("좌하",128)
    ,RIGHT_DOWN("우하",256)
    ,CENTER("시작", 1);

    private String location;
    private Integer number;

    Direction() {
    }

    Direction(String location, Integer number) {
        this.location = location;
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public Integer getNumber() {
        return number;
    }
}

