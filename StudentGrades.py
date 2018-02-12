#Process: Read all the data into one list.
#Follow up sorting

master_list = []
result_list = []
output = ""
file = open('studentGrades.txt')
while 1:
    full_person_info = file.readline()
    if not full_person_info : break
    master_list.append(full_person_info)
#create the averaging data
file.close()
for x in range(len(master_list)):
    #first is a string
    #followed by 3 quiz scores, followed by  5 HW and 2 exams
    #weighted as follows
    #20% then 30% then 50%
    temp_list = master_list[x].split()
    counter = 0
    grade_average = 0.0
    grade_temp = 0.0
    result_list.append(temp_list[0])
    for y in range(1, 4):
        grade_temp+=float(temp_list[y])
    grade_average = grade_average + ((grade_temp *.2)/3)
    grade_temp = 0.0
    for y in range(5, 9):
        grade_temp+=float(temp_list[y])
    grade_average = grade_average + ((grade_temp *.2)/5)
    for y in range(9, 11):
        grade_temp+=float(temp_list[y])
    grade_average = grade_average + ((grade_temp *.2)/2)
    result_list.append(grade_average)
print result_list

file=open("output.txt", "w")
for x in range(0,len(result_list),2):
    file.write('{:>20}'.format(str(result_list[x])))
    score = float(result_list[x+1])
    file.write('{:>5}'.format("%.1f" % score))
    file.write("\n")
#create the output
