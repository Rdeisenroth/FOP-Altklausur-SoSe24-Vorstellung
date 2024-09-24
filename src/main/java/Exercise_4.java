import java.util.List;
import java.util.function.BiFunction;

public class Exercise_4 {
    public interface Foo {
        boolean apply(Integer x, Integer b);
    }

    public class MyFoo implements Foo {
        @Override
        public boolean apply(Integer x, Integer b) {
            return x > b;
        }
    }

    public interface Bar<T, U> {
        U apply(T t1, T t2);
    }

    public class MyBar implements Bar<Integer, Integer> {
        @Override
        public Integer apply(final Integer t1, final Integer t2) {
            return t1 + t2;
        }
    }

    // -- provided helper function -- //
    static <T> List<T> rest(List<T> l) {
        return l.subList(1, l.size());
    }
    // -- end helper function -- //

    public static Integer h(Integer acc, List<Integer> a, Integer b, Foo foo, Bar<Integer, Integer> bar) {
        if (a.isEmpty()) {
            return acc;
        } else if (foo.apply(a.get(0), b)) {
            return h(bar.apply(a.get(0), acc), rest(a), b, foo, bar);
        } else {
            return h(acc, rest(a), b, foo, bar);
        }
    }

    public static BiFunction<List<Integer>, Integer, Integer> foobar(Foo foo, Bar bar, Integer init) {
        return (a, b) -> h(init, a, b, foo, bar);
    }
}
