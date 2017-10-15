package main.java.model;

public class Stone {
    public Stone(main.java.model.StoneColor color, Integer stoneCount) {
        this.color = color;
        this.stoneCount = stoneCount;
    }
    private main.java.model.StoneColor color;
    private Integer stoneCount;

    public StoneColor getColor() {
        return color;
    }

    public Integer getStoneCount() {
        return stoneCount;
    }
}
