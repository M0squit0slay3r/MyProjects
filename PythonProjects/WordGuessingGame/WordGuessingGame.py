import random

word_bank=['coffee','kitty','coding','algorithm','programming']

word = random.choice(word_bank)

guessed_word = ['_'] * len(word)

attempts = 10 

while attempts > 0:
    print('\nCurrent word:' + ''.join(guessed_word))

    guess = input('Guess a letter: ')

    if guess in word:
        for i in range(len(word)):
         if word[i] == guess:
            guessed_word[i] = guess
        print('✅ Right guess!')
    else:
        attempts -= 1
        print(' ❌ Wrong guess! Attempts left: ' + str(attempts))

    if '_' not in guessed_word:
        print('\n🎉 Congratulations! You guessed the word: ' + word)
        break

else:
        print('\n💀 You\'ve run out of attempts! The word was: ' + word)