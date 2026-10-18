while True:
 print("\nStudent grade calculator")

 java_score = float(input("Java Programming Score: "))
 c_score = float(input("C Programming Score: "))
 data_score = float(input("Data Handling Score: "))

 ave = (java_score + c_score + data_score) / 3

 if ave >= 90:
    grade = "A because the average is between 90 and 100"
 elif ave >= 80:
    grade = "B because the average is between 80 and 89"
 elif ave >= 75:
    grade = "C because the average is between 75 and 79"
 else: 
    grade = "F because the average is below 75"


 print(f"\nAverage: {ave:.2f}")
 print(f"Grade: {grade}")

 choice = input("Do you want to continue? (YES/NO): ").strip().upper()

 if choice == "NO":
    print("Program Terminated. Thank you!")
    break
 elif choice != "YES":
    print("Invalid input. Program Terminated.")
    break
