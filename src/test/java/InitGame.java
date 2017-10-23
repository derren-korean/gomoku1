package test.java;

import main.java.model.*;
import main.java.util.GomokuUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InitGame {

    private Game init(GameMode mode) {
        return new Game(mode);
    }

    @Test
    public void 게임세팅() {
        Game game = init(GameMode.FIFTY_BY_FIFTY);
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
    public void 돌가져오기() throws Exception {
        Game game = init(GameMode.FIFTY_BY_FIFTY);
        int totalCount = game.getGameMode().getLineCount() * game.getGameMode().getLineCount();
        for (int pointCount = 0; pointCount < totalCount; pointCount++) {
            StoneColor color = pointCount%2==0 ? StoneColor.BLACK : StoneColor.WHITE;
            stoneValidationCheck(game.getStone(), color, pointCount);
            game.useStone();
        }

        Game game2 = init(GameMode.FIFTY_BY_FIFTY);
        for (Integer x = 0; x < game2.getGameMode().getLineCount(); x++) {
            for (Integer y = 0; y < game2.getGameMode().getLineCount(); y++) {
                game2.useStone(new Point(x,y), game2.getStone());
            }
        }
        for (Integer index = 0; index < totalCount; index++) {
            Point point = game2.getRecoder().get(index);
            System.out.println(String.format("x:%d\ty:%d",point.getX(), point.getY()));
        }
        Board board = game2.getBoard();
        for (Integer x = 0; x < game2.getGameMode().getLineCount(); x++) {
            for (Integer y = 0; y < game2.getGameMode().getLineCount(); y++) {
                Stone stone = board.getField()[x][y];
                System.out.println(String.format("x:%d\ty:%d\tcolor:%s\tstoneCount:%d",x,y,stone.getColor(), stone.getStoneCount()));
            }
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
        Game game = init(GameMode.FIFTY_BY_FIFTY);
        PointTree pointTree = GomokuUtil.getInstance().makeTree(game, new Point(0, 0), StoneColor.BLACK);
        File file = new File("/Users/derren/dev/temp/Gomok/tree.txt");
        FileWriter fw = new FileWriter(file);
        pointTree.getPointNodeList().forEach(node -> {
            node.getColorList().forEach(color -> {
                try {
                    fw.write(String.format("\t%s",color.name()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        fw.flush();
        fw.close();
    }

}
