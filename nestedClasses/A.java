package nestedClasses;

public class A {

    private final int x = 0;
    private static final int y = 2;

    public class B {

        private int x = 1;
        public void foo(int x, int y) {
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(A.this.x);
            System.out.println(y);
            System.out.println(A.y);
        }

    }

    public static class C {

        public static int x = 1;

        public void foo(int x) {
            System.out.println(x);
            System.out.println(A.y);
        }
    }

}
