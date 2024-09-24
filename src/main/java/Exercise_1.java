import java.awt.Container;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.HashSet;
import java.util.function.DoubleFunction;

public class Exercise_1 {
    @FunctionalInterface
    public interface A<C extends Container> {
        default <T extends Number> boolean fnc(HashSet<? super Number> ason, T t) {
            if (!ason.contains(t)) {
                ason.add(t);
                return false;
            }
            return true;
        }

        Integer apply(DoubleFunction<Integer> f, Double d);
    }

    public abstract class B<C extends Container> implements A<C>, ContainerListener {
        @Override
        public Integer apply(final DoubleFunction<Integer> f, final Double d) {
            return f.apply(d);
        }
    }

    public abstract class D<C extends Container> extends B<C> {
        private int id;

        @Override
        public void componentAdded(ContainerEvent e) {
            id = e.getID();
        }
    }
}
