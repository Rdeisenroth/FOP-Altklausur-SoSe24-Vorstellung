import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise_5_Test {
    @Test
    public void testAFoobar() {
        assertArrayEquals(new int[0], Exercise_5.A.foobar(new int[0], new int[0]));
        assertArrayEquals(
            new int[]{-5, 5, -7, 7, -0, 0},
            Exercise_5.A.foobar(
                new int[]{1, 5, -7, 2, 0, -8},
                new int[]{2, -5, -7, -1, 0, 9, 1}
            )
        );
    }

    @Test
    public void testBFoo() {
        assertEquals(0, Exercise_5.B.foo(new int[0], new int[0], 0));
        assertEquals(
            3,
            Exercise_5.B.foo(
                new int[]{1, 5, -7, 2, 0, -8},
                new int[]{2, -5, -7, -1, 0, 9, 1},
                0
            )
        );
    }

//    @Test
//    public void testBBar() {
//        assertArrayEquals(new int[0], Exercise_5.B.bar(new int[0], new int[0], new int[0], 0, 0));
//        assertArrayEquals(
//            new int[]{-5, 5, -7, 7, -0, 0},
//            Exercise_5.B.bar(
//                new int[]{1, 5, -7, 2, 0, -8},
//                new int[]{2, -5, -7, -1, 0, 9, 1},
//                new int[6],
//                0,
//                0
//            )
//        );
//    }

    @Test
    public void testBFoobar() {
        assertArrayEquals(new int[0], Exercise_5.B.foobar(new int[0], new int[0]));
        assertArrayEquals(
            new int[]{-5, 5, -7, 7, -0, 0},
            Exercise_5.B.foobar(
                new int[]{1, 5, -7, 2, 0, -8},
                new int[]{2, -5, -7, -1, 0, 9, 1}
            )
        );
    }
}
