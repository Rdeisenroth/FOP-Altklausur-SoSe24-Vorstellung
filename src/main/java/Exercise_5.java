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
public static int foo(int[] a, int[] b, int index){
    // ergebnislänge berechnen
    if(index >= Math.min(a.length, b.length)){
        return 0;
    }
    if(Math.abs(a[index])==Math.abs(b[index])){
        return 2 + foo(a,b,index + 1);
    }
    return foo(a,b,index + 1);
}
public static void bar(int[] a, int[] b, int[] result, int indexInAAndB, int indexInResult){
    // ergebnisarray füllen
    if(indexInAAndB >= Math.min(a.length, b.length)){
        return;
    }
    if(Math.abs(a[indexInAAndB])==Math.abs(b[indexInAAndB])){
        result[indexInResult] = - Math.abs(a[indexInAAndB]);
        indexInResult++;
        result[indexInResult] = Math.abs(a[indexInAAndB]);
        indexInResult++;
    }
    bar(a,b,result,indexInAAndB + 1, indexInResult);
}
public static int[] foobar(int[] a, int[] b){
    int[] result = new int[foo(a,b,0)];
    bar(a,b,result,0,0);
    return result;
}
    }
}
