# Michael Gentile, Nick Hutchison, Lucas Harris, Noah Dirig
# Dr. Alomari
# CSE 211 Section B
# This is Homework 1 for CSE 211. It evaluates student grades.
# This was created as a full group effort.


def determine_letter(current_score):
    if current_score >= 90:
        return "A"
    elif current_score >= 80:
        return "B"
    elif current_score >= 70:
        return "C"
    elif current_score >= 60:
        return "D"
    else:
        return "F"


# master_list is to collect the information
master_list = []
# result_list is to create the final output file and holds this
result_list = []
output = ""
in_file = open('studentGrades.txt')
# collect all the data in the file separated by spaces into list entries
while 1:
    full_person_info = in_file.readline()
    if not full_person_info: break
    master_list.append(full_person_info)
# create the averaging data
in_file.close()
for x in range(len(master_list)):
    # get the grade averages
    temp_list = master_list[x].split()
    counter = 0
    grade_average = 0.0
    grade_temp = 0.0
    # add the name to the results
    result_list.append(temp_list[0])
    # find averages of work
    for y in range(1, 4):
        grade_temp += float(temp_list[y])
    grade_average = grade_average + ((grade_temp * .2) / 3)
    grade_temp = 0.0
    for y in range(5, 9):
        grade_temp += float(temp_list[y])
    grade_average = grade_average + ((grade_temp * .2) / 5)
    for y in range(9, 11):
        grade_temp += float(temp_list[y])
    grade_average = grade_average + ((grade_temp * .2) / 2)
    # put the final grade right next to the name
    result_list.append(grade_average)

# start doing the output. Create a new file each time.
out_file = open("output.txt", "w")

for x in range(0, len(result_list), 2):
    # field of 20 right aligned for the name.
    out_file.write('{:>20}'.format(str(result_list[x])))
    score = float(result_list[x + 1])
    letter = determine_letter(score)
    # field of 5 right aligned to one decimal precision.
    out_file.write('{:>5}'.format("%.1f" % score))
    out_file.write('{:>2}'.format(str(letter)))
    out_file.write("\n")
