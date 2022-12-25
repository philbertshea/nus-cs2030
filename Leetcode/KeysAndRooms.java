
// 841. Keys and Rooms

package Leetcode;

import java.util.*;

public class KeysAndRooms {
    // rooms = [[1, 2], [2], [3], []]
    // Already have keys 0.
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> haveKeys = new ArrayList<>();
        List<Integer> notVisited = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        haveKeys.add(0);
        notVisited.add(0);

        while (notVisited.size() != 0) {
            System.out.println("haveKeys " + haveKeys + "\nVisited " + visited + "\nNotVisited " + notVisited + "\n");

            int notVisitedRoom = notVisited.remove(0);
            System.out.println("Visit room " + notVisitedRoom);

            for (int i = 0; i < rooms.get(notVisitedRoom).size(); i++) {
                int x = rooms.get(notVisitedRoom).get(i);
                System.out.println("Get keys " + x);
                if (!haveKeys.contains(x) && !visited.contains(x)) {
                    haveKeys.add(x);
                    notVisited.add(x);
                }
            }
            visited.add(notVisitedRoom);
        }

        System.out.println(haveKeys);

        return haveKeys.size() == rooms.size();

    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        List<Integer> room3 = new ArrayList<>();

        room0.add(1);
        room1.add(2);
        room2.add(3);

        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        System.out.println(canVisitAllRooms(rooms));
    }
}
