def is_valid_code(string):
    BRACKETS = {'(': ')', '{': '}', '[': ']'}
    CLOSERS = set(BRACKETS.values())

    stack = []

    for i in range(len(string)):
        if string[i] in BRACKETS:
            stack.append(string[i])
        elif string[i] in CLOSERS:
            if not stack:
                return False
            opener = stack.pop()
            if BRACKETS[opener] != string[i]:
                return False

    return stack == []