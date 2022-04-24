
public class BezoTest {

	public static void main(String[] args) {
		us(120,150);
		us(150,120);

	}

	public static void us (int a, int b) {
		int r0 = a;
		int r1 = b;
		int s0 = 1;	//sa+tb = r0
		int t0 = 0;
		int s1 = 0;	//sa+tb = r1
		int t1 = 1;
		int temp = 0;
		int q = 0;
		
		while(r1>0) {
			q = r1/r0;
			temp = r0;
			r0 = r1;
			r1 = temp - r1*q;
			temp = s0;
			s0=s1;
			s1=temp-s1*q;
			temp=t0;
			t0=t1;
			t1=temp-t1*q;
		}
		System.out.printf("(%d)*(%d)+(%d)*(%d)=(%d),(%d)\n",a,s0,b, t0, r0,a*s0+b*t0);
		System.out.printf("(%d)*(%d)+(%d)*(%d)=(%d),(%d)\n",a,s1,b, t1, r0,a*s1+b*t1);
		
	}
}
