package math;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        int half = n / 2;
        double v = myPow(x, half);
        return v * v * myPow(x, n - half - half);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow p = new Pow();
		System.out.println(p.myPow(2, 5));
	}

}
