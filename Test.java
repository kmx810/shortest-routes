import java.io.FileNotFoundException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph();
        Distance d = new Distance();

        g.printPerfecturesList();

        System.out.println(d.getDistanceOfTwoPerfectures("Tokyo", "Tokyo"));
        // System.out.println(Arrays.toString(d.getDistance(0)));
        // System.out.println(Arrays.toString(d.getDistance(30)));
        

    }
}
