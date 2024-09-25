import java.util.List;
import java.util.Optional;

public class Exercise_2 {
    public static class Exc1 extends Exception {
    }

    public static class Exc2 extends Exc1 {
        public Exc2(int a) {}
    }

    public static class Exc3 extends Exc2 {
        public Exc3(List<Integer> lst) {
            super((lst == null || lst.isEmpty()) ? 0 : lst.get(0));
        }
    }

    public static class X {
        public static int m(List<Integer> lst, Optional<Integer> i) throws Exc1{
            if(lst == null){
                throw new Exc1();
            }

            if(i == null || i.isEmpty()) {
                throw new Exc2(1);
            }

            int iVal = i.get();
            if(iVal < 0) {
                throw new Exc3(lst);
            }
            return iVal;
        }
    }

    public class X2 {
        public int m2(List<Integer> lst) throws Exc3 {
            try{
                return X.m(lst,Optional.of(1));
            }
            catch(Exc3 e3){
                return -1;
            }
            catch(Exc1 e1){
                throw new Exc3(lst);
            }
        }
    }
}
