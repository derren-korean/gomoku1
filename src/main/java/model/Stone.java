package main.java.model;

public class Stone {
    public Stone(StoneColor color, Integer stoneCount) {
        this.color = color;
        this.stoneCount = stoneCount;
    }
    private StoneColor color;
    private Integer stoneCount;

    public StoneColor getColor() {
        return color;
    }

    public Integer getStoneCount() {
        return stoneCount;
    }
}
