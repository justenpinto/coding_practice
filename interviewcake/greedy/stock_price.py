"""
First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.

So I grabbed Apple's stock prices from yesterday and put them in a list called stock_prices, where:

1. The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
2. The values are the price (in US dollars) of one share of Apple stock at that time.

So if the stock cost $500 at 10:30am, that means stock_prices[60] = 500.

Write an efficient function that takes stock_prices and returns the best profit I could have made from one purchase and
one sale of one share of Apple stock yesterday.
"""

def get_max_profit(stock_prices):
    """
    Runtime: O(n)
    Space: O(n)
    """
    lowest_price = stock_prices[0]
    max_profit = 0
    for i in range(1, len(stock_prices)):
        price = stock_prices[i]
        max_profit = max(max_profit, price - lowest_price)
        lowest_price = min(lowest_price, price)
    return max_profit


if __name__ == '__main__':
    print(get_max_profit([10, 7, 5, 8, 11, 9]))