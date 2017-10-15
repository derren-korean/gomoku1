package main.java.model;

public class Board {
    public Board(main.java.model.GameMode mode) {
        initField(mode);
    }
    private main.java.model.Stone[][] field;

    private void initField(main.java.model.GameMode mode) {
        if(mode==null) mode= GameMode.getDefault();
        this.field = new main.java.model.Stone[mode.getLineCount()][mode.getLineCount()];
    }

    public main.java.model.Stone[][] getField() {
        return field;
    }

    public boolean isEmpty(Integer x, Integer y) {
        return x == null || y == null || this.field[x][y] == null;
    }

    public void addStone(Point point, Stone stone) {
        this.field[point.getX()][point.getY()] = stone;
    }
}
