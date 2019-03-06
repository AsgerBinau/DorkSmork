package Week1Checkers;
import java.util.Scanner;

public class Interface {
	
	public static String append(String[] strings) {
		String app = "";
		for(String s : strings) {
			if (app != "") 
				app = app + " ";
			app = app + s;
		}
		return app;
	}
	public static String[][] b = 
		{		{" ","1"," ","1"," ","1"," ","1"},
				{"1"," ","1"," ","1"," ","1"," "}, 
				{" ","1"," ","1"," ","1"," ","1"}, 
				{" "," "," "," "," "," "," "," "}, 
				{" "," "," "," "," "," "," "," "}, 
				{"2"," ","2"," ","2"," ","2"," "}, 
				{" ","2"," ","2"," ","2"," ","2"}, 
				{"2"," ","2"," ","2"," ","2"," "}
		};
	public static String Board(String[][] x) { return
			"   0 1 2 3 4 5 6 7   <- X axis\r\n" + 
			"  +---------------+\r\n" + 
			"0 |"+append(x[0])+"|\r\n" + 
			"1 |"+append(x[1])+"|\r\n" + 
			"2 |"+append(x[2])+"|\r\n" + 
			"3 |"+append(x[3])+"|\r\n" +  
			"4 |"+append(x[4])+"|\r\n" +  
			"5 |"+append(x[5])+"|\r\n" + 
			"6 |"+append(x[6])+"|\r\n" + 
			"7 |"+append(x[7])+"|\r\n" + 
			"  +---------------+\r\n" + 
			"   0 1 2 3 4 5 6 7";}
	
	
	public static int[] SelectPiece(String[][] b, int activePlayer,Scanner s) {
		boolean legalMove = false;
		int[] coordinates= {0,0};
		while (legalMove==false) {
			System.out.print("Coordinates of piece to move\n");
			System.out.print("Enter X:");
			coordinates[0] = Integer.parseInt(s.nextLine());
			System.out.print("Enter Y:");
			coordinates[1] = Integer.parseInt(s.nextLine());
			if    (coordinates[0]>=0 && coordinates[0]<=7 			//x bounds (protects from out of bounds)
				&& coordinates[1]>=0 && coordinates[1]<=7 			//y bounds (protects from out of bounds)
				&& b[coordinates[1]][coordinates[0]].contentEquals	//Player controlled piece
				(Integer.toString(activePlayer)))
					legalMove = true;
			else System.out.print("invalid coordinates, try again.\n\n"); 
		}
		return(coordinates);
	}
	public static int[] SelectTarget(String[][] b, int activePlayer, Scanner s,int oldX,int oldY) {
		boolean legalMove = false;
		int[] coordinates= {0,0};
		while (legalMove==false) {
			System.out.print("Coordinates to land in:\n");
			System.out.print("Enter X:");
			coordinates[0] = Integer.parseInt(s.nextLine());
			System.out.print("Enter Y:");
			coordinates[1] = Integer.parseInt(s.nextLine());
			if 	  (coordinates[0]>=0 && coordinates[0]<=7 				//x bounds (protects from out of bounds)
				&& coordinates[1]>=0 && coordinates[1]<=7 				//y bounds (protects from out of bounds)
				&& b[coordinates[1]][coordinates[0]].contentEquals(" ") //empty field
				&& ((oldY==activePlayer*2-3+coordinates[1]				//y move
				&& Math.abs(oldX-coordinates[0])==1)					//x move
				|| 														//Either move or attack
				(oldY==activePlayer*4-6+coordinates[1]					//y attack (double distance)
				&& Math.abs(oldX-coordinates[0])==2)					//x attack (double distance)
				&& b[(coordinates[1]+oldY)/2][(coordinates[0]+oldX)/2].contentEquals
					(Integer.toString(Math.abs(activePlayer-3)))		//Opponent controls piece halfway towards target
				))
				legalMove = true;								
			
			
			else System.out.print("invalid coordinates, try again.\n\n"); 
			
		}
		return(coordinates);
	}
	
	public static void main(String[] args) {
		boolean gameOver = false;
		int activePlayer = 1;
		int turn = 1;
		int newX=0; int newY=0; int oldX=0; int oldY=0;
		Scanner s = new Scanner(System.in);
		while (gameOver == false) {

			//Display
			System.out.println(Board(b) +
					"\nTurn: " + turn 
					+ "\nActive player: " + activePlayer);
			
			//Input Piece coordinates

			
			
			int[] Old = SelectPiece(b, activePlayer,s);
			oldX = Old[0];
			oldY = Old[1];

			int[] New = SelectTarget(b, activePlayer,s,oldX,oldY);
			newX = New[0];
			newY = New[1];
			
			//Executing the move
			b[oldY][oldX]=" "; //empty old field
			b[newY][newX]=Integer.toString(activePlayer); //put piece in new field
			if (Math.abs(oldY-newY)==2) b[(oldY+newY)/2][(oldX+newX)/2] =" "; //Remove piece jumped over

			//End phase
			if (activePlayer == 1) activePlayer = 2;
			else activePlayer = 1;
			turn++;
		}
		
		
	}
}
