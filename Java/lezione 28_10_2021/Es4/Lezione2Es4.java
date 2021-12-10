
public class Lezione2Es4 {

	public static void main(String[] args) {
		
		int[] x = new int[10];		
		int[] y = new int[10];
		
		for(int i=0;i<10;i++) {
			x[i]=Integer.parseInt(args[i]);
			
			System.out.println("x["+i+"]: "+x[i]);
		}
		
		for(int i=0;i<10;i++) {
			y[i]=x[x.length-1-i];		//inversione vettori 
			
			System.out.println("Invertito>> y["+i+"]: "+y[i]);
		}
		
		
		
	
				

	}

}
