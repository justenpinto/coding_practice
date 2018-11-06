class LinkedListNode:
    def __init__(self, value):
        self.value = value
        self.next = None

    def __str__(self):
        return '%s' % self.value