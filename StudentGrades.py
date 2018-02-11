#Process: Read all the data into one list.
#Follow up sorting 

masterList = []
resultList = []
output = ""
file = open('studentGrades.txt')
while 1:
    fullPersonInfo = file.readline()
    if not fullPersonInfo : break
    masterList.append(fullPersonInfo)
#create the averaging data
file.close()
for x in range(len(masterList)):
    #first is a string
    #followed by 3 quiz scores, followed by  5 HW and 2 exams
    #weighted as follows
    #20% then 30% then 50%
    tempList = masterList[x].split()
    counter = 0
    gradeAverage = 0.0
    gradeTemp = 0.0
    resultList.append(tempList[0])
    for y in range(1, 4):
        gradeTemp+=float(tempList[y])
    gradeAverage = gradeAverage + ((gradeTemp *.2)/3)
    gradeTemp = 0.0
    for y in range(5, 9):
        gradeTemp+=float(tempList[y])
    gradeAverage = gradeAverage + ((gradeTemp *.2)/5)
    for y in range(9, 11):
        gradeTemp+=float(tempList[y])
    gradeAverage = gradeAverage + ((gradeTemp *.2)/2)
    resultList.append(gradeAverage)
print resultList

file=open("output.txt", "w")
for x in range(0,len(resultList),2):
    file.write('{:>20}'.format(str(resultList[x])))
    score = float(resultList[x+1])
    file.write('{:>5}'.format("%.1f" % score))
    file.write("\n")
#create the output