# Campus Service Queue Manager
# Python 3 - Midterm Lab Activity

PURPOSES = ["Enrollment", "Records", "Payment"]
SERVICE_TYPES = ["regular", "priority"]

tickets = []
waiting = []
completed = []
counters = [None, None]
ticket_number = 1
priority_streak = 0


def issue_ticket(purpose, service_type="regular"):
    
    #Create one valid ticket and return its number.
    
    global ticket_number

    if purpose not in PURPOSES or service_type not in SERVICE_TYPES:
        return None

    ticket = {
        "number": ticket_number,
        "purpose": purpose,
        "service_type": service_type,
        "status": "waiting"
    }

    tickets.append(ticket)
    waiting.append(ticket_number)
    ticket_number += 1
    return ticket["number"]


def issue_many(*requests):
    
    #Create many tickets. If one request is invalid, create none.
    
    for request in requests:
        if (len(request) != 2 or
                request[0] not in PURPOSES or
                request[1] not in SERVICE_TYPES):
            return []

    numbers = []
    for purpose, service_type in requests:
        numbers.append(issue_ticket(purpose, service_type))
    return numbers


def find_ticket(number):
    for ticket in tickets:
        if ticket["number"] == number:
            return ticket
    return None


def next_ticket(queue, streak):
    
    #Return the next eligible ticket.
    #After 2 priority tickets, a regular ticket goes first if one exists.
    #FIFO is kept within each service type.
    
    regular = None
    priority = None

    for ticket in queue:
        if ticket["status"] != "waiting":
            continue

        if ticket["service_type"] == "regular" and regular is None:
            regular = ticket

        if ticket["service_type"] == "priority" and priority is None:
            priority = ticket

    if streak >= 2 and regular is not None:
        return regular

    if priority is not None:
        return priority

    return regular


def call_next():
    
    #Call the next ticket to the first free counter.
    
    global priority_streak

    counter = None

    for i in range(2):
        if counters[i] is None:
            counter = i
            break

    if counter is None:
        return None

    queue = []
    for number in waiting:
        ticket = find_ticket(number)
        if ticket is not None:
            queue.append(ticket)

    ticket = next_ticket(queue, priority_streak)

    if ticket is None:
        return None

    ticket["status"] = "served"
    waiting.remove(ticket["number"])
    counters[counter] = ticket["number"]

    if ticket["service_type"] == "priority":
        priority_streak += 1
    else:
        priority_streak = 0

    return counter + 1, ticket["number"]


def complete_service(number):
    
    #Complete a ticket currently assigned to a counter.
    
    ticket = find_ticket(number)

    if ticket is None:
        return "not found"

    for i in range(2):
        if counters[i] == number:
            counters[i] = None
            completed.append(number)
            return "completed"

    if ticket["status"] == "waiting":
        return "waiting"

    return "already completed"


def cancel_ticket(number):
    
    #Cancel a waiting ticket.
    
    ticket = find_ticket(number)

    if ticket is None or ticket["status"] != "waiting":
        return False

    ticket["status"] = "cancelled"
    waiting.remove(number)
    return True


class WaitingTicketIterator:
    
    #Live iterator over tickets that are currently waiting.

    def __init__(self):
        self.position = 0

    def __iter__(self):
        return self

    def __next__(self):
        while self.position < len(tickets):
            ticket = tickets[self.position]
            self.position += 1

            if ticket["status"] == "waiting":
                return ticket

        raise StopIteration


def estimated_position(number):
    
    #Estimate a waiting ticket's future position by using a copy.
    #The real queue and counters are not changed.

    ticket = find_ticket(number)

    if ticket is None or ticket["status"] != "waiting":
        return None

    queue_copy = []
    for n in waiting:
        queue_copy.append(find_ticket(n).copy())

    streak = priority_streak
    position = 0

    while queue_copy:
        ticket = next_ticket(queue_copy, streak)

        if ticket is None:
            break

        position += 1

        if ticket["number"] == number:
            return position

        if ticket["service_type"] == "priority":
            streak += 1
        else:
            streak = 0

        queue_copy.remove(ticket)

    return None


