package sorting;

import java.util.Collections;
import java.util.List;

/**
 * @author Vincent Velthuizen
 * Sorts any List using quick sort
 */
public class QuickSort {
    public static <L extends Comparable<? super L>> void sort(List<L> list) {
        sort(list, false);
    }

    public static <L extends Comparable<? super L>> void sort(List<L> list, boolean debug) {
        if (list.size() <= 1) {
            return;
        }

        Collections.shuffle(list);
        L pivot = list.get(0);

        int leftIndex = 1;
        int rightIndex = list.size() - 1;

        while (leftIndex <= rightIndex) {
            // find an element bigger than the pivot from the left of the list
            while (leftIndex <= rightIndex && list.get(leftIndex).compareTo(pivot) < 0) {
                leftIndex++;
            }
            // find an element smaller than the pivot from the right of the list
            while (rightIndex >= leftIndex && list.get(rightIndex).compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex < rightIndex) {
                // if they haven't crossed over, swap the items so that the small element ends up on the left and the big one on the right
                Collections.swap(list, leftIndex, rightIndex);
                leftIndex++;
            } else {
                // if they have crossed over, the leftIndex should be pointing to the first element of the elements bigger than the pivot.
                // swap the pivot (index 0) with the last element smaller than the pivot (which should be to the left which 0 is)
                Collections.swap(list, 0, leftIndex - 1);
                // the list is now sorted in a sublist smaller than the pivot, the pivot, a sublist bigger than the pivot.
                if (debug) {
                    System.out.printf("%s %s %s\n",
                            list.subList(0, rightIndex), pivot, list.subList(leftIndex, list.size()));
                }
                break;
            }
        }

        sort(list.subList(0, rightIndex), debug);
        sort(list.subList(leftIndex, list.size()), debug);

        if (debug) {
            System.out.println("Final state: " + list);
        }
    }
}
