class Book:
    def __init__(self, title: str, author: str, price: float):
        self.title = title
        self.author = author
        self.price = price

    def __str__(self) -> str:
        return f"Title: {self.title} | Author: {self.author}\nPrice: PHP {self.price:.2f}\n"


class EBook(Book):
    def __init__(self, title: str, author: str, price: float, file_size_mb: int):
        super().__init__(title, author, price)
        self.file_size_mb = file_size_mb

    def __str__(self) -> str:
        return f"Title: {self.title} | Author: {self.author}\nPrice: PHP {self.price:.2f} | File size: {self.file_size_mb}MB\n"


def main():
    books = [
        Book("Don Quixote", "Miguel de Cervantes", 200.69),
        EBook("Bible", "Unknown", 450.69, 100),
        EBook("ErlKing", "Johann Wolfgang von Goethe", 100.69, 64) 
    ]
    
    for b in books:
        print(b)


if __name__ == "__main__":
    main()

class pro:
    def __init__(self, product: str, price: float, warranty: str):
        self.product = product
        self.price = price 
        self.warranty = warranty

    def __str__(self) -> str:
        return f"Product: {self.product}\nPrice: PHP {self.price:.2f}\nWarranty: {self.warranty} months\n"
    
class epro(pro):
    def __init__(self, product: str, price: float, warranty: str, ram: str, Storage: int):
        super().__init__(product, price, warranty)
        self.ram = ram 
        self.Storage = Storage

    def __str__(self) -> str:
        return f"Product: {self.product}\nPrice: PHP {self.price:.2f}\nWarranty: {self.warranty} months\nRAM: {self.ram}GB\nStorage: {self.Storage}GB"
    
def main():
    lap = [ 
        pro("Lenovo", 40000.00, "24"),
        epro("Asus", 55000.00, "12", "16", 512)
    ]

    for p in lap:
        print(p)

if __name__ == "__main__":
    main()
