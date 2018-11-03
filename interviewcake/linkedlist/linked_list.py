class LinkedList:
    def __init__(self, root):
        self.root = root

    def delete_node(self, node_to_delete):
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
