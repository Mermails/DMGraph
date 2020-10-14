package graphe;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SO{
    public static void main(String...a)throws Exception{

List<String> fichiers = new ArrayList<String>(List.of("a280","berlin52","ch130","ch150","eil51","eil76","eil101","kroC100","pcb442","pr76","pr1002","pr2392"));

for(String fichier : fichiers){
        System.out.println(fichier);
        
    
File f = new File("C:\\Users\\alang\\Documents\\NetBeansProjects\\Graphe\\src\\graphe\\"+fichier+".tsp");
//System.out.println("ArrayList : " + fichiers); 

Scanner s = new Scanner(f);

int counts = 0;
String ligne = s.nextLine();
Pattern pDim = Pattern.compile("(.*)?DIMENSION(.*)?:.*");
while(!(pDim.matcher(ligne)).find()){
    ligne = s.nextLine();
}
System.out.println(ligne);
if(ligne.contains("DIMENSION: ")){
    System.out.println("ok");
    counts = Integer.parseInt(ligne.split("DIMENSION: ")[1]);//use 4th
}else{
    System.out.println("ko");
    counts = Integer.parseInt(ligne.split("DIMENSION : ")[1]);//use 4th
}
Pattern pDeb = Pattern.compile("(( )*)?1 [0-9a-zA-Z+]*((.?[0-9a-zA-Z]*)?|(.?[0-9a-zA-Z]*\\+.?[0-9a-zA-Z]*)?)? [0-9a-zA-Z]*((.?[0-9a-zA-Z]*)?|.?[0-9a-zA-Z]*\\+.?[0-9a-zA-Z]*)?(( )*)?");
while(!(pDeb.matcher(ligne)).find()){
    System.out.println(ligne);
    ligne = s.nextLine();
}
System.out.println(ligne);
System.out.println(counts+" : counts");




Coordinate[] xy = new Coordinate[counts];


int i = 0;
boolean estFini = false;
while(s.hasNextLine() && !estFini){ // picking exactly the required number of items.
            String line = s.nextLine();
            if(line.equals("EOF") || line.equals(" ")){
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

int largeur = i;
int longueur = i;
int[][] grapheComplet;
grapheComplet = new int[largeur][longueur];
Euclidien e = new Euclidien();

 for(int it = 0; it< 5; it++ ){
            for(int j = 0; j<5; j++){
                if(it==j){
                    grapheComplet[it][j] = 999999999;
                }else{
                    grapheComplet[it][j] = (int) e.Distance(xy[it].getX(), xy[it].getY(), xy[j].getX(), xy[j].getY());
                }
                System.out.printf("%12d", grapheComplet[it][j]); 
            }
            System.out.println();
        }

for( i = 0;i<xy.length-1;i++){
        //System.out.println("for index "+i+") "+xy[i] + " à : " + xy[i+1]);
        //System.out.println("Distance euclidienne avec +1 pour ["+ i + " à ["+ i +"] :  " + e.Distance(xy[i].getX(), xy[i].getY(), xy[i+1].getX(), xy[i+1].getY()));
    }
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