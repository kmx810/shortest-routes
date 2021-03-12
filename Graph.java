import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    ArrayList<String> perfecturesList = new ArrayList<>();
    int[][] connections;

    public Graph() throws FileNotFoundException {
        
        File f = new File("Perfectures.txt");
        Scanner s = new Scanner(f);
        String[] parts;

        while(s.hasNextLine()){
            parts = s.nextLine().split(" ");

            if(!perfecturesList.contains(parts[0])){
                perfecturesList.add(parts[0]);
            }
            if(!perfecturesList.contains(parts[1])){
                perfecturesList.add(parts[1]);
            }
        }
        s.close();

        connections = new int[perfecturesList.size()][perfecturesList.size()];

        for(int i = 0; i < perfecturesList.size(); i++){
            for(int j = 0; j <perfecturesList.size(); j++){
                connections[i][j] = 0;
            }
        }

        s = new Scanner(f);

        while(s.hasNextLine()){
            parts = s.nextLine().split(" ");

            connections[checkOrderNumber(parts[0])][checkOrderNumber(parts[1])] = 1;
            connections[checkOrderNumber(parts[1])][checkOrderNumber(parts[0])] = 1;

        }
        s.close();
    }

    public int checkOrderNumber(String text){
        int rv = perfecturesList.indexOf(text);
        if(rv >= 0){
            return rv;
        }
        throw new IllegalArgumentException("There is no such prefecture!");
    }

    public String getNameFromIndex(int n){

        return perfecturesList.get(n);

    }

    public void printPerfecturesList(){
        for(int i = 0; i < perfecturesList.size(); i++){
            System.out.println(i + " --> " + perfecturesList.get(i));
        }
    }

    public int size(){
        return perfecturesList.size();
    }
    
    public void printPerfectures(){
        System.out.println();
    }

    public String toString(){
        String rv= "";
        for(int i = 0; i < perfecturesList.size(); i++){
            for(int j = 0; j < perfecturesList.size(); j++){
                rv += connections[i][j] + " ";
            }
            rv += "\n";
        }
        return rv;
    }
    

}