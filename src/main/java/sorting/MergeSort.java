package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent Velthuizen
 * Sort any list using merge sort
 */
public class MergeSort {
    public static <L extends Comparable<? super L>> void sort(List<L> list) {
        mergeSort(list, false);
    }

    public static <L extends Comparable<? super L>> void sort(List<L> list, boolean debug) {
        List<L> sorted = mergeSort(list, debug);

        if (debug) {
            System.out.println("Final state: " + sorted);
        }

        list.clear();
        list.addAll(sorted);
    }

    public static <L extends Comparable<? super L>> List<L> mergeSort(List<L> list, boolean debug) {
        if (list.size() <= 1) {
            return list;
        }

        List<L> list1 = mergeSort(list.subList(0, list.size() / 2), debug);
        List<L> list2 = mergeSort(list.subList(list.size() / 2, list.size()), debug);

        if (debug) {
            System.out.printf("State: %s %s\n", list1, list2);
        }
        return merge(list1, list2);
    }

    public static <L extends Comparable<? super L>> List<L> merge(List<L> list1, List<L> list2) {
        List<L> mergedList = new ArrayList<>(list1.size() + list2.size());
        int headOfList1 = 0;
        int headOfList2 = 0;

        while (headOfList1 < list1.size() && headOfList2 < list2.size()) {
            if (list1.get(headOfList1).compareTo(list2.get(headOfList2)) < 0) {
                mergedList.add(list1.get(headOfList1++));
            } else {
                mergedList.add(list2.get(headOfList2++));
            }
        }

        if (headOfList1 < list1.size()) {
            mergedList.addAll(list1.subList(headOfList1, list1.size()));
        } else if (headOfList2 < list2.size()) {
            mergedList.addAll(list2.subList(headOfList2, list2.size()));
        }

        return mergedList;
    }
}
