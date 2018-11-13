def find_missing_id(delivery_id_confirmations):
    missing_id = 0
    for drone_id in delivery_id_confirmations:
        missing_id ^= drone_id

    return missing_id

if __name__ == '__main__':
    print(find_missing_id([
        1,
        2,
        3,
        4,
        5,
        2,
        1,
        4,
        5
    ]))