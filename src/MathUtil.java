import java.text.DecimalFormat;

public class MathUtil {

    public static void getAverage(Movie[] movies){
        double sum = 0;
        for (Movie movie : movies) {
            sum += movie.getRating();//first
        }
        double averageSum = sum / movies.length;
        DecimalFormat df = new DecimalFormat("#.#");
        String average=df.format(averageSum);
        System.out.println("The average rating of all movies: " + average);
    }


    public static void findMaxAndMin(Movie[] movies){
        double max = movies[0].getRating();
        String maxName = movies[0].getName();
        double min = movies[0].getRating();
        String minName = movies[0].getName();
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getRating() > max) {
                max = movies[i].getRating();
                maxName = movies[i].getName();
            } else if (movies[i].getRating() < min) {
                min = movies[i].getRating();
                minName = movies[i].getName();
            }
        }
        System.out.println("The movie with the maximum rating: " + maxName);
        System.out.println("The movie with the minimum rating: " + minName);
    }

    public static void sortArray(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < movies.length; j++) {
                if (movies[j].getRating() < movies[minIndex].getRating()) {
                    minIndex = j;
                }
            }

            Movie temp = movies[minIndex];
            movies[minIndex] = movies[i];
            movies[i] = temp;
        }
    }


}
