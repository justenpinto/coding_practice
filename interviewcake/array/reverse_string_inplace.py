"""
Write a function that takes a list of characters and reverses the letters in place.
"""

def reverse_string_inplace(characters):
    """
    Runtime: O(n) Space: O(1)

    We swap the first and last characters, then the second and second-to-last characters,
    and so on until we reach the middle.
    """
    left_index = 0
    right_index = len(characters) - 1

    while left_index < right_index:
        # Normal way of swapping
        # temp_char = characters[left_index]
        # characters[left_index] = characters[right_index]
        # characters[right_index] = temp_char

        # Pythonic way of swapping
        characters[left_index], characters[right_index] = characters[right_index], characters[left_index]
        left_index += 1
        right_index -= 1


if __name__ == '__main__':
    characters = list('justen')
    reverse_string_inplace(characters)
    print(characters)
    characters = list('justine')
    reverse_string_inplace(characters)
    print(characters)