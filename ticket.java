package ekso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class ticket 
{
private static String departure;
    private static String arriaval;
    private static List<Train> trains;
    private static  List<Solution> solutions;
public static void main(String args[] ) throws Exception 
{
    Scanner sc = new Scanner(System.in);
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        String str[] = red.readLine().split(" ");
        departure = str[0];
        arriaval = str[1];
 
        trains = new ArrayList<>();
        solutions = new LinkedList<>();
 
        String strr;
        int i=0;
        while ((strr = red.readLine()) != null) {
            if (strr.length() > 0) {
                trains.add(new Train(strr));
                
            }
            else
            	break;
        }
 
        Hashtable<String, Boolean> visited = new Hashtable<>();
        calculateFlights(departure, arriaval, visited, 0, departure);
 
        if (solutions.size() > 0) {
            Collections.sort(solutions);
            for (Solution s: solutions) {
                System.out.println(s.path + " " + s.cost);
            }
        } else {
            System.out.println("No Trains");
        }
    }
    
    
    static void calculateFlights(String departure, String arriaval, Hashtable<String, Boolean> visited, int cost, String path) {
        if (departure == arriaval || (visited.containsKey(departure) && visited.get(departure) == true))
            return;
 
        boolean toTrue = false;
        for (Train f: trains) {
            if (f.departure.compareTo(departure) == 0) {
                Hashtable<String, Boolean> newVisited = new Hashtable<>(visited);
                if (!newVisited.containsKey(departure)) newVisited.put(departure, true);
                toTrue = true;
 
                StringBuilder tmpPath = new StringBuilder(path + " " + f.arriaval);
                int tmpCost = f.cost + cost;
                if (f.arriaval.compareTo(arriaval) == 0) {
                    solutions.add(new Solution(tmpPath.toString(), tmpCost));
                }
                calculateFlights(f.arriaval, arriaval, newVisited, tmpCost, tmpPath.toString());
            }
        }
        if (toTrue) {
                if (! visited.containsKey(departure)) visited.put(departure, true);
        }
    } // end of calculateFlights()
}
 
class Solution implements  Comparable<Solution>{
    String path;
    int cost;
 
    Solution(String path, int cost) {
        this.path = path;
        this.cost = cost;
    }
 
    @Override
    public String toString() {
        return this.path + " " + this.cost;
    }
 
    @Override
    public int compareTo(Solution o) {
        if (cost > o.cost) return 1;
        else if (cost < o.cost) return -1;
        else {
            int c1 = path.split(" ").length;
            int c2 = o.path.split(" ").length;
            if (c1 > c2) return 1;
            else if (c1 < c2) return -1;
            else return path.compareTo(o.path)*-1;
        }
    }
}
 
 
final class Train {
    String departure;
    String arriaval;
    int cost;
 
    Train(String s) {
        String ar[] = s.split(" ");
        this.departure = ar[0];
        this.arriaval = ar[1];
        this.cost = Integer.parseInt(ar[2]);
    }
 
    @Override
    public String toString() {
        return "[" + this.departure + " " + this.arriaval + " " + this.cost +"]";
   
}
}
/*
pune mum
pune bhos 2000
bhos mum 3000
pune ravet 1000
ravet mum 1000
pune mum 500
*/