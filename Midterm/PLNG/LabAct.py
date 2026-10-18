#Prog1
#This prints welcome
print("Hello World")

#Prog2
# Gets and print your name 
usertext = input("What is your name? ")
print("Hello", usertext)

#Prog3
#Addition
num1 = input('Enter first number: ')
num2 = input('Enter second number: ')
sum_val = float(num1) + float(num2)
print('The sum of {0} and {1} is {2}'.format(num1, num2, sum_val))

#Prog4
#To find the average
num1 = input('Enter first number: ')
num2 = input('Enter second number: ')
average = (int(num1) + int(num2)) // 2
print('average:{0} '.format(average))

#Prog5
#Average for grades 
visagrade = input('enter your visa grade : ')
finalgrade = input('enter your final grade : ')
average = (float(visagrade) * 0.3) + (float(finalgrade) * 0.7)
print("average :{0} ".format(average))

#Prog6
#Average 3 written grades
firstexam = input('your first exam : ')
secondexam = input('your second exam : ')
thirdexam = input('your third exam : ')
average = (float(firstexam) + float(secondexam) + float(thirdexam)) / 3
print("average :{0} ".format(average))

#Prog7
#Class status passed or failed
average = input('enter average : ')
if int(average) >= 50:
    print("Passed")
else:
    print("Failed")

#Prog8
#Odd or Even
num = int(input("Enter a number: "))
if (num % 2) == 0:
    print("{0} is Even".format(num))
else:
    print("{0} is Odd".format(num))

#Prog9
#Positive or negative or 0
num = float(input("Enter a number: "))
if num > 0:
    print("Positive number")
elif num == 0:
    print("Zero")
else:
    print("Negative number")

#Prog10
#Calculation of bodymass
import math
height = float(input("enter height (m):"))
weight = int(input("enter weight (kg):"))
index = weight / (height * height)
if index <= 18:
    print("\n underweight BMI:{}".format(index))
elif 18 < index <= 25:
    print("\n normal weight BMI:{}".format(index))
elif 25 < index <= 30:
    print("\n obese BMI:{}".format(index))
elif index > 30:
    print("\n severely obese BMI:{}".format(index))

#Prog11
#To check if  the age of the user can drive
age = input('enter age : ')
if int(age) < 18:
    print("Your Age Is Not Eligible To Get A Driver's License")
else:
    print("Your Age Is Eligible To Get Your License")

#Prog12
#List number 1-100 on the screen
for i in range(1, 101):
    print(i, end=" ")
print()

#Prog13
#List even numbers to 1-100 on the screen
for i in range(1, 101):
    if i % 2 == 0:
        print(i, end=" ")
print()

#Prog14
#List odd numbers to 1-100 on the screen
for i in range(1, 101):
    if i % 2 != 0:
        print(i, end=" ")
print()

#Prog15
#numbers that can be divided in 3 and 5 to a 1-100
for i in range(1, 101):
    if i % 3 == 0 or i % 5 == 0:
        print(i, end=" ")
print()

#Prog16
#List 1 to user entered number
num = input('enter number : ')
for i in range(1, int(num) + 1):
    print(i, end=" ")
print()

#Prog17
#Find the area and perimeter of a rectangle with its side
short = input('Enter short side : ')
tall = input('Enter tall side : ')
area = int(short) * int(tall)
perimeter = 2 * (int(short) + int(tall))
print("area: {0}".format(area))
print("perimeter: {0}".format(perimeter))

#Prog18
#Print letter of the entered text one under the other
word = 'mrhuseyin'
for char in word:
    print(char)

#Prog19
#Sum of numbers between two numbers the user has entered
sumofnumbers = 0
num1 = input('first number: ')
num2 = input('second number: ')
for i in range(int(num1) + 1, int(num2)):
    sumofnumbers += i
print("Sum of numbers between {0} and {1} : {2}".format(num1, num2, sumofnumbers))

#Prog20
#For example, let’s ask the user about their choice of cinema or theater. You have to pay 10 dollars to
#watch movies and 5 dollars for theater. We think that students get 50% discount. If the student is
#discounted; If he is not a student, let’s write a document that calculates the non-discounted amount
#and prints it.
selection = input("Press (1) for Cinema, (2) for Theater : ")
student = input("Are you student(Y/N) : ")
price = 0
#non-discounted fee calculation
if selection == '1':
    price = 10
