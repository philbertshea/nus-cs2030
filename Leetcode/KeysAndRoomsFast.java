package Leetcode;

import java.util.*;

public class KeysAndRoomsFast {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] visited = new boolean[rooms.size()];
            int count = 0;
            count = dfs(rooms, 0, visited, count);
            return count == rooms.size();
        }

        public int dfs(List<List<Integer>> rooms, int currRoom, boolean[] visited, int count) {
            if (visited[currRoom] == true) {
                return count;
            }
            visited[currRoom] = true;
            ++count;
            for (Integer roomKey : rooms.get(currRoom)) {
                count = dfs(rooms, roomKey, visited, count);
            }
            return count;
        }
    }

    // OR
    class Solution2 {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {

            var seen = new HashSet<Integer>();

            var q = new ArrayDeque<Integer>();
            q.offer(0);
            seen.add(0);

            while (!q.isEmpty()) {
                var key = q.poll();

                for (var k : rooms.get(key)) {
                    if (!seen.contains(k)) {
                        seen.add(k);
                        q.offer(k);
                    }
                }
            }

            return seen.size() == rooms.size();
        }
    }
}
