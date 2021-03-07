import java.io.FileNotFoundException;

public class Distance {

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

        distance[n] = 0;

        while(!s.isEmpty()){
            current = s.pop();

            for(int i = 0; i < g.connections[current].length; i++){
                if(g.connections[current][i] == 1){
                    if(distance[current] + 1 < distance[i]){
                        distance[i] = distance[current] + 1;
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

}
