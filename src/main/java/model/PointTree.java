package main.java.model;

import java.util.List;

public class PointTree {
    List<PointNode> pointNodeList;
    Integer score;
    Point point;
    StoneColor color;

    public PointTree() {
    }

    public List<PointNode> getPointNodeList() {
        return pointNodeList;
    }

    public void setPointNodeList(List<PointNode> pointNodeList) {
        this.pointNodeList = pointNodeList;
    }

    public Integer getScore()
    {
        return calcScore();
    }

    private Integer calcScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public StoneColor getColor() {
        return color;
    }

    public void setColor(StoneColor color) {
        this.color = color;
    }
}
