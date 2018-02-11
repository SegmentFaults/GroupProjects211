#Process: Read all the data into one list.
#Follow up sorting 

masterList = []
resultList = []
output = ""
f = open('studentGrades.txt')
while 1:
    fullPersonInfo = f.readline()
    if not fullPersonInfo : break
    masterList.append(fullPersonInfo)
#create the averaging data
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

#create the output