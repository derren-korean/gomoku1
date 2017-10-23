package main.java.model;

public enum StoneColor {
    BLACK("흑"),
    WHITE("백"),
    NONE("무");
    private String color;
    StoneColor(String color) {}

    public String getColor() {
        return color;
    }

    public static StoneColor getDefault() {
        return StoneColor.NONE;
    }
}
