class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if not self.items:
            return None
        item = self.items.pop()
        return item

    def peek(self):
        if not self.items:
            return None
        return self.items[-1]

class QueueOfTwoStacks:
    def __init__(self):
        self.input_stack = Stack()
        self.output_stack = Stack()

    def enqueue(self, item):
        self.input_stack.push(item)

    def dequeue(self):
        if self.output_stack:
            return self.output_stack.pop()

        while self.input_stack:
            self.output_stack.push(self.input_stack.pop())
