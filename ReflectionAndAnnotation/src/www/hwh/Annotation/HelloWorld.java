package www.hwh.Annotation;

public class HelloWorld {

	public static void main(String[] args) {
		int sum=0;
		for(int i=1;i<=100;i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(fact(10L));
	}
	
	public static long fact(long n) {
		if(n==1) {
			return 1;
		}else {
			return n*fact(n-1);
		}
	}

}
