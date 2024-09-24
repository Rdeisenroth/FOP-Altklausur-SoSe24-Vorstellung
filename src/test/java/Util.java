import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Util {
    /**
     * Converts a Java-List to a ListItem-list
     *
     * @param lst the Java List to convert
     * @param <T> The type of the elements
     * @return the resulting ListItem-list
     */
    public static <T> Exercise_3.ListItem<T> toListItemList(final List<T> lst) {
        Exercise_3.ListItem<T> head = null, tail = head;
        for (final T item : lst) {
            final var newItem = new Exercise_3.ListItem<>(item);
            if (head == null) {
                head = tail = newItem;
                continue;
            }
            tail.next = newItem;
            tail = tail.next;
        }
        return head;
    }

    /**
     * Converts a Java-Array to a ListItem-list
     *
     * @param items the Java Array to convert
     * @param <T>   The type of the elements
     * @return the resulting ListItem-list
     */
    @SafeVarargs
    public static <T> Exercise_3.ListItem<T> toListItemList(final T... items) {
        return toListItemList(Arrays.asList(items));
    }

    /**
     * Converts a ListItem-list to a Java-List
     *
     * @param lst the ListItem-list to convert
     * @param <T> The type of the elements
     * @return the resulting Java-List
     */
    public static <T> List<T> toList(final Exercise_3.ListItem<T> lst) {
        final var result = new ArrayList<T>();
        for (var item = lst; item != null; item = item.next) {
            result.add(item.key);
        }
        return result;
    }

    /**
     * Asserts that two lists are equal
     *
     * @param l1  the first list
     * @param l2  the second list
     * @param <T> the type of the elements
     */
    public static <T> void assertListsEqual(final List<T> l1, final List<T> l2) {
        assertEquals(l1, l2);
    }

    /**
     * Asserts that a ListItem-list and a Java-List are equal
     *
     * @param l1  the ListItem-list
     * @param l2  the Java-List
     * @param <T> the type of the elements
     */
    public static <T> void assertListsEqual(final Exercise_3.ListItem<T> l1, final List<T> l2) {
        assertListsEqual(toList(l1), l2);
    }

    /**
     * Assert that a Java-List and a ListItem-list are equal
     *
     * @param l1  the Java-List
     * @param l2  the ListItem-list
     * @param <T> the type of the elements
     */
    public static <T> void assertListsEqual(final List<T> l1, final Exercise_3.ListItem<T> l2) {
        assertListsEqual(l1, toList(l2));
    }

    /**
     * Assert that two ListItem-lists are equal
     *
     * @param l1  the first ListItem-list
     * @param l2  the second ListItem-list
     * @param <T> the type of the elements
     */
    public static <T> void assertListsEqual(final Exercise_3.ListItem<T> l1, final Exercise_3.ListItem<T> l2) {
        assertListsEqual(toList(l1), toList(l2));
    }
}