def report(**kwargs):
    
    #Print a summary. Extra metadata does not affect queue decisions.
    
    counts = {"waiting": 0, "served": 0, "cancelled": 0}

    for ticket in tickets:
        counts[ticket["status"]] += 1

    print("\n===== SUMMARY REPORT =====")
    print("Waiting:", counts["waiting"])
    print("Served/Busy:", counts["served"])
    print("Cancelled:", counts["cancelled"])
    print("Free counters:", counters.count(None))

    for key, value in kwargs.items():
        print(key + ":", value)


def get_purpose():
    while True:
        value = input(
            "Purpose \n1. Enrollment \n2. Records \n3. Payment\n "
        ).strip().lower()

        if value in ["1", "enrollment"]:
            return "Enrollment"
        if value in ["2", "records"]:
            return "Records"
        if value in ["3", "payment"]:
            return "Payment"

        print("Invalid purpose. Please choose 1, 2, or 3.")


def get_service_type():
    while True:
        value = input(
            "Service \n1. Regular \n2. Priority): "
        ).strip().lower()

        if value in ["1", "regular"]:
            return "regular"
        if value in ["2", "priority"]:
            return "priority"

        print("Invalid service type. Please choose 1 or 2.")


def get_ticket_number():
    while True:
        value = input("Ticket number: ").strip()

        if value.isdigit() and int(value) > 0:
            return int(value)

        print("Invalid ticket number. Enter a positive number.")


def show_waiting():
    print("\n===== WAITING TICKETS =====")

    if not waiting:
        print("No waiting tickets.")
        return

    for i in range(len(waiting)):
        number = waiting[i]
        ticket = find_ticket(number)
        print(
            str(i + 1) + ". Ticket #" + str(number),
            "-", ticket["purpose"],
            "-", ticket["service_type"],
            "- Estimated position:", estimated_position(number)
        )


def show_counters():
    print("\n===== COUNTER STATUS =====")

    for i in range(2):
        if counters[i] is None:
            print("Counter", i + 1, ": FREE")
        else:
            print("Counter", i + 1, ": BUSY - Ticket #", counters[i])

    print("Completed history:", completed)


def main():
    while True:
        print("\n===== CAMPUS SERVICE QUEUE MANAGER =====")
        print("1. Issue ticket")
        print("2. Call next")
        print("3. Complete service")
        print("4. Cancel waiting ticket")
        print("5. Show waiting tickets")
        print("6. Show counter status and completed history")
        print("7. Summary report")
        print("8. Exit")

        choice = input("Choose 1-8: ").strip()

        if choice == "1":
            purpose = get_purpose()
            service_type = get_service_type()
            number = issue_ticket(purpose, service_type)
            print("Ticket #" + str(number) + " issued.")

        elif choice == "2":
            result = call_next()

            if result is None:
                if counters[0] is not None and counters[1] is not None:
                    print("Both counters are busy.")
                else:
                    print("No waiting tickets.")
            else:
                counter, number = result
                print(
                    "Ticket #" + str(number) +
                    " called to Counter " + str(counter) + "."
                )

        elif choice == "3":
            number = get_ticket_number()
            result = complete_service(number)

            if result == "completed":
                print("Service completed. Counter is now free.")
            elif result == "not found":
                print("Ticket does not exist.")
            elif result == "waiting":
                print("Ticket is still waiting and has not been called.")
            else:
                print("Ticket already completed.")

        elif choice == "4":
            number = get_ticket_number()

            if cancel_ticket(number):
                print("Ticket cancelled.")
            else:
                print("Ticket cannot be cancelled.")

        elif choice == "5":
            show_waiting()

        elif choice == "6":
            show_counters()

        elif choice == "7":
            report(activity="Campus Registrar")

        elif choice == "8":
            print("Program ended.")
            break

        else:
            print("Invalid choice. Please enter a number from 1 to 8.")


if __name__ == "__main__":
    main()
