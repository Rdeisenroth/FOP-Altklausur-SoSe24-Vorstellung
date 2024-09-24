public class Exercise_5 {
    public class A {
        public static int[] foobar(int[] a, int[] b) {
            // calculate size
            int targetSize = 0;
            for (int i = 0; i < Math.min(a.length, b.length); i++) {
                if (Math.abs(a[i]) == Math.abs(b[i])) {
                    targetSize++;
                }
            }
            // fill array
            int[] result = new int[2 * targetSize];
            for (int i = 0, j = 0; i < Math.min(a.length, b.length); i++) {
                if (Math.abs(a[i]) == Math.abs(b[i])) {
                    result[j++] = -Math.abs(a[i]);
                    result[j++] = Math.abs(a[i]);
                }
            }
            return result;
        }
    }

    public class B {
        public static int foo(int[] a, int[] b, int index) {
            if (index >= Math.min(a.length, b.length)) {
                return 0;
            }
            return (Math.abs(a[index]) == Math.abs(b[index]) ? 0 : 1) + foo(a, b, index + 1);
        }

        public static int[] bar(int[] a, int[] b, int[] result, int indexInAAndB, int tindexInResult) {
            if (indexInAAndB >= Math.min(a.length, b.length)) {
                return result;
            }
            if (Math.abs(a[indexInAAndB]) == Math.abs(b[indexInAAndB])) {
                result[tindexInResult++] = -Math.abs(a[indexInAAndB]);
                result[tindexInResult++] = Math.abs(a[indexInAAndB]);
            }
            return bar(a, b, result, ++indexInAAndB, tindexInResult);
        }

        public static int[] foobar(int[] a, int[] b) {
            // calculate size
            int targetSize = 2 * foo(a, b, 0);
            // fill array
            int[] result = bar(a, b, new int[targetSize], 0, 0);
            return result;
        }
    }
}
