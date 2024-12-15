import java.util.Scanner;

public  class InterfaceUtil {
    static Scanner sc=new Scanner(System.in);
    static boolean found = false;

    public static void display(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] != null) {
                System.out.println(" Movie "+(i+1) + ": "  + movies[i]);
            } else
                System.out.println("Not found data");
        }
    }

    public static void displayNames(Movie[] movies){
        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
    }

    public static void addMovie(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Enter " + (i+1) + " movie name: ");
            String name = sc.nextLine();

            System.out.println("Enter " + (i+1) + " movie rating: ");
            double rating = sc.nextDouble();
            sc.nextLine();

            movies[i] = new Movie(name, rating);
        }
    }

    public static Movie[] inputMoreMovies(Movie[] movies) {
        System.out.println("How many additional movies you want to input: ");
        int number = sc.nextInt();
        sc.nextLine();

        Movie[] movies1 = new Movie[movies.length + number];
        System.arraycopy(movies, 0, movies1, 0, movies.length);

        for (int i = movies.length; i < movies1.length; i++) {
            System.out.println("Enter " + (i + 1) + " movie name: ");
            String name = sc.nextLine();

            System.out.println("Enter " + (i + 1) + " movie rating: ");
            double rating = sc.nextDouble();
            sc.nextLine();

            movies1[i] = new Movie(name, rating);
        }

        return movies1;
    }

    public static void searchMovie(Movie[] movies){
        System.out.println("Enter a movie name: ");
        String movieName = sc.nextLine();

        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().equalsIgnoreCase(movieName.toLowerCase())) {
                System.out.println("Rating of this movie is: " + movie.getRating());
                found=true;
                break;
            }
        }

        if(!found){
            System.out.println("Movie not found");
        }
    }

    public static void updateRating(Movie[] movies){
        System.out.println("Enter a movie name you want to change the rating of: ");
        String movieName = sc.nextLine();

        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().equals(movieName.toLowerCase())) {
                found=true;
                System.out.println("Update rating: ");
                double newRating = sc.nextDouble();
                sc.nextLine();
                movie.setRating(newRating);
                break;

            }
        }
        if (!found) {
            System.out.println("Movie not found");
        }

    }

    public static Movie[] deleteMovie(Movie[] movies){
        InterfaceUtil.displayNames(movies);

        System.out.println("Enter the name you want to delete: ");
        String deletedName = sc.nextLine();

        int deleteIndex = -1;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getName().toLowerCase().equals(deletedName.toLowerCase())) {
                deleteIndex = i;
                break;
            }
        }

        Movie[] movies2 = new Movie[movies.length - 1];

        if (deleteIndex == -1) {
            System.out.println("Movie not found");
        } else {

            System.arraycopy(movies, 0, movies2, 0, deleteIndex);
            System.arraycopy(movies, deleteIndex + 1, movies2, deleteIndex, movies.length - deleteIndex - 1);

            System.out.println("Movie is deleted succesfully!\n");
        }

        return movies2;
    }

}
