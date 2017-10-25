package main.java.model;

public enum StoneColor {
    BLACK("#000000"),
    WHITE("#FFFFFF"),
    NONE(null);
    private String color;
    StoneColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static StoneColor getDefault() {
        return StoneColor.NONE;
    }
}
