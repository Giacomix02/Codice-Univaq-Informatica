

public class Lezione2Es5 {

	public static void main(String[] args) {
		
		int x=0,y=0;
		int[] X = new int[51];
		int[] Y = new int[51];
		int[] Z = new int[51];
		
		
		for(int i=0;i<51;i++) {
			
			System.out.println("numeri cicli >>		x>>"+x+"  y>>"+y);

			Z[i]=x+y;
			
			System.out.println("somma >>		Z["+i+"] >> "+Z[i]);
			
			X[i]=x++;
			Y[i]=y++;
		}
		
	}

}
