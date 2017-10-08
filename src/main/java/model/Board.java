package main.java.model;

public class Board {
    public Board(GameMode mode) {
        initField(mode);
    }
    private Stone[][] field;

    private void initField(GameMode mode) {
        if(mode==null) mode=GameMode.getDefault();
        this.field = new Stone[mode.getLineCount()][mode.getLineCount()];
    }

    public Stone[][] getField() {
        return field;
    }

    public boolean isEmpty(Integer x, Integer y) {
        return x == null || y == null || this.field[x][y] == null;
    }

    public void addStone(Point point, Stone stone) {
        this.field[point.getX()][point.getY()] = stone;
    }
}
