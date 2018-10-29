"""
Each round, players receive a score between 0 and 100, which you use to rank them from highest to lowest.
So far you're using an algorithm that sorts in O(n*lg n) time, but players are complaining that their rankings aren't
updated fast enough. You need a faster sorting algorithm.

Write a function that takes:

1. a list of unsorted_scores
1. the highest_possible_score in the game

and returns a sorted list of scores in less than O(n*lg n) time.
"""


def sort_scores(scores, highest_score=100):
    """
    Runtime: O(n + k)
    Space: O(n + k)

    Using counting sort
    """
    count = [0] * (highest_score + 1)
    for score in scores:
        count[score] += 1

    sorted_scores = []

    for score in range(highest_score, 0, -1):
        score_count = count[score]
        for time in range(score_count):
            sorted_scores.append(score)

    return sorted_scores


if __name__ == '__main__':
    print(sort_scores([37, 89, 41, 65, 91, 53, 99, 99, 100]))