elif selection == '2':
    price = 5
#student discount
if student == 'Y' or student == 'y':
    price = price / 2
print("The fee you have to pay : {}".format(price))

#Prog21
#To find out if the entered number is Prime or Not
num = int(input("Enter a number: "))
if num > 1:
    for i in range(2, num):
        if (num % i) == 0:
            print(num, "is not a prime number")
            print(i, "times", num // i, "is", num)
            break
    else:
        print(num, "is a prime number")
else:
    print(num, "is not a prime number")

#Prog22
#Seperates the sum of odd and even numbers up to the number that the user has
NumList = []
Even_Sum = 0
Odd_Sum = 0
Number = int(input("Please enter the Total Number of List Elements: "))
for i in range(1, Number + 1):
    value = int(input("Please enter the Value of Element %d: " % i))
    NumList.append(value)
for val in NumList:
    if val % 2 == 0:
        Even_Sum = Even_Sum + val
    else:
        Odd_Sum = Odd_Sum + val
print("\nThe Sum of Even Numbers in this List = ", Even_Sum)
print("The Sum of Odd Numbers in this List = ", Odd_Sum)

#Prog23
#Calculation on the increased salary of the worker whose salary and raise rate
salary = input("enter current salary : ")
raise_rate = input("salary raise rate(%) : ")
newsalary = int(salary) + (int(salary) * int(raise_rate) / 100)
print("increased salary :", newsalary)

#Prog24
#Calculation of the area and circumference of the circle whose radius is entered using the function
import math
def find_Diameter(radius):
    return 2 * radius
def find_Circumference(radius):
    return 2 * math.pi * radius
def find_Area(radius):
    return math.pi * radius * radius
r = float(input(' Please Enter the radius of a circle: '))
diameter = find_Diameter(r)
circumference = find_Circumference(r)
area = find_Area(r)
print("\n Diameter Of a Circle = %.2f" % diameter)
print(" Circumference Of a Circle = %.2f" % circumference)
print(" Area Of a Circle = %.2f" % area)

#Prog25
#Calculation the area of the rectangle, whose width and height are entered using the function
def areaRectangle(a, b):
    return a * b
def perimeterRectangle(a, b):
    return 2 * (a + b)
a = 5
b = 6
print("Area = ", areaRectangle(a, b))
print("Perimeter = ", perimeterRectangle(a, b))

#Prog26
#Making a Number Guessing Gam
import random
import math
lower = int(input("Enter Lower bound:- "))
upper = int(input("Enter Upper bound:- "))
x = random.randint(lower, upper)
chances = round(math.log(upper - lower + 1, 2))
print("\n\tYou've only ", chances, " chances to guess the integer!\n")
count = 0
while count < chances:
    count += 1
    guess = int(input("Guess a number:- "))
    if x == guess:
        print("Congratulations you did it in ", count, " try")
        break
    elif x > guess:
        print("You guessed too small!")
    elif x < guess:
        print("You Guessed too high!")
if count >= chances and x != guess:
    print("\nThe number is %d" % x)
    print("\tBetter Luck Next time!")

#Prog27
#To find out what day of the year a given date is
import datetime
date_input = str(input('Enter the date (for example: 09 02 2019): '))
day_name = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
day = datetime.datetime.strptime(date_input, '%d %m %Y').weekday()
print(day_name[day])

#Prog28
#To find missing numbers in a sorted list range
def find_missing(lst):
    return [x for x in range(lst[0], lst[-1] + 1) if x not in lst]
lst = [1, 2, 4, 6, 7, 9, 10]
print("Missing Elements:", find_missing(lst))

#Prog29
#To check if there is a specified character in a string 
char_list = ["a", "b", "c"]
string = "abcd"
matched_list = [char for char in char_list if char in string]
print("Matched Elements:", matched_list)

#Prog30
#To find the average of odd and even averages of whole numbers
total = 0
evenSums = 0
oddSums = 0
done = False
while(not done):
    user_in = input("Give me an integer or type 'done' to be done.")
    if( user_in.lower() == "done"):
        done = True
    else:
 # assuming they've typed in an integer
        total += int(user_in)
    if user_in % 2 == 0:
        evenSums += user_in
        evenAverage = evenSums / user_in
    else:
        oddSums += user_in
        oddAverage = oddSums / user_in
print(total)
print("Even Average: " + str(evenAverage))
print("Odd Average: " + str(oddAverage))