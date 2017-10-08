package main.java.util;

import main.java.model.*;

import java.util.ArrayList;
import java.util.List;

public class GomokuUtil {
    private static GomokuUtil instance = new GomokuUtil();
    public static GomokuUtil getInstance() {
        return instance;
    }
    private Board board;
    private List<Point> recoder;
    private Integer currentCount;
    private GameMode gameMode;
    public void initGame(GameMode mode) {
        this.board = new Board(mode);
        this.currentCount = new Integer(0);
        this.recoder = new ArrayList<>();
        if(mode==null) mode=GameMode.getDefault();
        this.gameMode = mode;
    }
    public Integer getCurrentCount() {
        return currentCount;
    }
    private void incCount() {
        this.currentCount++;
    }
    public boolean isOccupied(Integer x, Integer y) {
        return !this.board.isEmpty(x, y);
    }
    private void addStone(Point point, Stone stone) throws Exception {
        if(point.isEmpty()) throw new Exception();
        this.recoder.add(point);
        this.board.addStone(point,stone);
        incCount();
    }

    public Board getBoard() {
        return board;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public List<Point> getRecoder() {
        return recoder;
    }

    public void useStone() {
        incCount();
    }

    public void useStone(Point point, Stone stone) throws Exception {
        addStone(point, stone);
    }

    public Stone getStone() {
        StoneColor color = this.currentCount %2==0 ? StoneColor.BLACK : StoneColor.WHITE;
        return new Stone(color, currentCount);
    }
}
