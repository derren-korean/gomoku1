package test.java;

import main.java.model.*;
import main.java.util.GomokuUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InitGame {

    private void init(GameMode mode) {
        GomokuUtil.getInstance().initGame(mode);
    }

    @Test
    public void 게임세팅() {
        init(GameMode.FIFTY_BY_FIFTY);
        GomokuUtil game = GomokuUtil.getInstance();
        gameMode(game.getGameMode(), GameMode.FIFTY_BY_FIFTY);
        boardCreateCheck(game.getBoard());
        totalCountCheck(game.getCurrentCount(), 0);
        recoderCreateCheck(game.getRecoder());
    }

    private void totalCountCheck(Integer exp, Integer result) {
        Assert.assertEquals(exp, result);
    }
    private void gameMode(GameMode result, GameMode exp) {
        Assert.assertEquals(exp, result);
    }
    private void boardCreateCheck(Board exp) {
        Assert.assertNotNull(exp);
    }
    private void recoderCreateCheck(List<Point> exp) {
        Assert.assertNotNull(exp);
    }

    @Test
    /**
     * 사용자가 돌을 Util에서 받아온다.
     * 이때 홀수는 흑, 짝수는 백을 갖게 된다.
     */

    public void 돌가져오기() {
        init(GameMode.FIFTY_BY_FIFTY);
        GomokuUtil game = GomokuUtil.getInstance();
        int totalCount = game.getGameMode().getLineCount() * game.getGameMode().getLineCount();
        for (int pointCount = 0; pointCount < totalCount; pointCount++) {
            StoneColor color = pointCount%2==0 ? StoneColor.BLACK : StoneColor.WHITE;
            stoneValidationCheck(game.getStone(), color, pointCount);
            game.useStone();
        }
    }
    private void stoneValidationCheck(Stone stone, StoneColor expColor, Integer expCount) {
        Assert.assertEquals(expColor, stone.getColor());
        Assert.assertEquals(expCount, stone.getStoneCount());
    }

    @Test
    /**
     * 모든 경우의 수를 두는 로직 체크는 여기서 행하지 않는다.
     * 여러 보드를 만들어 여러 경우의 수를 체크하는 것도 다른 곳에서 한다.
     */
    public void 착수() throws Exception {
        init(GameMode.FIFTY_BY_FIFTY);
        GomokuUtil game = GomokuUtil.getInstance();
        for (Integer x = 0; x < game.getGameMode().getLineCount(); x++) {
            for (Integer y = 0; y < game.getGameMode().getLineCount(); y++) {
                game.useStone(new Point(x,y), game.getStone());
            }
        }
        int totalCount = game.getGameMode().getLineCount() * game.getGameMode().getLineCount();
        for (Integer index = 0; index < totalCount; index++) {
            Point point = game.getRecoder().get(index);
            System.out.println(String.format("x:%d\ty:%d",point.getX(), point.getY()));
        }
        Board board = game.getBoard();
        for (Integer x = 0; x < game.getGameMode().getLineCount(); x++) {
            for (Integer y = 0; y < game.getGameMode().getLineCount(); y++) {
                Stone stone = board.getField()[x][y];
                System.out.println(String.format("x:%d\ty:%d\tcolor:%s\tstoneCount:%d",x,y,stone.getColor(), stone.getStoneCount()));
            }
        }
    }
}
