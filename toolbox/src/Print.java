import java.util.List;
import java.util.Map;

public class Print {

    // For Maps
    public static <K, V> void print(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // For Lists
    public static <T> void print(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    // For Arrays
    public static <T> void print(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }

    // With hashCodes
    // For Maps
    public static <K, V> void printWithHashCode(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getKey().hashCode() + ") = "
                    + entry.getValue() + " (" + entry.getValue().hashCode() + ")");
        }
    }

    // For Lists
    public static <T> void printWithHashCode(List<T> list) {
        for (T item : list) {
            System.out.println(item + " (" + item.hashCode() + ")");
        }
    }

    // For Arrays
    public static <T> void printWithHashCode(T[] array) {
        for (T item : array) {
            System.out.println(item + " (" + item.hashCode() + ")");
        }
    }
}

