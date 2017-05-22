import java.util.*;
import java.awt.Point;


public class CraftingMines{

	public static void main(String[] args){

		 Scanner sc = new Scanner(System.in);

		 int w = sc.nextInt();
		 int h = sc.nextInt();
		 int sX = sc.nextInt();
		 int sY = sc.nextInt();


		 char[][] mine;
		 mine = new char[w][h];

String line="";
		
		 for(int i = 0 ; i < h ; i++){

		 		line = sc.next();
				
				for(int j = 0 ; j < w ; j++){
		 		mine[j][i] = line.charAt(j);
					System.out.print(mine[j][i]);
				}
		 System.out.println();
		 }


 		

ArrayList< Point > toVist = new ArrayList< Point >();
ArrayList< Point > newPoints = new ArrayList< Point >();
ArrayList< Point > temps = new ArrayList< Point >();



Point steveStartPoint = new Point(sX,sY);
toVist.add(steveStartPoint);
mine[sX][sY] = 'V'; 


	

while( true)	{
	
	for(Point point : toVist){

		mine[point.x][point.y] = 'V'; 
			
			
	
			temps = neighbours(point, mine) ;

			for(Point x : temps ){
				newPoints.add(x);
			}	

		
	}


	
	toVist = newPoints;
}    


//System.out.println("No luck");



	}

public static ArrayList< Point > neighbours(Point point, char[][] mine){

ArrayList< Point > points = new ArrayList< Point >();




try{
	if(mine[(point.x)-1][point.y] == '*'){
		System.out.println("found");
	}
	
	if ( mine[(point.x)-1][point.y] != 'O' && mine[point.x-1][point.y] != 'V'){
	points.add(new Point( (point.x)-1,point.y) );
}
}
catch(ArrayIndexOutOfBoundsException e){}


try{
	if(mine[(point.x)][(point.y)-1] == '*'){
		System.out.println("found");
	}

	if( mine[point.x][(point.y)-1] != 'O' && mine[point.x][(point.y)-1] != 'V'){
	points.add(new Point( (point.x),(point.y)-1 ) );
}
}
catch(ArrayIndexOutOfBoundsException e){}


try{

	if(mine[(point.x)+1][point.y] == '*'){
		System.out.println("found");
	}

	if(mine[(point.x)+1][point.y] != 'O' && mine[(point.x)+1][point.y] != 'V'){
	points.add(new Point( (point.x)+1,point.y) );
}
}
catch(ArrayIndexOutOfBoundsException e){}


try{

	if(mine[(point.x)][(point.y)+1] == '*'){
		System.out.println("found");
	}
	if(mine[point.x][(point.y)+1] != 'O' && mine[point.x][(point.y)+1] != 'V'){
		points.add(  new Point( (point.x),(point.y)+1 )  );
   }
}
catch(ArrayIndexOutOfBoundsException e){}

return points;


}

}