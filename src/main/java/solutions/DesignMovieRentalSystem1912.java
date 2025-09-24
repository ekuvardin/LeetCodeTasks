package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/*
You have a movie renting company consisting of n shops. You want to implement a renting system that supports
 searching for, booking, and returning movies. The system should also support generating a report of the currently rented movies.

Each movie is given as a 2D integer array entries where entries[i] = [shopi, moviei, pricei]
 indicates that there is a copy of movie moviei at shop shopi with a rental price of pricei. Each shop carries at most one copy of a movie moviei.

The system should support the following functions:

    Search: Finds the cheapest 5 shops that have an unrented copy of a given movie. The shops should be sorted by price in ascending order, and in case of a tie, the one with the smaller shopi should appear first. If there are less than 5 matching shops, then all of them should be returned. If no shop has an unrented copy, then an empty list should be returned.
    Rent: Rents an unrented copy of a given movie from a given shop.
    Drop: Drops off a previously rented copy of a given movie at a given shop.
    Report:
    Returns the cheapest 5 rented movies (possibly of the same movie ID) as a 2D list res where
     res[j] = [shopj, moviej] describes that the jth cheapest rented movie moviej was rented from the shop shopj.
     The movies in res should be sorted by price in ascending order, and in case of a tie,
      the one with the smaller shopj should appear first, and if there is still tie,
      the one with the smaller moviej should appear first. I
      f there are fewer than 5 rented movies, then all of them should be returned.
      If no movies are currently being rented, then an empty list should be returned.

Implement the MovieRentingSystem class:

    MovieRentingSystem(int n, int[][] entries) Initializes the MovieRentingSystem object with n shops and the movies in entries.
    List<Integer> search(int movie) Returns a list of shops that have an unrented copy of the given movie as described above.
    void rent(int shop, int movie) Rents the given movie from the given shop.
    void drop(int shop, int movie) Drops off a previously rented movie at the given shop.
    List<List<Integer>> report() Returns a list of cheapest rented movies as described above.

Note: The test cases will be generated such that rent will only be called if the shop has an unrented copy of the movie, and drop will only be called if the shop had previously rented out the movie.



Example 1:

Input
["MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
[[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
Output
[null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]

Explanation
MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]);
movieRentingSystem.search(1);  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
movieRentingSystem.report();   // return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
movieRentingSystem.search(2);  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.



Constraints:

    1 <= n <= 3 * 105
    1 <= entries.length <= 105
    0 <= shopi < n
    1 <= moviei, pricei <= 104
    Each shop carries at most one copy of a movie moviei.
    At most 105 calls in total will be made to search, rent, drop and report.


 */
public class DesignMovieRentalSystem1912 {
    final Map<Integer, Map<Integer, Movie>> shopToMovieIdToMovie;
    final Map<Integer, TreeSet<Movie>> cheapestMovieToShop;
    final TreeSet<Movie> cheapestRentedMovie;

    public DesignMovieRentalSystem1912(int n, int[][] entries) {
        shopToMovieIdToMovie = new HashMap<>();
        cheapestMovieToShop = new HashMap<>();

        cheapestRentedMovie = new TreeSet<>((o1, o2) -> {
            if (o1.price == o2.price) {
                if (o1.shop == o2.shop) {
                    return Integer.compare(o1.movie, o2.movie);
                }
                return Integer.compare(o1.shop, o2.shop);
            }
            return Integer.compare(o1.price, o2.price);
        });

        //  [shopi, moviei, pricei]
        for (int[] entry : entries) {
            Map<Integer, Movie> temp1 = shopToMovieIdToMovie.getOrDefault(entry[0], new HashMap<>());
            if (temp1.isEmpty()) {
                shopToMovieIdToMovie.put(entry[0], temp1);
            }

            Movie mov = new Movie(entry[0], entry[1], entry[2]);
            temp1.put(entry[1], mov);

            TreeSet<Movie> temp2 = cheapestMovieToShop.getOrDefault(entry[1], new TreeSet<>((o1, o2) -> {
                if (o1.price == o2.price) {
                    return Integer.compare(o1.shop, o2.shop);
                } else {
                    return Integer.compare(o1.price, o2.price);
                }
            }));

            if (temp2.isEmpty()) {
                cheapestMovieToShop.put(entry[1], temp2);
            }

            temp2.add(mov);
        }
    }

    public List<Integer> search(int movie) {
        TreeSet<Movie> set = cheapestMovieToShop.get(movie);

        if (set == null || set.isEmpty()) {
            return Collections.emptyList();
        }

        Iterator<Movie> iterator = set.iterator();

        List<Integer> res = new ArrayList<>(5);

        while (iterator.hasNext() && res.size() < 5) {
            Movie mov = iterator.next();
            res.add(mov.shop);
        }

        return res;
    }

    public void rent(int shop, int movie) {
        Movie mov = shopToMovieIdToMovie.get(shop).get(movie);
        cheapestRentedMovie.add(mov);

        cheapestMovieToShop.get(movie).remove(mov);

    }

    public void drop(int shop, int movie) {
        Movie mov = shopToMovieIdToMovie.get(shop).get(movie);
        cheapestRentedMovie.remove(mov);
        cheapestMovieToShop.get(movie).add(mov);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>(5);
        Iterator<Movie> iterator = cheapestRentedMovie.iterator();

        while (iterator.hasNext() && res.size() < 5) {
            Movie mov = iterator.next();
            List<Integer> temp = new ArrayList<>(2);
            temp.add(mov.shop);
            temp.add(mov.movie);
            res.add(temp);
        }

        return res;
    }

    public static class Movie {
        int shop;
        int movie;
        int price;
        boolean isRent = false;

        public Movie(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        public Movie(int shop, int movie, int price, boolean isRent) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
            this.isRent = isRent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Movie movie1 = (Movie) o;
            return shop == movie1.shop && movie == movie1.movie && price == movie1.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shop, movie, price);
        }
    }
}
