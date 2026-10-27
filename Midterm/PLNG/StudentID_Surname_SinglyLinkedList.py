
class CustomerNode:
    def __init__(self, name):
        self.name = name
        self.next = None


class WaitingList:
    def __init__(self):
        self.head = None
        self.tail = None

    def add_customer(self, name):
        new_node = CustomerNode(name)

        if self.head is None:
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

        print("Customer added:", name)

    def serve_customer(self):
        if self.head is None:
            print("The waiting list is empty.")
            return None

        served_name = self.head.name
        self.head = self.head.next

        if self.head is None:
            self.tail = None

        print("Now serving:", served_name)
        return served_name

    def cancel_customer(self, name):
        if self.head is None:
            print("The waiting list is empty.")
            return False

        if self.head.name.lower() == name.lower():
            self.head = self.head.next

            if self.head is None:
                self.tail = None

            print("Customer cancelled:", name)
            return True

        previous_node = self.head
        current_node = self.head.next

        while current_node is not None:
            if current_node.name.lower() == name.lower():
                previous_node.next = current_node.next

                if current_node == self.tail:
                    self.tail = previous_node

                print("Customer cancelled:", current_node.name)
                return True

            previous_node = current_node
            current_node = current_node.next

        print("Customer not found:", name)
        return False

    def display_waiting(self):
        if self.head is None:
            print("Waiting list is empty.")
            return

        current_node = self.head
        print("Waiting list:", end=" ")

        while current_node is not None:
            print(current_node.name, end=" -> ")
            current_node = current_node.next

        print("None")

    def count_customers(self):
        total = 0
        current_node = self.head

        while current_node is not None:
            total += 1
            current_node = current_node.next

        print("Total customers waiting:", total)
        return total


def main():
    queue = WaitingList()

    while True:
        print("\n======= CUSTOMER WAITING LIST =======")
        print("1. Add customer")
        print("2. Serve customer")
        print("3. Cancel customer")
        print("4. Display waiting list")
        print("5. Count customers")
        print("0. Exit")

        option = input("Enter your choice: ").strip()

        match option:
            case "1":
                customer_name = input("Enter customer name: ").strip()

                if customer_name:
                    queue.add_customer(customer_name)
                else:
                    print("Customer name cannot be empty.")

            case "2":
                queue.serve_customer()

            case "3":
                customer_name = input("Enter customer name to cancel: ").strip()

                if customer_name:
                    queue.cancel_customer(customer_name)
                else:
                    print("Customer name cannot be empty.")

            case "4":
                queue.display_waiting()

            case "5":
                queue.count_customers()

            case "0":
                print("Exiting waiting list. Goodbye!")
                break

            case _:
                print("Invalid choice. Please try again.")


if __name__ == "__main__":
    main()
