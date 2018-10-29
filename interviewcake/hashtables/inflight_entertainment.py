"""
Users on longer flights like to start a second movie right when their first one ends, but they complain that the plane
usually lands before they can see the ending. So you're building a feature for choosing two movies whose total runtimes
will equal the exact flight length.

Write a function that takes an integer flight_length (in minutes) and a list of integers movie_lengths (in minutes) and
returns a boolean indicating whether there are two numbers in movie_lengths whose sum equals flight_length.

When building your function:

1. Assume your users will watch exactly two movies
2. Don't make your users watch the same movie twice
3. Optimize for runtime over memory
"""


def check_movie_lengths(flight_time, movies_lengths):
    """
    Runtime: O(n)
    Space: O(1)

    We make one pass through movie_lengths, treating each item as the first_movie_length. At each iteration, we:

    1. See if there's a matching_second_movie_length we've seen already (stored in our movie_lengths_seen set) that is
       equal to flight_length - first_movie_length. If there is, we short-circuit and return True.
    2. Keep our movie_lengths_seen set up to date by throwing in the current first_movie_length.
    """
    movie_lengths_seen = set()

    for movie_length in movies_lengths:
        remaining_time = flight_time - movie_length
        if remaining_time in movie_lengths_seen:
            return True
        else:
            movie_lengths_seen.add(movie_length)

    return False


if __name__ == '__main__':
    pass
