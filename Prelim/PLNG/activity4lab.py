cost1 = float(input("Type the cost of the first purchase: "))
cost2 = float(input("Type the cost of the second purchase: "))
totalcost = cost1 + cost2
print("Total amount to be paid: ", totalcost)
pay = float(input("Type here for your payment: "))

if totalcost > pay:
    owe = totalcost - pay
    print("You still owe: ", owe)
elif pay > totalcost:
    change = pay - totalcost
    print("Thank you for your payment here's your change: ", change)