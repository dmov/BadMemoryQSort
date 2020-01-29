import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    private static List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        final int pivot = list.get(list.size() / 2);

        final List<Integer> leftList = list.stream()
                                           .filter(e -> e < pivot)
                                           .collect(toList());

        final List<Integer> middleList = list.stream()
                                             .filter(e -> e == pivot)
                                             .collect(toList());

        final List<Integer> rightList = list.stream()
                                            .filter(e -> e > pivot)
                                            .collect(toList());

        return Stream.of(quickSort(leftList), middleList, quickSort(rightList))
                     .flatMap(Collection::stream)
                     .collect(toList());
    }

    public static void main(String[] args) {
        final List<Integer> unsortedList = Arrays.asList(5, 6, 3, 1, 2, 4, -1, 7, 5, -8, 44, 3, 25, 4, 5, 1, 3, 6, -5);
        System.out.println(unsortedList);

        System.out.println(quickSort(unsortedList));
    }
}
