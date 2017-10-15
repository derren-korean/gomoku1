package main.java.util;

import main.java.model.Direction;
import main.java.model.Game;

import java.util.Arrays;
import java.util.List;

import main.java.model.Point;
import main.java.model.StoneColor;

public class GomokuUtil {
    private static GomokuUtil instance = new GomokuUtil();
    public static GomokuUtil getInstance() {
        return instance;
    }
    public List<Direction> directionList = Arrays.asList(Direction.UP, Direction.RIGHT_UP, Direction.RIGHT, Direction.RIGHT_DOWN, Direction.DOWN, Direction.LEFT_DOWN, Direction.LEFT, Direction.LEFT_UP);
    public Point getHighScorePosition(Game game, StoneColor color) {
        int minLineCount = 0;
        int maxLineCount = game.getGameMode().getLineCount();
        for (Integer x = 0; x < maxLineCount; x++) {
            for (Integer y = 0; y < maxLineCount; y++) {
                // 각 방향에 따라 maxLine까지 비어있음, 같은돌, 다른돌 을 구분하는 Enum을 갖음.
                // Tree로 wide는 Direction의 종류, depth는 maxLineCount까지의 길이.
                // 이때 wide는 종류 개수 만큼 가중치.
                // 이때 depth는 같은돌, 다른돌에 따라 가중치를 차등 부여.
            }
        }
        return null;
    }
}
