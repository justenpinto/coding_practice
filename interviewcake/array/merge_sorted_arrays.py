"""
We have our lists of orders sorted numerically already, in lists. Write a function to merge our lists of orders into
one sorted list.

For example:

  my_list     = [3, 4, 6, 10, 11, 15]
  alices_list = [1, 5, 8, 12, 14, 19]

# Prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
print merge_lists(my_list, alices_list)
"""

def merge_sorted_arrays(array1, array2):
    """
    Runtime: O(n)
    Space: O(n)

    First, we allocate our answer list, getting its size by adding the size of array2 and array1.

    We keep track of a current index in array2, a current index in array1, and a current index in merged_list. 
    So at each step, there's a "current item" in array1 and in array2. The smaller of those is the next one we add 
    to the merged_list!
    
    But careful: we also need to account for the case where we exhaust one of our lists and there are still elements in 
    the other. To handle this, we say that the current item in array2 is the next item to add to merged_list only if 
    array2 is not exhausted AND, either:
    
    1. array1 is exhausted, or
    2. the current item in array2 is less than the current item in array1
    """
    sorted_list = [None] * (len(array1) + len(array2))
    index_1 = 0
    index_2 = 0
    current_index = 0

    while current_index < len(sorted_list):
        is_array1_exhausted = index_1 >= len(array1)
        is_array2_exhausted = index_2 >= len(array2)
        if not is_array1_exhausted and (is_array2_exhausted or array1[index_1] < array2[index_2]):
            sorted_list[current_index] = array1[index_1]
            index_1 += 1
        else:
            sorted_list[current_index] = array2[index_2]
            index_2 += 1

        current_index += 1

    return sorted_list



if __name__ == '__main__':
    print(merge_sorted_arrays(
        [3, 4, 6, 10, 11, 15],
        [1, 5, 8, 12, 14, 19]
    ))