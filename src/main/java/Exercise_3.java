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
            int sum = 0;
            for (ListItem<Integer> item = l2; item != null; item = item.next) {
                sum += item.key;
            }
            if (sum == 0) {
                return 0;
            } else if (sum > 0) {
                return v;
            } else {
                return -v;
            }
        }

        public ListItem<Integer> foo(ListItem<Integer> l1, ListItem<Integer> l2) {
            ListItem<Integer> head = null;
            ListItem<Integer> tail = head;
            ListItem<Integer> p1 = l1;
            ListItem<Integer> p2 = l2;
            while (p1 != null) {
                Integer newVal = 0;
                if (p2 != null) {
                    newVal = bar(p2, 0, p1.key);
                }
                ListItem<Integer> newItem = new ListItem<Integer>(newVal);
                if (head == null) {
                    head = newItem;
                    tail = newItem;
                } else {
                    tail.next = newItem;
                    tail = tail.next;
                }
                p1 = p1.next;
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
            return head;

        }
    }

    public static class WithIterator {
        public Integer bar(Iterator<Integer> l2, Integer acc, Integer v) {
            int sum = 0;
            while (l2.hasNext()) {
                sum += l2.next();
            }
            if (sum == 0) {
                return 0;
            } else if (sum > 0) {
                return v;
            } else {
                return -v;
            }
        }


        public List<Integer> foo(List<Integer> l1, List<Integer> l2) {
            List<Integer> newList = new LinkedList<>();

            Iterator<Integer> l1Iter = l1.iterator();

            int index = 0;
            while (l1Iter.hasNext()) {

                Integer nextL1Val = l1Iter.next();
                Integer newVal = 0;
                if (index < l2.size()) {
                    newVal = bar(l2.listIterator(index), 0, nextL1Val);
                }
                newList.add(newVal);

                index++;
            }
            return newList;

        }
    }
}
