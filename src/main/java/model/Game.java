package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private main.java.model.Board board;
    private List<Point> recoder;
    private Integer currentCount;
    private main.java.model.GameMode gameMode;
    private Integer maxLineCount;

    public Game(main.java.model.GameMode gameMode) {
        initGame(gameMode);
    }

    public void initGame(main.java.model.GameMode mode) {
        this.board = new main.java.model.Board(mode);
        this.currentCount = new Integer(0);
        this.recoder = new ArrayList<>();
        if(mode==null) mode= main.java.model.GameMode.getDefault();
        this.gameMode = mode;
        this.maxLineCount = mode.getLineCount();
    }

    public Integer getCurrentCount() {
        return currentCount;
    }
    private void incCount() {
        this.currentCount++;
    }

    public boolean isOccupied(main.java.model.Point point) {
        return isOccupied(point.getX(), point.getY());
    }
    private boolean isOccupied(Integer x, Integer y) {
        return !isEmpty(x, y);
    }

    private boolean isEmpty(Integer x, Integer y) {
        return this.board.isEmpty(x, y);
    }

    //@Deprecated
    public Board getBoard() {
        return board;
    }

    //@Deprecated
    public GameMode getGameMode() {
        return gameMode;
    }

    //@Deprecated
    public List<main.java.model.Point> getRecoder() {
        return recoder;
    }

    //@Deprecated
    public void useStone() {
        incCount();
    }

    public Integer getMaxLineCount() {
        return maxLineCount;
    }

    public void useStone(main.java.model.Point point, main.java.model.Stone stone) throws Exception {
        addStone(point, stone);
    }

    public main.java.model.Stone getStone() {
        main.java.model.StoneColor color = this.currentCount %2==0 ? main.java.model.StoneColor.BLACK : StoneColor.WHITE;
        return new main.java.model.Stone(color, currentCount);
    }

    private void addStone(main.java.model.Point point, Stone stone) throws Exception {
        validatePoint(point);
        this.recoder.add(point);
        this.board.addStone(point,stone);
        incCount();
    }

    private void validatePoint(Point point) throws Exception {
        if (point.isEmpty()) throw new Exception();
        if (isOccupied(point)) {
            System.err.println("이미 놓여있는 장소 입니다. 다른 곳을 선택하세요.");
            throw new Exception();
        }
    }

    public StoneColor getLocationColor(Point point) {
        return getLocationStone(point) == null ? StoneColor.NONE : getLocationStone(point).getColor();
    }

    private Stone getLocationStone(Point point) {
        return this.board.getField()[point.getX()] == null ? null : this.board.getField()[point.getX()][point.getY()];
    }
}
