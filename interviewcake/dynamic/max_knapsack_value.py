def max_duffel_bag_value(cake_tuples, capacity):
    max_value_for_capacity_n = [0] * (capacity + 1)

    for current_capacity in range(1, len(max_value_for_capacity_n)):
        for weight, value in cake_tuples:
            if current_capacity >= weight:
                max_value_for_capacity_n[current_capacity] = max(max_value_for_capacity_n[current_capacity],
                                                                 max_value_for_capacity_n[
                                                                     current_capacity - weight] + value)

    return max_value_for_capacity_n[capacity]


if __name__ == '__main__':
    cake_tuples = [
        (7, 160),
        (3, 90),
        (2, 15)
    ]

    capacity = 0

    print(max_duffel_bag_value(cake_tuples, capacity))
