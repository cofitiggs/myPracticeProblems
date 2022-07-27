def reverse_words(string_to_reverse: str) -> str:
    words = string_to_reverse.split()
    return ' '.join([word[::-1] for word in words])

print(reverse_words("sihT dluohs tnirp ylraluger fi enod .yltcerroc"))