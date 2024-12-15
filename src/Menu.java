import java.util.Scanner;

public class Menu {

    public static void startMenu() {
        boolean exit = false;
        Movie[] movies = new Movie[0];
        Scanner sc = new Scanner(System.in);


        while (!exit) {
            System.out.println("**************MENU**************\n" +
                    "Press 0 to exit\n" +
                    "Press 1 to input movies\n" +
                    "Press 2 to display movies and ratings\n" +
                    "Press 3 to input more movies\n" +
                    "Press 4 to find statistics\n" +
                    "Press 5 to search for a movie\n" +
                    "Press 6 to update movie ratings\n" +
                    "Press 7 to delete a movie\n" +
                    "Press 8 to sort movies");


            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    movies = new Movie[1];
                    InterfaceUtil.addMovie(movies);

                    break;

                case 2:
                    InterfaceUtil.display(movies);
                    break;

                case 3:
                    movies = InterfaceUtil.inputMoreMovies(movies);
                    break;

                case 4:
                    MathUtil.getAverage(movies);
                    MathUtil.findMaxAndMin(movies);

                    break;

                case 5:
                    InterfaceUtil.displayNames(movies);
                    InterfaceUtil.searchMovie(movies);

                    break;

                case 6:
                    InterfaceUtil.displayNames(movies);
                    InterfaceUtil.updateRating(movies);
                    break;

                case 7:
                    movies = InterfaceUtil.deleteMovie(movies);

                    break;


                case 8:
                    MathUtil.sortArray(movies);
                    InterfaceUtil.display(movies);
                    break;

                case 0:
                    System.out.println("Exiting");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid value");
                    break;

            }
        }


    }

}



