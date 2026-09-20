while True:
    print("\nArithmetic Operations")
    print("1. Addition")
    print("2. Subtraction")
    print("3. Multiplication")
    print("4. Divsion")
    print("5. Modulos")
    print("6. Increment")
    print("7. Decrement")

    user = input("\nSelect an arithmetic operation: ")

    if user not in ["1", "2", "3", "4", "5", "6", "7"]:
        print("Error: Invalid menu option.")
        continue
    if user == "1" or user == "2" or user == "3" or user == "4" or user == "5":

        x = float(input("Enter the value of x: "))
        y = float(input("Enter the value of y: "))

        print(f"\nVariable Value: x = {x}, y = {y}")

        if user == "1":
            result = x + y
            print(f"Addition: x + y = {result}")
        elif user == "2":
            result = x - y
            print(f"Subtraction: x - y = {result}")
        elif user == "3":
            result = x * y
            print(f"Mulplication: x * y = {result}")
        elif user == "4":
            if y == 0:
                print("Error: Division by zero is not allowed.")
            else:
                result = x / y
            print(f"Division: x / y = {result:.2f}")
        elif user == "5":
            if y == 0:
                print("Error: Modulus by zero is not allowed.")
            else:
                result == x % y
                print(F"Modulus: x % y = {result}") 
    elif user == "6":
        x = float(input("Enter the value of x: "))

        result = x + 1

        print(f"\nVariable value: x = {x}")
        print(f"Increment: x + 1 = {result}")

    elif user == "7":
        x = float(input("Enter the value of x: "))

        result = x - 1

        print(f"\nVariable value: x = {x}")
        print(f"Decrement: x - 1 = {result}")

    while True:
            user_cho = input(f"Do you want to continue? (YES/NO) ").upper()

            if user_cho == "YES":
                break
            elif user_cho == "NO":
                print("Program termanited. Thank you!")
                exit()
            else: 
                print("Please enter YES or NO.")