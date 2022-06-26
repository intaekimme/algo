
public class CTMath {
	public static void main(String[] args) {
//		for (int i = 100; i < 1000; i++) {
//			System.out.println(i+" "+isPrime(i));
//		}
		
		pirnt(126);
		
	}

	public static void pirnt(int n) { // 약수m
		int i=2;
		while(n/i!=0) {
			if(n%i==0) {
				System.out.print(i + " x ");
				n/=i;
			}else {
				i++;
			}
		}
	}

	
	private static boolean isPrime(int n) {	// 유클리드 호제법
		boolean isP = true;
		for (int i = 2; i <=(int)(Math.sqrt(n))  ; i++) {
			if(n%i==0) {
				isP=false;
				break;
			}
		}
		
		return isP;
	}
	
	private static boolean isPrime2(int n) {
		boolean isP = true;
		for (int i = 2; i <=(int)(Math.sqrt(n))  ; i++) {
			if(n%i==0) {
				isP=false;
				break;
			}
		}
		
		return isP;
	}
	
	
}
