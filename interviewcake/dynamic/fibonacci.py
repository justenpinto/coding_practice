def fib_recursive(n):
    if n == 0:
        return 0
    if n <= 2:
        return 1

    return fib_recursive(n - 1) + fib_recursive(n - 2)


def fib_iterative(n):
    prev_prev = 0
    prev = 1

    fib = 0

    for _ in range(n - 1):
        fib = prev + prev_prev
        prev_prev = prev
        prev = fib

    return fib
