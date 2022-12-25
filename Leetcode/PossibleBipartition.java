/*We want to split a group of n people (labeled from 1 to n) into two groups of any size. 
Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] 
indicates that the person labeled ai does not like the person labeled bi, 
return true if it is possible to split everyone into two groups in this way. */

// E.g. n=4, dislikes = [[1,2], [1,3], [2,4]]
// Output: true (possible). Can split into [1,4] and [2,3]
// MUST SPLIT INTO TWO GROUPS. BUT EACH GROUP CAN BE OF ANY SIZE.
//886
package Leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class PossibleBipartition {
    public static List<List<Integer>> anyClash(int toAdd, List<Integer> list1, List<Integer> list2, List<Integer> idislike, List<Integer> rearrange, List<List<Integer>> allDislikes) {
        System.out.println("All Dislikes : " + allDislikes);
        System.out.println("List1 : " + list1);
        System.out.println("List2 : " + list2);

        List<Integer> list1dislike = new ArrayList<>(list1);
        list1dislike.retainAll(idislike);
        List<Integer> list2dislike = new ArrayList<>(list2);
        list2dislike.retainAll(idislike);

        if (!list1dislike.isEmpty() && !list2dislike.isEmpty()) {
            System.out.println("Try to add " + toAdd + "via rearrangement");
            System.out.println("Can rearrange " + rearrange);
            for (int i=0; i<rearrange.size(); i++) {
                int y = rearrange.get(i);
                System.out.println("Check y: " + y);
                if (!idislike.contains(y)) {
                    System.out.println("Insignificant to rearrange: " + y);
                    continue;
                }

                List<Integer> ydislike = new ArrayList<>(allDislikes.get(y-1));
                ydislike.retainAll(list2);
                System.out.println("ydislike : " + ydislike);
                System.out.println("y Dislike List : " + allDislikes.get(y-1));

                if (ydislike.isEmpty()) {
                    System.out.println("Can Rearrange " + y + " to list2!");
                    System.out.println("Remove position: " + list1.indexOf(y) + " from list1 and add to list 2!");
                    list1.remove(list1.indexOf(y));
                    list2.add(y);
                    rearrange.remove(i);
                    anyClash(toAdd, list1, list2, idislike, rearrange, allDislikes);
                }
            }
        } else if (list1dislike.isEmpty()) {
            list1.add(toAdd);
            if (list2dislike.isEmpty()) {
                rearrange.add(toAdd);
            }

        } else {
            list2.add(toAdd);
        }

        List<List<Integer>> lists = new ArrayList<>();
        if (list1.contains(toAdd) || list2.contains(toAdd)) {
            System.out.println("toAdd " + toAdd + " has been added!");
            lists.add(Arrays.asList(1));
        } else {
            lists.add(Arrays.asList(0));
        }
        lists.add(list1);
        lists.add(list2);
        lists.add(rearrange);
        return lists;

        /*
        boolean disInList1 = false;
        boolean disInList2 = false;

        for (int x : idislike) {
            if (!disInList1 && list1.contains(x)) {
                disInList1 = true;
            }
            if (!disInList2 && list2.contains(x)) {
                disInList2 = true;
            }
            if (disInList1 && disInList2) {
                for (int i=0; i<rearrange.size(); i++) {
                    int y = rearrange.get(i);
                    if (!idislike.contains(y)) {
                        continue;
                    }
                    List<Integer> ydislike = new ArrayList<>(allDislikes.get(y-1));
                    ydislike.retainAll(list2);
                    if (ydislike.isEmpty()) {
                        list1.remove(rearrangeIndex.get(i));
                    }
                }
            }
        }
        */
    }
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer> added = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> idislike = new ArrayList<Integer>();
        List<Integer> rearrange = new ArrayList<Integer>();
        List<List<Integer>> allDislikes = new ArrayList<>();
        boolean disInList1 = false;
        boolean disInList2 = false;

        /*
         * List<List<Integer>> allDis = new ArrayList<>();
         * for (int i = 0; i < dislikes.length; i++) {
         * Integer[] boxedArray = IntStream.of(dislikes[i])
         * .boxed()
         * .toArray(Integer[]::new);
         * List<Integer> dis = Arrays.asList(boxedArray);
         * allDis.add(dis);
         * }
         */

        for (int j = 1; j <= 19; j++) {
            System.out.println("List1 " + list1 );
            System.out.println("List2 " + list2 );
            System.out.println("Check " + j );
            disInList1 = false;
            disInList2 = false;
            idislike.clear();

            if (added.contains(j))
                continue;
            for (int[] dis : dislikes) {
                if (dis[0] == j || dis[1] == j) {
                    int other = dis[0] == j ? dis[1] : dis[0];
                    idislike.add(other);
                }
            }
            allDislikes.add(new ArrayList<>(idislike));
            System.out.println("I dislike " + idislike );

            List<List<Integer>> lists = anyClash(j, list1, list2, idislike, rearrange, allDislikes);
            if (lists.get(0).contains(0)) {
                return false;
            } else {
                list1 = lists.get(1);
                list2 = lists.get(2);
                rearrange = lists.get(3);
            }
            /*
            for (int x : idislike) {
                if (!disInList1 && list1.contains(x)) {
                    disInList1 = true;
                }
                if (!disInList2 && list2.contains(x)) {
                    disInList2 = true;
                }
                if (disInList1 && disInList2) {
                    System.out.println("Rearrange: " + rearrange);
                    return false;
                }
            }
            

            if (!disInList1 && !disInList2) {
                rearrange.add(j);
                rearrangeIndex.add(list1.size());
            }

            if (!disInList1) 
                list1.add(j);
            else if (!disInList2)
                list2.add(j);
            */
        }

        return true;
    }

    public static void main(String[] args) {
        int[] dis1 = { 1, 2 };
        int[] dis2 = { 1, 3 };
        int[] dis3 = { 2, 4 };
        int[][] dislikes = {{60,69},{27,46},{24,92},{17,20},{33,41},{73,82},{8,72},{12,17},{17,90},{13,20},{32,87},{60,81},{23,95},{8,87},{52,63},{26,54},{20,32},{21,37},{54,61},{6,41},{1,89},{18,36},{65,71},{44,55},{55,71},{54,99},{49,51},{4,12},{2,12},{26,49},{6,14},{4,42},{87,94},{58,59},{48,68},{3,55},{8,63},{25,70},{81,97},{1,82},{43,45},{17,50},{65,88},{37,63},{14,19},{45,47},{22,83},{50,51},{27,31},{59,89},{64,98},{71,90},{23,75},{14,65},{3,60},{9,81},{22,30},{54,91},{42,53},{33,98},{1,25},{92,99},{35,90},{9,67},{54,56},{28,43},{13,68},{16,33},{30,49},{50,82},{40,68},{43,49},{67,76},{30,64},{19,93},{7,70},{21,95},{83,87},{59,99},{57,87},{53,60},{68,100},{22,40},{6,47},{25,49},{50,77},{28,81},{26,65},{38,79},{90,93},{54,79},{31,91},{10,22},{21,88},{83,92},{9,98},{80,87},{32,70},{3,19},{59,94},{10,90},{82,85},{2,36},{49,100},{62,90},{39,76},{4,50},{10,45},{79,92},{38,88},{82,92},{39,59},{69,90},{15,50},{8,66},{96,97},{27,55},{4,19},{61,85},{36,89},{35,36},{36,39},{72,82},{12,56},{19,86},{23,100},{15,59},{51,97},{2,28},{24,49},{60,86},{15,33},{84,92},{32,74},{9,88},{21,24},{95,97},{29,40},{24,70},{59,69},{13,92},{36,52},{76,84},{7,64},{48,63},{45,57},{1,16},{65,100},{2,23},{90,100},{6,86},{5,46},{3,50},{70,96},{9,13},{6,71},{54,77},{31,99},{24,63},{46,86},{12,98},{23,80},{15,55},{45,67},{19,48},{14,66},{3,59},{34,60},{4,90},{27,76},{38,94},{12,37},{36,58},{51,66},{6,80},{15,22},{41,66},{18,68},{16,92},{8,73},{19,57},{59,79},{17,21},{23,27},{4,65},{1,80},{42,61},{51,54},{6,75},{3,87},{19,88},{45,62},{21,82},{20,57},{60,80},{25,50},{20,39},{62,74},{37,92},{13,64},{55,57},{9,32},{6,40},{39,90},{2,72},{7,45},{37,45},{42,56},{40,72},{37,55},{53,63},{30,46},{68,96},{1,34},{72,99},{87,95},{23,41},{6,35},{4,55},{63,89},{6,69},{49,83},{26,97},{76,77},{42,77},{47,78},{23,82},{27,50},{38,96},{28,53},{34,64},{22,39},{29,56},{16,19},{41,45},{13,76},{65,82},{42,52},{40,92},{10,29},{3,28},{60,91},{32,55},{39,65},{25,54},{29,43},{7,54},{28,89},{38,41},{12,52},{65,77},{76,89},{12,18},{56,76},{42,99},{51,63},{23,94},{21,58},{45,88},{71,97},{1,47},{34,76},{24,74},{17,38},{63,82},{28,80},{53,72},{36,48},{20,83},{20,30},{2,19},{50,57},{46,83},{1,14},{87,99},{38,71},{46,53},{27,63},{60,71},{23,77},{45,96},{62,85},{1,53},{4,49},{1,81},{17,31},{50,71},{40,49},{1,75},{65,95},{79,97},{26,31},{9,100},{1,7},{66,79},{56,64},{19,52},{59,84},{60,94},{25,36},{37,76},{32,50},{14,70},{25,78},{36,88},{29,80},{23,30},{10,49},{13,36},{55,84},{43,59},{31,84},{41,70},{41,72},{2,31},{33,91},{20,62},{68,80},{73,77},{36,71},{29,41},{10,74},{40,63},{30,54},{28,91},{11,53},{74,93},{6,79},{10,65},{20,52},{76,91},{42,71},{43,65},{47,68},{18,85},{23,88},{53,59},{34,74},{7,19},{22,41},{48,64},{6,44},{8,21},{30,72},{20,93},{6,88},{29,57},{10,23},{66,88},{22,95},{19,75},{44,72},{58,87},{26,60},{47,50},{72,77},{36,83},{34,63},{8,54},{31,37},{5,50},{26,73},{42,47},{72,83},{54,71},{41,50},{37,60},{9,25},{14,22},{38,51},{56,92},{1,5},{2,54},{56,66},{60,88},{4,28},{63,100},{34,54},{5,59},{9,56},{6,48},{41,59},{53,66},{76,94},{65,98},{2,29},{42,100},{46,69},{21,61},{19,37},{9,95},{6,39},{4,33},{8,36},{61,72},{38,75},{52,65},{41,60},{54,75},{31,95},{11,13},{45,56},{49,61},{41,87},{56,63},{70,83},{21,32},{34,72},{48,66},{11,86},{24,78},{2,66},{36,57},{5,55},{16,49},{4,92},{10,11},{47,97},{39,63},{56,87},{19,77},{11,24},{44,74},{28,71},{21,79},{9,47},{3,20},{60,67},{21,41},{28,52},{32,63},{11,79},{10,50},{4,97},{68,79},{58,92},{89,97},{20,51},{58,70},{37,72}};
        System.out.println(possibleBipartition(100, dislikes));
    }
}
