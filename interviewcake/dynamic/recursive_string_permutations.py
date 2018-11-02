def generate_string_permutations(string):
    if len(string) == 1:
        return string

    strings = generate_string_permutations(string[1:])

    permutations = set()
    for s in strings:
        for i in range(len(s) + 1):
            permutations.add(s[:i] + string[0] + s[i:])
    return permutations