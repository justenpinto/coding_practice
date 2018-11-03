class MaxStack:
    def __init__(self):
        self.items = []
        self.max_items = []

    def push(self, item):
        if item >= self.max_items[-1]:
            self.max_items.append(item)
        self.items.append(item)

    def pop(self):
        if not self.items:
            return None
        item = self.items.pop()
        if item == self.max_items[-1]:
            self.max_items.pop()
        return item

    def peek(self):
        if not self.items:
            return None
        return self.items[-1]

    def get_max(self):
        if not self.items:
            return None
        return self.max_items[-1]
