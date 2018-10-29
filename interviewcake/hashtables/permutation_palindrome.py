def is_permutation_palindrome(word):
    """
    Runtime: O(n)
    Space: O(k) - number of allowable characters

    Our approach is to check that each character appears an even number of times, allowing for only one character to
    appear an odd number of times (a middle character). This is enough to determine if a permutation of the input string
    is a palindrome.

    We iterate through each character in the input string, keeping track of the characters we’ve seen an odd number of
    times using a set unpaired_characters.

    As we iterate through the characters in the input string:

    1. If the character is not in unpaired_characters, we add it.
    2. If the character is already in unpaired_characters, we remove it.

    Finally, we just need to check if less than two characters don’t have a pair.
    """
    unpaired_characters = set()
    for character in word:
        if character not in unpaired_characters:
            unpaired_characters.add(character)
        else:
            unpaired_characters.remove(character)

    return len(unpaired_characters) <= 1


if __name__ == '__main__':
    print(is_permutation_palindrome('civic'))
