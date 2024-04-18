class Book:
    def __init__(self, title, category, price, author, isbn, quantity):
        self.title = title
        self.category = category
        self.price = price
        self.author = author
        self.isbn = isbn
        self.quantity = quantity

    def sell(self, quantity):
        sold_quantity = self.quantity
        if self.quantity > quantity:
            self.quantity -= quantity
            sold_quantity = quantity
        else:
            self.quantity = 0
            print("Sold all {} we have in stock".format(self.title))
        return sold_quantity


class BookStore:
    def __init__(self):
        self.books = []
        self.total_price = 0

    def add_book(self, book):
        self.books.append(book)

    def search_by_title(self, title):
        for book in self.books:
            if book.title.lower() == title.lower():
                return book
        return None

    def search_by_category(self, category):
        category_books = []
        for book in self.books:
            if book.category.lower() == category.lower():
                category_books.append(book)
        return category_books

    def sell_book(self, title, quantity=1):
        book = self.search_by_title(title)
        if book:
            sold_quantity = book.sell(quantity)
            self.total_price += book.price * sold_quantity
        else:
            print(f"Sorry {title} doesn't exist in the bookstore.")


def print_books(books):
    for book in books:
        print(f"Title: {book.title}, Category: {book.category}, Price: {book.price}, Quantity: {book.quantity}")


book1 = Book(
     "Humble Pi: A Comedy of Maths Errors",
     "Humor",
     23.82,
     "Matt Parker",
     "978-0241360231", 2
  )
book2 = Book(
     "I Can't Make This Up: Life Lessons",
     "Humor",
     29.66, "Kevin Hart", "978-1501155567", 3
  )
book3 = Book(
     "You Can Be Funny and Mank People Laugh: No Fluff",
     "Humor",
     19.63, "Greg Dean", "978-1890905241", 5
  )
book4 = Book("Two Years On A Bike: From Vancouver to Patagonia", "adventure", 78.0,
             "Martijn Doolaard", "978-9082885408", 10)
book5 = Book("The Man's Guide to Women: Scientifically Proven Secrets from the Love Lab About What Women Really Want",
             "Relationship", 26.99, "John Gottman", "978-1623361846", 8)
book6 = Book("Getting the Love You Want: A Guide for Couples", "Relationship", 18.99,
             "Harville Hendrix", "978-0805087000", 1)

bookBless = BookStore()
bookBless.add_book(book1)
bookBless.add_book(book2)
bookBless.add_book(book3)
bookBless.add_book(book4)
bookBless.add_book(book5)
bookBless.add_book(book6)

print("Humor Books:")
print_books(bookBless.search_by_category("Humor"))

print(f"Current total earnings: {bookBless.total_price}")
title = "The Man's Guide to Women: Scientifically Proven Secrets from the Love Lab About What Women Really Want"
bookBless.sell_book(title, 3)
print(f"Current total earnings: {bookBless.total_price}")