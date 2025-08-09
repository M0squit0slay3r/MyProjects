name = input("Enter your name: ")

print("Hi" + name + "Welcome" )

should_we_play = input("Do you wanna play a game? (yes/no) ").lower()

if should_we_play == "yes" or should_we_play == "y":
    print("Well ok i guess")

    direction = input("Do you want to go left or right? (left/right)").lower()
    if direction == "left" or direction == "l":
        print("you died, cause i dont want you to continue from left.")

    elif direction == "right" or direction == "r":
        print("Okay, Lets see whats on the right")
        choice = input("There is a bridge in front of you, want to swim under or cross it? (swim/cross)")
        if choice == "swim":
            print("Why would you swim there is literally a bridge in front of you. You died.")
        elif choice == "cross":
            print("A cat appeared in the middle of the bridge")
            cat = input("Will you pet the cat or ignore and go on (pet/ignore)")
            if cat == "pet":
                print("The cat started purring and now will follow you.")
            elif cat == "ignore":
                print("You cant just ignore a cat you died.")
            else:
                print("You died. Choose only from options next time.")
            
        else:
            print("Don't try me and choose the options given. You died")

    else:
        print("I see you are struggling with your decisions too bad, you died.")
        
elif should_we_play == "no" or should_we_play == "n":
    print("Your loss..")

else: 
    print("Is it so hard to choose yes or no -_- ? ")

