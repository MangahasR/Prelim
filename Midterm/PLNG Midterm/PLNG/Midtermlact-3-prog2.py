#Prog 2

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
user_Last= full_name[len(user_Last) + 0:]

print(f"Sliced first name: {user_First}")  
print(f"Sliced last name: {user_Last}")

letter = input("Enter one character to search: ")

if len(letter) == 1 and letter.isalpha():
    
    if letter in full_name:
        first_index = full_name.find(letter)
        letter_count = full_name.count(letter)
        print(f"Character found at index: {letter_count}")
    else:
        print("Letter not found in the string.")
        
else:
    print("Invalid input. Type exactly one letter.")