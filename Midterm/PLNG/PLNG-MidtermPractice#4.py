
from datetime import date
import tkinter as tk
from tkinter import simpledialog
import math

# Get total pages
while True:
    try:
        total_pages = int(input("Enter total pages of the book: "))
        if total_pages <= 0:
            print("Please enter a number greater than 0.")
            continue
        break
    except ValueError:
        print("Invalid input! Please enter a number.")

# Get pages already read
while True:
    try:
        pages_read = int(input("Enter pages already read: "))
        if pages_read < 0 or pages_read > total_pages:
            print("Please enter a number from 0 to", total_pages)
            continue
        break
    except ValueError:
        print("Invalid input! Please enter a number.")

# Get days spent reading
while True:
    try:
        days_reading = int(input("Enter how many days you have been reading: "))
        if days_reading < 0:
            print("Please enter 0 or a positive number.")
            continue
        break
    except ValueError:
        print("Invalid input! Please enter a number.")

# Get issue date and due date
root = tk.Tk()
root.withdraw()

while True:
    try:
        issue_input = simpledialog.askstring(
            "Issue Date", "Enter issue date (YYYY-MM-DD):"
        )
        issue_date = date.fromisoformat(issue_input)

        due_input = simpledialog.askstring(
            "Due Date", "Enter due date (YYYY-MM-DD):"
        )
        due_date = date.fromisoformat(due_input)

        if due_date <= issue_date:
            print("Due date must be after the issue date.")
            continue
        break
    except (ValueError, TypeError):
        print("Invalid date! Please enter dates as YYYY-MM-DD.")

root.destroy()

today = date.today()

# Calculate percentage read
percentage = (pages_read / total_pages) * 100

# Calculate days remaining to return the book
days_remaining = (due_date - today).days

# Calculate allotted days and remaining reading days
allotted_days = (due_date - issue_date).days
days_left_to_read = allotted_days - days_reading

# Calculate remaining pages
remaining_pages = total_pages - pages_read

if days_left_to_read <= 0:
    days_left_to_read = 1

pages_per_day = math.ceil(remaining_pages / days_left_to_read)

# Display results
print(f"You have read {percentage:.0f}% of the book.")

if days_remaining < 0 or days_reading > allotted_days:
    print("Your book is overdue! Please return it immediately.")
elif days_remaining == 0:
    print("Your book is due today! Please return it today.")
else:
    print(f"You have {days_remaining} days remaining to return the book.")

if remaining_pages == 0:
    print("You have finished reading the book!")
elif days_remaining <= 0 or days_reading >= allotted_days:
    print("Please return the book instead of continuing to read.")
else:
    print(f"You should read {pages_per_day} pages per day.")
