import random


def rand5_helper():
    return random.randint(1, 5)


def rand7_helper():
    return random.randint(1, 7)


def rand5_from_rand7():
    random_number = rand7_helper()
    while random_number > 5:
        random_number = rand7_helper()
    return random_number


def rand7_from_rand5():
    while True:
        row = rand5_helper()
        col = rand5_helper()

        outcome_number = (row - 1) * 5 + col

        if outcome_number <= 21:
            return outcome_number % 8
