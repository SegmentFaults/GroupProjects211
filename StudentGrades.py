#Michael Gentile, Nick Hutchison, Lucas Harris, Noah Dirig
#Dr. Alomari
#CSE 211 Section B
#This is Homework 1 for CSE 211. It evaluates student grades.
#This was created as a full group effort.


#master_list is to collect the information
master_list = []
#result_list is to create the final output file and holds this
result_list = []
output = ""
file = open('studentGrades.txt')
#collect all the data in the file seperated by spaces into list entries
while 1:
    full_person_info = file.readline()
    if not full_person_info : break
    master_list.append(full_person_info)
#create the averaging data
file.close()
for x in range(len(master_list)):
    #get the grade averages
    temp_list = master_list[x].split()
    counter = 0
    grade_average = 0.0
    grade_temp = 0.0
    #add the name to the results
    result_list.append(temp_list[0])
    #find averages of work
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
    #put the final grade right next to the name
    result_list.append(grade_average)

#start doing the output. Create a new file each time.
file=open("output.txt", "w")
for x in range(0,len(result_list),2):
    #field of 20 right aligned for the name.
    file.write('{:>20}'.format(str(result_list[x])))
    score = float(result_list[x+1])
    #field of 5 right aligned to one decimal precision.
    file.write('{:>5}'.format("%.1f" % score))
    file.write("\n")
