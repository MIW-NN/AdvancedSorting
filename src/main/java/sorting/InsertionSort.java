package sorting;

import java.util.Collections;
import java.util.List;

/**
 * @author Vincent Velthuizen
 * Sorts any list using insertion sort
 */
public class InsertionSort {

    public static <L extends Comparable<? super L>> void sort(List<L> list) {
        sort(list, false);
    }

    public static <L extends Comparable<? super L>> void sort(List<L> list, boolean debug) {
        if (debug) {
            System.out.println("start: " + list.subList(0, 1) + " " + list.subList(1, list.size()));
        }
        for (int itemBeingSorted = 1; itemBeingSorted < list.size(); itemBeingSorted++) {
            int currentPosition = itemBeingSorted;
            while (currentPosition > 0
                    && list.get(currentPosition - 1).compareTo(list.get(currentPosition)) > 0) {
                Collections.swap(list, currentPosition, currentPosition - 1);
                currentPosition--;
                if (debug) {
                    System.out.println("swap : " + list.subList(0, itemBeingSorted + 1));
                }
            }
            if (debug) {
                System.out.printf("state: %s %s\n",
                        list.subList(0, itemBeingSorted + 1),
                        list.subList(itemBeingSorted + 1, list.size()));
            }
        }
    }

}
