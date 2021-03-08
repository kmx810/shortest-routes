import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distance {

    ArrayList<Integer>[] routes;
    Graph g;

    public Distance() throws FileNotFoundException {

        g = new Graph();

    }

    public int[] getDistance(int n){
        int[] distance = new int[g.size()];
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        Stack<Integer> s = new Stack<>();
        s.push(n);

        boolean[] visited = new boolean[g.size()];
        visited[n] = true;

        int current;
        
        routes = new ArrayList[g.perfecturesList.size()];
        for(int i = 0; i < routes.length; i++){
            routes[i] = new ArrayList<>();
        }

        distance[n] = 0;

        while(!s.isEmpty()){
            current = s.pop();

            for(int i = 0; i < g.connections[current].length; i++){
                if(g.connections[current][i] == 1){ // checking for neighbours
                    if(distance[current] + 1 < distance[i]){
                        distance[i] = distance[current] + 1;

                        routes[i] = (ArrayList<Integer>) routes[current].clone();
                        routes[i].add(i); 
                    }
                }
            }

            for(int i = 0; i < g.connections[current].length; i++){
                if(!visited[i] && g.connections[current][i] == 1){


                    s.push(i);
                    visited[i] = true;

                }
            }
        }

        return distance;
    }

    public int getDistanceOfTwoPerfectures(int start, int end){

        int[] distanceArray = getDistance(start);
        return distanceArray[end];

    }

    public int getDistanceOfTwoPerfectures(String start, String end){

        return getDistanceOfTwoPerfectures(g.checkOrderNumber(start), g.checkOrderNumber(end));

    }

    public void printRoutes(int start){
        getDistance(start);
        
        for(int i = 0; i < routes.length; i++){
            System.out.print(g.getNameFromIndex(start));
            for(int j = 0; j < routes[i].size(); j++){
                System.out.print(" --> " + g.getNameFromIndex(routes[i].get(j)));
            }
            System.out.println();
        }
    }

    public void printRoutes(String start){
        printRoutes(g.checkOrderNumber(start));
    }

}
