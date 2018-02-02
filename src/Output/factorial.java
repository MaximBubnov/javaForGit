package Output;

public class factorial {
    public static void main(String[] args) {
        factorial fac = new factorial();
        System.out.println(fac.factorial(3));
    }

    public int factorial(int n) {
        if(n==0) return 1;
        return n * factorial(n - 1);
    }
}
