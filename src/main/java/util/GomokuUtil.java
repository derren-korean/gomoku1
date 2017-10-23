package main.java.util;

import main.java.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GomokuUtil {
    private static GomokuUtil instance = new GomokuUtil();
    public static GomokuUtil getInstance() {
        return instance;
    }
    final static private Integer MIN_LINE_COUNT = 0;
    public Point getHighScoreByPoint(Game game, StoneColor color) {
        Point maxPoint = new Point(0,0);
        int minLineCount = 0;
        int maxLineCount = game.getGameMode().getLineCount();
        List<PointTree> pointTreeList = new ArrayList<>();
        for (Integer x = 0; x < maxLineCount; x++) {
            for (Integer y = 0; y < maxLineCount; y++) {
                // 각 방향에 따라 maxLine까지 비어있음, 같은돌, 다른돌 을 구분하는 Enum을 갖음.
                // Tree로 width는 Direction의 종류, depth는 maxLineCount까지의 길이.
                // 이때 wide는 종류 개수 만큼 가중치.
                // 이때 depth는 같은돌, 다른돌에 따라 가중치를 차등 부여.
                Point _point = new Point(x, y);
                // tree를 만든다.
                pointTreeList.add(makeTree(game, _point, color));
            }
        }
        return getHighestScore(pointTreeList);
    }

    private Point getHighestScore(List<PointTree> pointTreeList) {
        return null;
    }

    /**
     * step1. 8개 방향에 대하여 end of line까지 모든 돌의 상황을 만든다.
     * @param point
     */
    public PointTree makeTree(Game game, Point point, StoneColor color) {
        if (game == null || point == null || color == null) return null;
        PointTree pointTree = new PointTree();
        List<PointNode> pointNodeList = new ArrayList<>();
        for (Direction direction : getDirectionList()) {
            PointNode pointNode = new PointNode();
            System.out.println(String.format("%s\t%s",point, direction.getLocation()));
            pointNode.setDirection(direction);
            List<StoneColor> stoneColorList = new ArrayList<>();
//            if (game.getLocationColor(point) != StoneColor.NONE) {
                stoneColorList.add(game.getLocationColor(point));
                Point _point = calcPoint(point, direction.getPoint());
                while (!isEndOfTheLine(game, _point, direction)) {
//                    System.out.println(String.format("%s\t%s",_point, direction.getLocation()));
                    stoneColorList.add(game.getLocationColor(_point));
                    _point = calcPoint(_point, direction.getPoint());
                }
//            }
            if (stoneColorList != null || !stoneColorList.isEmpty()) {
                pointNode.setColorList(stoneColorList);
            }
            pointNodeList.add(pointNode);
        }
        pointTree.setPointNodeList(pointNodeList);
        pointTree.setColor(color);
        pointTree.setPoint(point);
        return pointTree;
    }

    private Point calcPoint(Point p1, Point p2) {
        int x = p1.getX() - p2.getX();
        int y = p1.getY() - p2.getY();
        return new Point(x,y);
    }

    private List<Direction> getDirectionList() {
        return Arrays.asList(Direction.UP, Direction.RIGHT_UP, Direction.RIGHT, Direction.RIGHT_DOWN, Direction.DOWN, Direction.LEFT_DOWN, Direction.LEFT, Direction.LEFT_UP);
    }
    // 최고점 = 다른 돌이 4개 연속.
    // 최저점 = 거리가 1 인 곳에 다른 돌.
//    private int getScore(Game game, StoneColor color, Point point, Direction direction, int score, int count) {
//        if (isEndOfTheLine(game, point, direction) || score < 0) return score;
//
//        // 비어있는지 색이 같은지 다른지에 따라 스코어를 매김
//        score = getPointScore(game, point, color, count);
//        return getScore(game, color, point, direction, score, ++count);
//    }

//    private int getPointScore(Game game, Point point, StoneColor color, int count) {
//        int score = 0;
//        if (game.isOccupied(point)) {
//            score = game.getLocationColor(point).equals(color) ? getSameColorScore(count) : getDiffColorScore(count);
//        } else {
//            score = 1;
//        }
//        return score;
//    }
//
//    private int getSameColorScore(int count) {
//        int score = 1000;
//        if (count == 6) {
//        }
//        return count == 6 ?
//    }
//
//    private int getDiffColorScore(int count) {
//        int score = 0;
//        switch (count) {
//            case 0 : score = -1;
//            break;
//            case 1 :
//            break;
//            case 2 :
//            break;
//            case 3 :
//            break;
//            case 4 :
//            break;
//            case 5 :
//            break;
//            case 6 :
//            break;
//        }
//        return score;
//    }

    private boolean isEndOfTheLine(Game game, Point point, Direction direction) {
        if (isOutOfIndex(game.getMaxLineCount(), point)) return true;
        switch (direction) {
            case UP:
                return isYLineMax(game, point);
            case DOWN:
                return isYLineMin(point);
            case LEFT:
                return isXLineMin(point);
            case RIGHT:
                return isXLineMax(game, point);
            case LEFT_UP:
                return isXLineMin(point) && isYLineMax(game, point);
            case RIGHT_UP:
                return isXLineMax(game, point) && isYLineMax(game, point);
            case LEFT_DOWN:
                return isXLineMin(point) && isYLineMin(point);
            case RIGHT_DOWN:
                return isXLineMax(game, point) && isYLineMin(point);
            default:
                return false;
        }
    }

    private boolean isOutOfIndex(Integer maxCount, Point point) {
        return isOutOfIndex(maxCount, point.getX()) || isOutOfIndex(maxCount, point.getY());
    }

    private boolean isOutOfIndex(Integer maxCount, Integer axis) {
        return axis < MIN_LINE_COUNT || axis > maxCount;
    }

    private boolean isMin(Integer axis) {
        return axis.equals(MIN_LINE_COUNT);
    }

    private boolean isYLineMax(Game game, Point point) {
        return isSame(game.getMaxLineCount(), point.getY());
    }

    private boolean isYLineMin(Point point) {
        return isMin(point.getY());
    }

    private boolean isXLineMax(Game game, Point point) {
        return isSame(game.getMaxLineCount(), point.getX());
    }

    private boolean isXLineMin(Point point) {
        return isMin(point.getX());
    }

    private boolean isSame(Integer lineCount, Integer axis) {
        return lineCount.equals(axis);
    }
}
