import math

class TempTracker:
    def __init__(self):
        self.num_values = 0
        self.total_temperature = 0
        self.mean = 0
        self.max = -math.inf
        self.min = math.inf
        self.mode = None

        self.temperature_count_array = [0] * 111

    def insert(self, temperature):
        self.num_values += 1
        self.total_temperature += temperature
        self.mean = self.total_temperature / self.num_values

        self.temperature_count_array[temperature] += 1

        self.max = max(self.max, temperature)
        self.min = min(self.min, temperature)

        if self.mode is None:
            self.mode = temperature
        else:
            if self.temperature_count_array[temperature] > self.temperature_count_array[self.mode]:
                self.mode = temperature

    def get_max(self):
        return self.max

    def get_min(self):
        return self.min

    def get_mean(self):
        return self.mean

    def get_mode(self):
        return self.mode


if __name__ == '__main__':
    x = TempTracker()
    x.insert(1)
    x.insert(2)
    x.insert(3)
    x.insert(4)
    x.insert(5)
    x.insert(1)
    x.insert(5)

    print('Max: %s\nMin: %s\nMean: %f\nMode: %s' % (x.get_max(), x.get_min(), x.get_mean(), x.get_mode()))