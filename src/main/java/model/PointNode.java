package main.java.model;

import java.util.List;

public class PointNode {
    Direction direction;
    List<StoneColor> colorList;
    Integer score;

    public PointNode() {
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<StoneColor> getColorList() {
        return colorList;
    }

    public void setColorList(List<StoneColor> colorList) {
        this.colorList = colorList;
    }

    public Integer getScore() {
        return calcScore();
    }

    private Integer calcScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
