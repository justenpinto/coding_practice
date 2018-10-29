"""
Write a function for doing an in-place ↴ shuffle of a list.

The shuffle must be "uniform," meaning each item in the original list must have the same probability of ending up in
each spot in the final list.

Assume that you have a function get_random(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.
"""

from random import randint


def inplace_shuffle(list):
    """
    Runtime: O(n)
    Space: O(n)
    """
    list_length = len(list)

    for i in range(len(list)):
        swap_index = randint(i, list_length - 1)
        if swap_index != i:
            list[i], list[swap_index] = list[swap_index], list[i]


if __name__ == '__main__':
    list = [1, 2, 3, 4, 5]
    inplace_shuffle(list)
    print(list)
