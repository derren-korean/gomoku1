package test.java;

public class WinTest {
    /**
     * 심판이 왼쪽 위 부터 포인트를 집어가며 돌을 탐색한다.
     * 돌을 발견하면, 해당 돌의 색과 좌표를 기준으로 다음
     */
//        static Direction[] directions = new Direction[6];
//
//        @Test
//        public void 숫자확인() {
//            int directionCount = 1;
//            for (int i = 0; i<9;i++) {
//                System.out.println(directionCount<<i);
//            }
//        }
//        /**
//         * 6개의 스택을 준비한다.
//         *
//         * 8방향을 돌면서 아래의 1-2까지 확인하면서, 색이 같고 좌표가 같은 후보를 stack[0]에 넣는다.
//         * 1. 색이 같음.
//         * 2. 각 좌표의 거리가 1이하.
//         *
//         * stack pop해서 온것을 기준으로, 1-2까지 stack[1 - 4]에 넣고, 3번에 해야당하지 않으면 pop
//         * 3. 방향이 같음.
//         *
//         * stack[6]에 1-3까지 충족한다면 stack[0]에서 pop하여 위의 알고리즘을 따라간다.
//         * stack[6]에 특별한 것이 없다면, 승리.
//         *
//         */
//        @Ignore
//        @Test
//        public void 연속성확인() {
//
//            Stone stone = new Stone().setColor(StoneColor.BLACK).setPoint(0, 0).setCount(0);
//            Stone stone1 = new Stone().setColor(StoneColor.WHITE).setPoint(0,1).setCount(1);
//            Stone stone2 = new Stone().setColor(StoneColor.BLACK).setPoint(0, 2).setCount(2);
//            Stone stone3 = new Stone().setColor(StoneColor.WHITE).setPoint(1, 0).setCount(5);
//
//            checkLinked(stone, stone1, StoneColor.BLACK, Direction.CENTER, 0, false);
////        checkLinked(stone, stone2, false);
////        checkLinked(stone, stone3, false);
////        checkLinked(stone1, stone3, true);
//        }
//
//        private void checkLinked(Stone reference, Stone target, StoneColor stoneColor, Direction direction, int linkCount, boolean hasNext) {
//            isSameColor(reference, target);
//        }
//
//        private boolean isSameColor(Stone reference, Stone target) {
//            return reference.getColor() == target.getColor();
//        }
//
//        /**
//         * 두개의 돌 색갈이 같은지 비교
//         */
//        @Test
//        public void 색깔비교() {
//            Stone stone = new Stone().setColor(StoneColor.BLACK).setPoint(0, 0).setCount(0);
//            Stone stone1 = new Stone().setColor(StoneColor.BLACK).setPoint(0,1).setCount(1);
//
//            Stone stone2 = new Stone().setColor(StoneColor.BLACK).setPoint(1, 1).setCount(2);
//            Stone stone3 = new Stone().setColor(StoneColor.WHITE).setPoint(1, 0).setCount(3);
//
//            Stone stone4 = new Stone().setColor(StoneColor.WHITE).setPoint(1, -1).setCount(4);
//            Stone stone5 = new Stone().setColor(StoneColor.BLACK).setPoint(0, -1).setCount(5);
//
//            Stone stone6 = new Stone().setColor(StoneColor.WHITE).setPoint(-1, -1).setCount(6);
//            Stone stone7 = new Stone().setColor(StoneColor.WHITE).setPoint(-1, 0).setCount(7);
//            checkSameColor(stone, stone1, true);
//            checkSameColor(stone2, stone3, false);
//            checkSameColor(stone4, stone5, false);
//            checkSameColor(stone6, stone7, true);
//        }
//
//        /**
//         * 돌의 순서가 흑백 순서대로 놓여지는지 확인.
//         */
//        @Test
//        public void 순서비교() {
//            Stone stone1 = new Stone().setColor(StoneColor.BLACK).setPoint(1, 1).setCount(0);
//            Stone stone2 = new Stone().setColor(StoneColor.WHITE).setPoint(1, 0).setCount(1);
//            isNumberInOrder(stone1, stone2, 1);
//        }
//
//        private void isNumberInOrder(Stone stone1, Stone stone2, int diff) {
//            Assert.assertEquals(Math.abs(stone1.getCount() - stone2.getCount()), diff);
//            System.out.println(String.format("stone1: %d\tstone2: %d\tdiff:%d", stone1.getCount(), stone2.getCount(), diff));
//        }
//
//        /**
//         * 거리가 1이상 차이나는지, 방향이 맞는지 확인.
//         */
//        @Test
//        public void 거리및방향확인() {
//            Stone stone = new Stone().setColor(StoneColor.BLACK).setPoint(0, 0).setCount(0);
//            Stone stone1 = new Stone().setColor(StoneColor.BLACK).setPoint(0,1).setCount(1);
//            Stone stone2 = new Stone().setColor(StoneColor.BLACK).setPoint(1, 1).setCount(2);
//            Stone stone3 = new Stone().setColor(StoneColor.BLACK).setPoint(1, 0).setCount(3);
//            Stone stone4 = new Stone().setColor(StoneColor.BLACK).setPoint(1, -1).setCount(4);
//            Stone stone5 = new Stone().setColor(StoneColor.BLACK).setPoint(0, -1).setCount(5);
//            Stone stone6 = new Stone().setColor(StoneColor.BLACK).setPoint(-1, -1).setCount(6);
//            Stone stone7 = new Stone().setColor(StoneColor.BLACK).setPoint(-1, 0).setCount(7);
//            Stone stone8 = new Stone().setColor(StoneColor.BLACK).setPoint(-1, 1).setCount(8);
//
//            checkDistance(stone , stone1, true);
//            checkDistance(stone , stone2, true);
//            checkDistance(stone , stone3, true);
//            checkDistance(stone , stone4, true);
//            checkDistance(stone , stone5, true);
//            checkDistance(stone , stone6, true);
//            checkDistance(stone , stone7, true);
//            checkDistance(stone , stone8, true);
//
//            checkDirection(stone , stone1, Direction.UP);
//            checkDirection(stone , stone2, Direction.RIGHT_UP);
//            checkDirection(stone , stone3, Direction.RIGHT);
//            checkDirection(stone , stone4, Direction.RIGHT_DOWN);
//            checkDirection(stone , stone5, Direction.DOWN);
//            checkDirection(stone , stone6, Direction.LEFT_DOWN);
//            checkDirection(stone , stone7, Direction.LEFT);
//            checkDirection(stone , stone8, Direction.LEFT_UP);
//        }
//
//        public void checkSameColor(Stone reference, Stone target, boolean same) {
//            Assert.assertEquals(reference.getColor() == target.getColor(), same);
//            System.out.println(String.format("ref: %s\tobj: %s\tboolean:%s", reference.getColor().name(), target.getColor().name(), same));
//        }
//
//        private void checkDistance(Stone ref, Stone target, boolean expectation) {
//            Integer rx = ref.getxAxis();
//            Integer tx = target.getxAxis();
//            Integer ry = ref.getyAxis();
//            Integer ty = target.getyAxis();
//            if (Math.abs(ry - ty) > 1 || Math.abs(rx - tx) > 1) {
//                System.err.println("거리가 2 이상이면 제외 exception");
//                Assert.assertEquals(true, false);
//            }
//        }
//
//        public void checkDirection(Stone ref, Stone obj, Direction direction) {
//            Integer rx = ref.getxAxis();
//            Integer ox = obj.getxAxis();
//            Integer ry = ref.getyAxis();
//            Integer oy = obj.getyAxis();
//
//            if (rx == ox && ry == oy) {
//                System.err.println("같은 위치에 존재할 수 없음");
//                Assert.assertEquals(true, false);
//            }
//            Direction result = null;
//            int xDiff = ox - rx;
//            int yDiff = oy - ry;
//            if (rx == ox) {
//                if (yDiff == 1) {
//                    result = Direction.UP;
//                } else if (yDiff == -1) {
//                    result = Direction.DOWN;
//                } else {
//                    System.err.println(yDiff);
//                    System.err.println("있어서는 안됨 exception");
//                    Assert.assertEquals(true, false);
//                }
//            } else if (ry == oy) {
//
//                if (xDiff == 1) {
//                    result = Direction.RIGHT;
//                } else if (xDiff == -1) {
//                    result = Direction.LEFT;
//                } else {
//                    System.err.println(xDiff);
//                    System.err.println("있어서는 안됨 exception");
//                    Assert.assertEquals(true, false);
//                }
//            } else if (xDiff == yDiff) {
//                if (xDiff == 1) {
//                    result = Direction.RIGHT_UP;
//                } else {
//                    result = Direction.LEFT_DOWN;
//                }
//            } else {
//                if (xDiff == 1) {
//                    result = Direction.RIGHT_DOWN;
//                } else {
//                    result = Direction.LEFT_UP;
//                }
//            }
//            System.out.println(String.format("x:%d\ty:%d\tlocated:%s",xDiff, yDiff, direction.getLocation()));
//            Assert.assertEquals(result, direction);
//        }
//        public boolean isSameAxis(int ref, int obj) {
//            return ref == obj;
//        }

}
