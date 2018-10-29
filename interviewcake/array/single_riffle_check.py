"""
Let's write a function to tell us if a full deck of cards shuffled_deck is a single riffle of two other
halves half1 and half2.
"""


def is_single_riffle(shuffled_deck, half1, half2):
    """
    Runtime: O(n)
    Space: O(1)

     We walk through shuffled_deck, seeing if each card so far could have come from a riffle of the other two halves.
     To check this, we:

    1. Keep pointers to the current index in half1, half2, and shuffled_deck.
    2. Walk through shuffled_deck from beginning to end.
    3. If the current card in shuffled_deck is the same as the top card from half1, increment half1_index and keep
       going. This can be thought of as "throwing out" the top cards of half1 and shuffled_deck, reducing the problem to
       the remaining cards in the stacks.
    4. Same as above with half2.
    5. If the current card isn't the same as the card at the top of half1 or half2, we know we don't have a single
       riffle.
    6. If we make it all the way to the end of shuffled_deck and each card checks out, we know we do have a single
       riffle.
    """
    index1 = 0
    index1_max_index = len(half1) - 1
    index2 = 0
    index2_max_index = len(half2) - 1

    for card in shuffled_deck:
        if index1 <= index1_max_index and card == half1[index1]:
            index1 += 1
        elif index2 <= index2_max_index and card == half2[index2]:
            index2 += 1
        else:
            return False
    return True


if __name__ == '__main__':
    pass
