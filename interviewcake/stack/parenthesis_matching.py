def find_matching_parenthsis(sentence):
    stack = []

    for i in range(len(sentence)):
        if sentence[i] == '(':
            stack.append(sentence[i])
        elif sentence[i] == ')':
            if len(stack) == 1:
                return i
            stack.pop()
    return None

print(find_matching_parenthsis("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."))