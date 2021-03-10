import java.io.FileNotFoundException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph();
        Distance d = new Distance();

        g.printPerfecturesList();

        d.printRoutes("Kochi");

        // System.out.println(d.getDistanceOfTwoPerfectures("Tokyo", "Nara"));
        // System.out.println(Arrays.toString(d.getDistance(0)));
        // System.out.println(Arrays.toString(d.getDistance(30)));
        

    }
}
