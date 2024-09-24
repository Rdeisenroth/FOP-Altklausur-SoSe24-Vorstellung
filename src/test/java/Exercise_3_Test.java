import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_3_Test {
    @Test
    public void testRecursiveBar() {
        final var sol = new Exercise_3.Recursive();
        assertEquals(0, sol.bar(Util.toListItemList(), 0, 42));
        assertEquals(0, sol.bar(Util.toListItemList(2, 3, -5), 0, 42));
        assertEquals(42, sol.bar(Util.toListItemList(2, 3, -5, 6161), 0, 42));
        assertEquals(-42, sol.bar(Util.toListItemList(2, 3, -5, -6161), 0, 42));
    }

    @Test
    public void testRecursiveFoo() {
        final var sol = new Exercise_3.Recursive();
        Util.assertListsEqual(List.of(), sol.foo(Util.toListItemList(), Util.toListItemList()));
        Util.assertListsEqual(List.of(2, 3, 4, 5), sol.foo(Util.toListItemList(2, 3, 4, 5), Util.toListItemList(2, 3, 4, 5)));
        Util.assertListsEqual(List.of(-2, -3, -4, -5), sol.foo(Util.toListItemList(2, 3, 4, 5), Util.toListItemList(2, 3, 4, -50)));
        Util.assertListsEqual(List.of(2, 3, -4, -5), sol.foo(Util.toListItemList(2, 3, 4, 5), Util.toListItemList(2, 3, 4, -5)));
    }

    @Test
    public void testIterativeBar() {
        final var sol = new Exercise_3.Iterative();
        assertEquals(0, sol.bar(Util.toListItemList(), 0, 42));
        assertEquals(0, sol.bar(Util.toListItemList(2, 3, -5), 0, 42));
        assertEquals(42, sol.bar(Util.toListItemList(2, 3, -5, 6161), 0, 42));
        assertEquals(-42, sol.bar(Util.toListItemList(2, 3, -5, -6161), 0, 42));
    }

    @Test
    public void testIterativeFoo() {
        final var sol = new Exercise_3.Iterative();
        Util.assertListsEqual(List.of(), sol.foo(Util.toListItemList(), Util.toListItemList()));
        Util.assertListsEqual(List.of(2, 3, 4, 5), sol.foo(Util.toListItemList(2, 3, 4, 5), Util.toListItemList(2, 3, 4, 5)));
        Util.assertListsEqual(List.of(-2, -3, -4, -5), sol.foo(Util.toListItemList(2, 3, 4, 5), Util.toListItemList(2, 3, 4, -50)));
        Util.assertListsEqual(List.of(2, 3, -4, -5), sol.foo(Util.toListItemList(2, 3, 4, 5), Util.toListItemList(2, 3, 4, -5)));
    }

    @Test
    public void testWithIteratorBar() {
        final var sol = new Exercise_3.WithIterator();
        assertEquals(0, sol.bar(Collections.emptyIterator(), 0, 42));
        assertEquals(0, sol.bar(List.of(2, 3, -5).iterator(), 0, 42));
        assertEquals(42, sol.bar(List.of(2, 3, -5, 6161).iterator(), 0, 42));
        assertEquals(-42, sol.bar(List.of(2, 3, -5, -6161).iterator(), 0, 42));
    }

    @Test
    public void testWithIteratorFoo() {
        final var sol = new Exercise_3.WithIterator();
        Util.assertListsEqual(List.of(), sol.foo(List.of(), List.of()));
        Util.assertListsEqual(List.of(2, 3, 4, 5), sol.foo(List.of(2, 3, 4, 5), List.of(2, 3, 4, 5)));
        Util.assertListsEqual(List.of(-2, -3, -4, -5), sol.foo(List.of(2, 3, 4, 5), List.of(2, 3, 4, -50)));
        Util.assertListsEqual(List.of(2, 3, -4, -5), sol.foo(List.of(2, 3, 4, 5), List.of(2, 3, 4, -5)));
    }
}
