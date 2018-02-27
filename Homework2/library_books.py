# Nick Hutchison, Michael Gentile, Lucas Harris, Noah Dirig
# Dr. Alomari
# Python 3.6.2

#param: the file and the file path that you would like to use. 
#required: the file must be in the ordered requested. 
#return: a dictionary filled with all of the books found within the file
def readfile(filepath):
    inner_books = dict()
    file = open(filepath, "r")
    information_list = []
    for line in file:
        if line == "Book\n":
            if information_list:
                inner_books[information_list[0]] = information_list[1:]
                information_list.clear()
        else:
            tag = line[:line.find(":")]
            tag_content = line[line.find(": ") + 2: line.__len__() - 1]
            if tag == "Author":
                first_name, last_name = tag_content.split(" ")
                tag_content = last_name + ", " + first_name
            information_list.append(tag_content)
    inner_books[information_list[0]] = information_list[1:]
    information_list.clear()
    return inner_books

#params: the key to the book and the actual value of the book
#returns: nothing
#function: to print out the information of the book. 
def print_book(key, value):
    print(key, "\t", end="")
    first = True
    for i in value:
        if first:
            first = False
            print(i, end="")
        else:
            print(", " + i, end="")
    print(". ")

#Main
#This reads in the predefined data and and then requests the user for input.
#if it is found it will print the book data
#otherwise, it will tell them it wasn't found and exit. 
books = readfile("Step1Data.txt")
user_key = input("Please enter a key")
try:
    user_value = books[user_key]
    print_book(user_key, user_value)
except KeyError:
    print("Key not found in database")


#
# for key, value in books.items():
#     print(key, "\t", end="")
#     for i in value:
#         print(i + ", ", end="")
#     print()

