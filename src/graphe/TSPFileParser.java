import java.util.*;
import java.io.*;

class SO{
    public static void main(String...a)throws Exception{
        System.out.println("Start");


//Read thing
File f = new File("C:\\Users\\alang\\Documents\\NetBeansProjects\\Graphe\\src\\graphe\\a280.tsp");

Scanner s = new Scanner(f);

int counts = 0;

s.nextLine();//skip 1
s.nextLine();//skip 2
s.nextLine();//skip 3
counts = Integer.parseInt(s.nextLine().split(": ")[1]);//use 4th
s.nextLine();//skip 5
s.nextLine();//skip 6
System.out.println(counts+" : counts");




Coordinate[] xy = new Coordinate[counts];


int i = 0;
boolean estFini = false;
while(!estFini){ // picking exactly the required number of items.
    
            String line = s.nextLine();
            if(line.equals("EOF")){
              estFini = true;
            }else{
                 String[] vals = line.split("[ ]{1,}");

            
            double x = Double.parseDouble(vals[1]);
            //System.out.println("x[" +i+"] : " + x);
            double y = Double.parseDouble(vals[2]);
            //System.out.println("y[" +i+"] : " + y);


            Coordinate c =  new Coordinate(x,y);
          //System.out.println(i + " : " +c);
            xy[i++] = c;
            }
           
        }

Euclidien e = new Euclidien();
for( i = 0;i<xy.length-1;i++){
        System.out.println("for index "+i+") "+xy[i] + " à : " + xy[i+1]);
        System.out.println("Distance euclidienne avec +1 pour ["+ i + " à ["+ i +"] :  " + e.Distance(xy[i].getX(), xy[i].getY(), xy[i+1].getX(), xy[i+1].getY()));
    }
}
}
 class Coordinate {
    double x;
    double y;
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "Coord:: "+x+" , "+y;
    }
    
    public double getX(){
        return this.x;
    }
    
      public double getY(){
        return this.y;
    }
    
    
    
     
}

class Euclidien{
    double sqr(double a) {
        return a*a;
    }
    double Distance(double x1, double y1, double x2, double y2) {
        return Math.round(Math.sqrt(sqr(y2 - y1) + sqr(x2 - x1)));//arondie à l'entier le plus proche 
    } 
}