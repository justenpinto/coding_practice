def reverse_characters(words, left_index=None, right_index=None):
    """

    Helper function for reversing characters in a list
    :param words:
    :param left_index:
    :param right_index:
    :return:
    """
    left_index = left_index or 0
    right_index = right_index or len(words) - 1

    while left_index < right_index:
        words[left_index], words[right_index] = words[right_index], words[left_index]
        left_index += 1
        right_index -= 1


def reverse_words_inplace(message):
    """
    Runtime: O(n)
    Space: O(1)


    We'll write a helper function reverse_characters() that reverses all the characters between a left_index and
    right_index. We use it to:

    1. Reverse all the characters in the entire message, giving us the correct word order but with each word backward.
    2. Reverse the characters in each individual word.
    """
    reverse_characters(message)

    current_index = 0

    for i in range(len(message) + 1):
        if i == len(message) or message[i] == ' ':
            reverse_characters(message, current_index, i - 1)
            current_index = i + 1


if __name__ == '__main__':
    message = list('this is my message')
    reverse_words_inplace(message)
    print(message)
