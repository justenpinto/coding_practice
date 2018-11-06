class LinkedList:
    def __init__(self, root):
        self.root = root

    @staticmethod
    def delete_node(node_to_delete):
        next_node = node_to_delete.next

        if next_node:
            node_to_delete.value = next_node.value
            node_to_delete.next = next_node.next
        else:
            raise Exception('Cannot delete last node with this method')

    def has_cycle(self):
        tortoise = self.root
        hair = self.root

        while hair and hair.next:
            tortoise = tortoise.next
            hair = hair.next.next
            if tortoise is hair:
                return True
        return False

    def reverse(self):
        if not self.root:
            return
        current_node = self.root
        previous_node = None
        while current_node:
            next_node = current_node.next
            current_node.next = previous_node
            previous_node = current_node
            current_node = next_node
        self.root = previous_node

    def nth_to_last_node(self, n):
        leading_node = self.root
        for i in range(n - 1):
            leading_node = leading_node.next
            if not leading_node:
                raise Exception('Cannot find %dth item, length of list is too short (%d).' % (n, i))

        current_node = self.root
        while leading_node.next:
            current_node = current_node.next
            leading_node = leading_node.next

        return current_node



    def print_list(self):
        current_node = self.root
        values = []
        while current_node:
            values.append('%s' % current_node.value)
            current_node = current_node.next
        print('->'.join(values))

if __name__ == '__main__':
    from interviewcake.linkedlist.linked_list_node import LinkedListNode
    a = LinkedListNode(1)
    b = LinkedListNode(2)
    c = LinkedListNode(3)

    a.next = b
    b.next = c

    list = LinkedList(a)
    print(list.nth_to_last_node(3))