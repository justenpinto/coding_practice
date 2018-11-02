def is_valid_binary_search_tree(node, lower_bound=-float('inf'), upper_bound=float('inf')):
    if not node:
        return True

    if node.value >= upper_bound or node.value <= lower_bound:
        return False

    return (is_valid_binary_search_tree(node.left, lower_bound, node.value)
            and is_valid_binary_search_tree(node.right, node.value, upper_bound))


def is_binary_search_tree_iterative(root):
    stack = [(root, -float('inf'), float('inf'))]

    while stack:
        node, lower_bound, upper_bound = stack.pop()

        if node.value <= lower_bound or node.value >= upper_bound:
            return False

        if node.left:
            stack.append((node.left, lower_bound, node.value))
        if node.right:
            stack.append((node.right, node.value, upper_bound))

    return True
