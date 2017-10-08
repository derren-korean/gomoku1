package main.java.model;

public enum StoneColor {
    BLACK("흑"),
    WHITE("백");
    private String color;
    StoneColor(String color) {}
    public static StoneColor getDefault() {
        return StoneColor.BLACK;
    }
}
