import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exercise_3 {

    // -- definitions given in exercise -- //
    public static class ListItem<T> {
        public T key;
        public ListItem<T> next;

        public ListItem() {
        }

        public ListItem(T t) {
            key = t;
        }
    }
    // -- begin exercise -- //
    public static class Recursive {
        public Integer bar(ListItem<Integer> l2, Integer acc, Integer v) {
            if (l2 == null) {
                return acc == 0 ? 0 : acc > 0 ? v : -v;
            } else {
                return bar(l2.next, acc + l2.key, v);
            }
        }

        public ListItem<Integer> foo(ListItem<Integer> l1, ListItem<Integer> l2) {
            if (l1 == null) {
                return null;
            } else if (l2 == null) {
                final ListItem<Integer> newItem = new ListItem<>(0);
                newItem.next = foo(l1.next, l2);
                return newItem;
            } else {
                final ListItem<Integer> newItem = new ListItem<>(bar(l2, 0, l1.key));
                newItem.next = foo(l1.next, l2.next);
                return newItem;
            }
        }
    }

    public static class Iterative {
        public Integer bar(ListItem<Integer> l2, Integer acc, Integer v) {
            for (ListItem<Integer> item = l2; l2 != null; l2 = l2.next) {
                acc += l2.key;
            }
            return acc == 0 ? 0 : acc > 0 ? v : -v;
        }

        public ListItem<Integer> foo(ListItem<Integer> l1, ListItem<Integer> l2) {
            ListItem<Integer> newHead = null;
            for (
                ListItem<Integer> p1 = l1, p2 = l2, tail = newHead;
                p1 != null;
                p1 = p1.next, p2 = p2 == null ? null : p2.next
            ) {
                Integer value = bar(p2, 0, p1.key);
                ListItem<Integer> newItem = new ListItem<>(value);
                if (tail == null) {
                    newHead = tail = newItem;
                    continue;
                }
                tail.next = newItem;
                tail = tail.next;
            }
            return newHead;
        }
    }

    public static class WithIterator {
        public Integer bar(Iterator<Integer> l2, Integer acc, Integer v) {
            while (l2.hasNext()) {
                acc += l2.next();
            }
            return acc == 0 ? 0 : acc > 0 ? v : -v;
        }

        public List<Integer> foo(List<Integer> l1, List<Integer> l2) {
            List<Integer> result = new LinkedList<>();
            int index = 0;
            for (
                Iterator<Integer> p1 = l1.iterator();
                p1.hasNext();
                index++
            ) {
                result.add(bar(l2.listIterator(index), 0, p1.next()));
            }
            return result;
        }
    }
}
