//import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static void main(String[] args) throws IOException {
        //There is a lot of input so we use BufferedReader to read. Scanner would take too long!
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(sc.readLine());
            if (n==0) return;
            //Create our array of points.
            Point2D[] arr = new Point2D[n];
            for (int i = 0; i < n; i++) {
                //Read each line, split the input at the space and create a new Point2D for each point.
                String[] split = sc.readLine().split(" ");
                arr[i] = new Point2D(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            }
            //We want to start by pre-sorting the points by their X-Coordinate
            Comparator<Point2D> ComparatorByX = new Comparator<Point2D>() {
                @Override
                public int compare(Point2D o1, Point2D o2) {
                    return Double.compare(o1.getX(), o2.getX());
                }
            };
            Arrays.sort(arr, ComparatorByX);

            //Find the closest pair.
            Point2D[] min = getClosestPair(arr);

            //Output the points. Don't worry if the output has a few extra zeroes.
            System.out.printf("%f %f %f %f \n",min[0].getX(),min[0].getY(),min[1].getX(),min[1].getY());

        }
    }

    //TODO: Should return an array of size 2 containing the closest 2 points in arr.
    private static Point2D[] getClosestPair(Point2D[] arr) {

int N = arr.length;


    
       Point2D[] pointsByX = new Point2D[N];
        
        for (int i = 0; i < N; i++)
            pointsByX[i] = arr[i];
        
        Arrays.sort(pointsByX, Point2D.X_ORDER);


         Point2D[] pointsByY = new Point2D[N];
        
        for (int i = 0; i < N; i++)
            pointsByY[i] = arr[i];
        
        Arrays.sort(pointsByY, Point2D.Y_ORDER);


//for(Point2D point : pointsByY)
    //System.out.println(point.toString());
      
       if(N == 2){
        Point2D[] result = new Point2D[2];
        result[0] = arr[0];
        result[1] = arr[1];
        return result; 

       }


       else if(N == 3){
        Point2D[] result = new Point2D[2];
       
       
        double distance1 = arr[0].distanceTo(arr[1]);
        double distance2 = arr[0].distanceTo(arr[2]);
        double distance3 = arr[1].distanceTo(arr[2]);

        if( (distance1 < distance2) && (distance1 < distance3) ){
          
          result[0] = arr[0];
          result[1] = arr[1];
          return result ;

        }

         if( (distance2 < distance1) && (distance2 < distance3) ){
          
          result[0] = arr[0];
          result[1] = arr[2];
          return result ;

        }

          if( (distance3 < distance1) && (distance3 < distance2) ){
          
          result[0] = arr[1];
          result[1] = arr[2];
          return result ;

        }

            
       
       }
  


Point2D[] pL = new Point2D[(int)Math.ceil(N/2)];
Point2D[] pR = new Point2D[(int)Math.floor(N/2)];
Point2D[] qL = new Point2D[(int)Math.ceil(N/2)];
Point2D[] qR = new Point2D[(int)Math.floor(N/2)];  

pL = Arrays.copyOfRange(pointsByX, 0, (int)Math.ceil(N/2));
qL = Arrays.copyOfRange(pointsByY, 0, (int)Math.ceil(N/2)) ; 

pR = Arrays.copyOfRange(pointsByX, (int)Math.floor(N/2), N);     
qR = Arrays.copyOfRange(pointsByY, (int)Math.floor(N/2), N);   


Point2D[] pair1 = getClosestPair(pL);
Point2D[] pair2 = getClosestPair(pR);

Point2D[] closerPair; 
if ( pair1[0].distanceSquaredTo(pair1[1]) <= pair2[0].distanceSquaredTo(pair2[1]) )
    closerPair = pair1;
else
    closerPair = pair2;

Double mline = pointsByX[(int)Math.ceil(N/2)-1].getX();

Point2D[] s = new Point2D[N];
int num = 0;
for(Point2D point : pointsByY){

    if (Math.abs(point.getX() - mline) < closerPair[0].distanceTo(closerPair[1]) ) {
            s[num] = point;
            num++;

    }

}

double dminSq = closerPair[0].distanceSquaredTo(closerPair[1]);
int  k = 0;
for(int i = 0 ; i < num-2 ; i++){
    k = i + 1;

        while( (k <= num-1) && Math.pow(s[k].getY() - s[i].getY(),2) <  dminSq){


    
            if( Math.pow( (s[k].getX() - s[i].getX()),2) + Math.pow( s[k].getY() - s[i].getY() , 2) <  dminSq){
                closerPair[1] = s[k];
                closerPair[0] = s[i];
                dminSq =  s[k].distanceSquaredTo(s[i]);
            }
                k = k+1; 
        }

}



return closerPair;
    


    }







}