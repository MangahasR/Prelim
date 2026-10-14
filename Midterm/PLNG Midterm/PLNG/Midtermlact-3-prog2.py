#Prog 2
while True:
    user_First = input("Enter your first name: ")
    user_Last = input("Enter your last name: ")

    full_name = user_First + " " + user_Last

    print("Full name: ",user_First,user_Last)
    print("First Character: ",user_First[:1])
    print("Last Character: ",user_Last[:1])

    try:
        user_First[0] = "D"
    except TypeError as e:
        print(f"Caught an error! Type: {type(e).__name__}")
        print(f"Error Message: {e}")

    Dname = "D" + user_First[1:]
    print("New name: ",Dname)
    print("Original name: ",user_First)

    for char in full_name:
        print(char)

    user_First = full_name[: len(user_First)]
    user_Last= full_name[len(user_Last) + 1:]

    print(f"Sliced first name: {user_First}")  
    print(f"Sliced last name: {user_Last}")
    while True:
        search_char = input("Enter a character to find: ")
        sfull = full_name.casefold()
        
        if search_char.casefold() in sfull:
            all_indices = []
            for index, char in enumerate(sfull):
                if char == search_char.casefold():
                    all_indices.append(index)
        
            print(f"Character '{search_char}' found at indices: {all_indices}")
            break
        else:
            print(f"Character '{search_char}' was not found in the full name. Try again.")

    