import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {

    public <T> List<T> interlace(List<T> list1, List<T> list2) {
        List<T> interlaced = new ArrayList<>();
        int minSize = Math.min(list1.size(), list2.size());

        for (int i = 0; i < minSize; i++) {
            interlaced.add(list1.get(i));
            interlaced.add(list2.get(i));
        }

        // Add remaining elements from the longer list
        if (list1.size() > list2.size()) {
            interlaced.addAll(list1.subList(minSize, list1.size()));
        } else if (list2.size() > list1.size()) {
            interlaced.addAll(list2.subList(minSize, list2.size()));
        }

        return interlaced;
    }

//    public class OccurrenceCounter {
        /**
         * Counts the occurrences of each item in a list.
         *
         * @param items The list of items to count
         * @param <T>   The type of items in the list
         * @return A map where each key is an item from the list and its value is the count of that item's occurrences
         */
        public static <T> Map<T, Integer> countOccurrences(List<T> items) {
            Map<T, Integer> occurrenceMap = new HashMap<>();
            for (T item : items) {
                occurrenceMap.put(item, occurrenceMap.getOrDefault(item, 0) + 1);
            }
            return occurrenceMap;
        }


//    }

}

