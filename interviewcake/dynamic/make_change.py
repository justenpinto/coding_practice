def make_change(n, coins):
    ways_of_doing_n_cents = [0] * (n+1)
    ways_of_doing_n_cents[0] = 1

    for coin in coins:
        for i in range(coin, n+1):
            ways_of_doing_n_cents[i] += ways_of_doing_n_cents[i - coin]

    return ways_of_doing_n_cents[n]


if __name__ == '__main__':
    print(make_change(4, [1,2,3]))