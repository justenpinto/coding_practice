from collections import deque


def find_shortest_path(graph, start, end):
    if start not in graph:
        raise Exception('%s is not in graph.' % start)
    if end not in graph:
        raise Exception('%s is not in graph.' % end)

    queue = deque()
    queue.append(start)

    path = {
        start: None
    }

    while queue:
        node = queue.popleft()
        
        if node == end:
            message_path = []
            current_node = end
            while current_node != start:
                message_path.append(path[current_node])
                current_node = path[current_node]
            message_path.reverse()
            return message_path

        for neighbour in graph[node]:
            if neighbour not in path:
                queue.append(neighbour)
                path[neighbour] = node

    return None


if __name__ == '__main__':
    graph = {
        'a': ['b', 'd'],
        'b': ['c', 'e']
    }
    find_shortest_path(graph, 'a', 'b')
