#This is the same code from the pervious with modifications.
def readfile(filepath):
    inner_books = dict()
    file = open(filepath, "r")
    information_list = []
    current_type = ""
    publish_line = ""
    date_line = ""
    for line in file:
        if line == "Book\n" or line == "Journal\n":
            if information_list:
                if current_type == "Journal":
                    information_list.append(publish_line)
                    information_list.append(date_line)
                inner_books[information_list[0]] = information_list[1:]
                information_list.clear()
            current_type = line[:line.__len__() - 1]
        else:
            tag = line[:line.find(":")]
            tag_content = line[line.find(": ") + 2: line.__len__() - 1]
            if tag == "Author":
                first_name, last_name = tag_content.split(" ")
                tag_content = last_name + ", " + first_name
                information_list.append(tag_content)
            #here is the modified section
            #this is to handle Journal entries.
            elif current_type == "Journal":
                if tag == "Publisher":
                    publish_line = tag_content
                elif tag == "Date":
                    date_line = tag_content
                elif tag == "Volume":
                    publish_line += ":" + tag_content
                elif tag == "Number":
                    publish_line += "(" + tag_content + ")"
                else:
                    information_list.append(tag_content)
            else:
                information_list.append(tag_content)

    inner_books[information_list[0]] = information_list[1:]
    information_list.clear()
    return inner_books


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


if __name__ == "__main__":
    books = readfile("Step2Data.txt")
    user_key = input("Please enter a key")
    try:
        user_value = books[user_key]
        print_book(user_key, user_value)
    except KeyError:
        print("Key not found in database")
