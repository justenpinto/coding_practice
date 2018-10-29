def get_word_cloud(sentence):
    words = sentence.split(' ')
    cloud = dict()
    for word in words:
        word = word.replace('.', '').replace(',', '').replace(':', '').replace('!', '').replace('?', '')
        if word not in cloud:
            cloud[word] = 0
        cloud[word] += 1
    return cloud


if __name__ == '__main__':
    print(get_word_cloud('hi my name is justen, how are you justen?'))