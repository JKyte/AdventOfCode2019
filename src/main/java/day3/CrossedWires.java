package day3;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class CrossedWires {

    public static void main(String[] args) {
        String wireOne = "R8,U5,L5,D3";
        String wireTwo = "U7,R6,D4,L4"; //  Distance is 6
//        String wireOne = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
//        String wireTwo = "U62,R66,U55,R34,D71,R55,D58,R83"; //  Distance is 159
        Set<MyPoint> wireOnePoints = generatePoints(wireOne);
        Set<MyPoint> wireTwoPoints = generatePoints(wireTwo);

        System.out.println(wireOnePoints);
        System.out.println(wireTwoPoints);
        for (MyPoint p : wireOnePoints) {
            if (wireTwoPoints.contains(p)) {
                System.out.println(p.toString() + ": " + p.distance());
            }
        }


//        System.out.println(Sets.intersection(wireOnePoints, wireTwoPoints));
//        System.out.println(wireOnePoints.retainAll(wireTwoPoints));
    }

    public static void findClosestCross() {
        //  1. Generate points for all wires.
        //  2. Find all intersections.
        //  3. Find manhattan distance for those intersections.
    }

    public static Set<MyPoint> generatePoints(String wire) {
        int curX = 0;
        int curY = 0;
        Set<MyPoint> points = new HashSet<>();
        String[] chunks = StringUtils.split(wire, ',');
        for (String chunk : chunks) {
            char c = chunk.charAt(0);
            int len = Integer.parseInt(chunk.substring(1));
            System.out.println(c + ": " + len);
            for (int ii = 0; ii < len; ii++) {
                switch (c) {
                    case 'U':
//                        System.out.println("up");
                        curY++;
                        break;
                    case 'D':
//                        System.out.println("down");
                        curY--;
                        break;
                    case 'L':
//                        System.out.println("left");
                        curX--;
                        break;
                    case 'R':
//                        System.out.println("right");
                        curX++;
                        break;
                    default:
                        System.out.println("problem");
                        System.exit(0);
                }
                points.add(new MyPoint(curX, curY));
            }
        }
        return points;
    }

    private static class MyPoint implements Comparable<MyPoint> {
        public int x;
        public int y;

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance() {
            return Math.abs(x) + Math.abs(y);
        }

        @Override
        public String toString() {
            return "(" + x + " " + y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof MyPoint) {
                MyPoint other = (MyPoint) o;
                if (this.x == other.x && this.y == other.y) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(MyPoint o) {
            if (this.x == o.x && this.y == o.y) {
                return 0;
            }
            return -1;
        }
    }
}
