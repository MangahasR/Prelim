txt = "hello, world"
print (txt[2:7])
print(txt.upper())
name = "Python"
print(f"I Love {name}")
print(" ")

print (10>9)
print (10==9)
print(10<9)
print(" ")

a = 220
b = 33
print(" ")

print (10>9)
print (10==9)
print (bool("Hello"))
print (bool(0))
print(" ")

a = 15
b = 4
print (a%b)
print (a//b)
print (a**b)
a += 10
print(" ")

list = ["apple", "banana", "cherry"]
print (list)
print(" ")

list = ["apple", "banana", "cherry", "apple", "cherry"]
print (list)
print(" ")

list = ["apple", "banana", "cherry"]
list.append("orrange")
print (list)
print(" ")

list = ["apple", "banana", "cherry"]
list.insert(2,"Maksuna Sultan")
print (list)
print(" ")

list = ["apple", "banana", "cherry", "Maksuda Sultan"]
list.remove("Maksuda Sultan")
print (list)
print(" ")

list = ["apple", "banana", "cherry"]
list.pop(1)
print (list)
print(" ")

list = ["apple", "banana", "cherry"]
del list[0]
print (list)
print(" ")

list = ["apple", "banana", "cherry", "Maksuna Sultana"]
for i in range(len(list)):
    print(list)
print(" ")

list = ["red", "green", "blue"]
print(list[0])
list [1] = "yellow" 
list.append("Purple")
list.remove("red")
print(list)
print(" ")

list ="apple", "banana", "cherry" 
print(list)
print(" ")

list ="apple", "banana", "cherry" 
print(list[-2])
print(" ")

list = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(list[2:5])
print(" ")

a = 200
b = 33
if b > a:
    print("b is greater than a")
elif a == b:
    ("b and a is equal")
else: 
    print("a is greater then b")
print(" ")

age = 20
if age < 13:
    print("Child")
elif age <18:
    print("Teenager")
else:
    print("Adult")
print(" ")