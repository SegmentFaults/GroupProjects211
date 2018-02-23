def readfile(filepath):
    inner_books = dict()
    file = open(filepath, "r")
    information_list = []
    current_type = ""
    publish_line = ""
    date_line = ""
    conference_line = ""
    for line in file:
        if line == "Book\n" or line == "Journal\n" or line == "Conference\n":
            if information_list:
                if current_type == "Journal":
                    information_list.append(publish_line)
                    information_list.append(date_line)
                elif current_type == "Conference":
                    information_list.append(conference_line)
                    information_list.append(date_line)
                inner_books[information_list[0]] = information_list[1:]
                information_list.clear()
            current_type = line[:line.__len__() - 1]
        else:
            tag = line[:line.find(":")]
            tag_content = line[line.find(": ") + 2: line.__len__() - 1]
            if tag == "Author":
                names_list = tag_content.split(" ")
                first_name, last_name = names_list[0], names_list[1]
                if "," in tag_content:
                    result = last_name[:last_name.__len__() - 1] + ", " + first_name
                    result += tag_content[tag_content.find(","):]
                else:
                    result = last_name + ", " + first_name

                information_list.append(result)
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
            elif current_type == "Conference":
                if tag == "Conference":
                    conference_line = "in Proceedings of " + tag_content
                elif tag == "Date":
                    date_line = tag_content[:tag_content.__len__() - 1]
                elif tag == "Location":
                    conference_line += ", " + tag_content
                elif tag == "Pages":
                    date_line += ", " + tag_content
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
    books = readfile("Step3Data.txt")
    user_key = input("Please enter a key")
    try:
        user_value = books[user_key]
        print_book(user_key, user_value)
    except KeyError:
        print("Key not found in database")
