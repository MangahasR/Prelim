def last_word(word1, word2, word3):
    return max(word1, word2, word3)

word1 = input("Enter the first word: ")
word2 = input("Enter the second word: ")
word3 = input("Enter the third word: ")

print("The word that comes last alphabetically is:", last_word(word1, word2, word3))