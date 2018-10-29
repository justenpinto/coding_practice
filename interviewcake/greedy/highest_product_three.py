"""
Given a list of integers, find the highest product you can get from three of the integers.

The input list_of_ints will always have at least three integers.
"""


def get_highest_product(integer_list):
    """
    Runtime: O(n)
    Space: O(1)
    """
    if len(integer_list) < 3:
        raise Exception('Not enough integers.')

    highest_product = integer_list[0] * integer_list[1] * integer_list[2]

    highest_integer = max(integer_list[0], integer_list[1])
    highest_two_product = integer_list[0] * integer_list[1]

    lowest_integer = min(integer_list[0], integer_list[1])
    lowest_two_product = integer_list[0] * integer_list[1]

    for i in range(2, len(integer_list)):
        value = integer_list[i]
        highest_product = max(highest_product, highest_two_product * value, lowest_two_product * value)

        highest_two_product = max(highest_two_product, value * highest_integer)
        lowest_two_product = min(lowest_two_product, value * lowest_integer)

        highest_integer = max(highest_integer, value)
        lowest_integer = min(lowest_integer, value)

    return highest_product


if __name__ == '__main__':
    print(get_highest_product([-10, -10, 1, 3, 2]))
