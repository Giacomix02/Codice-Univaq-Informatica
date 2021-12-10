
public class Lezione2Es3 {

	public static void main(String[] args) {
		
		int x=0,y=0;
		 /*
		for(x=0;x<=10;x++) {
			for(y=0;y<=50;y++)
			{
				System.out.println("with for >>  x: "+ x + " y:"+y);
			}
		}
		*/
		
		x=0;
		y=0;
		
		while(x<= 10) {
			y=0;
			while(y<=50) {
				System.out.println("with while >>  x: "+ x + " y:"+y);
				y++;
			}
			
			x++;
		}
		
	}

}
