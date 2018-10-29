"""
You have a list of integers, and for each index you want to find the product of every integer except the integer at that
index.

Write a function get_products_of_all_ints_except_at_index() that takes a list of integers and returns a list of the
products.

For example, given:

  [1, 7, 3, 4]

your function would return:

  [84, 12, 28, 21]

by calculating:

  [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]

Here's the catch: You can't use division in your solution!
"""


def get_products_of_all_ints_except_at_index(list_of_ints):
    """
    Runtime: O(n)
    Space: O(n)
    """
    product_list = [1] * len(list_of_ints)

    current_product = list_of_ints[0]
    for i in range(1, len(list_of_ints)):
        product_list[i] = current_product
        current_product *= list_of_ints[i]

    current_product = list_of_ints[-1]
    for i in range(len(list_of_ints) - 2, -1, -1):
        product_list[i] *= current_product
        current_product *= list_of_ints[i]

    return product_list


if __name__ == '__main__':
    print(get_products_of_all_ints_except_at_index([1, 7, 3, 4]))
