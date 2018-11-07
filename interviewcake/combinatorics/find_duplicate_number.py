def find_duplicate_number(numbers):
    n = len(numbers) - 1
    theoretical_sum = int((pow(n, 2) + n) / 2)
    actual_sum = sum(numbers)

    return actual_sum - theoretical_sum


if __name__ == '__main__':
    print(find_duplicate_number([
        1, 2, 3, 4, 4
    ]))
