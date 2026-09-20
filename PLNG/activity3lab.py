while True:
    num = int(input("Enter a multiple of 5 between 1 and 100: "))
    while True:
      if 1 <= num <= 100 and num % 5 == 0:
           print("Valid number!")
           break
      else:
           print("Invalid number. It must be a multiple of 5 between 1 and 100.")
           break

