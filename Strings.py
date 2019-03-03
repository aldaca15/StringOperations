# In this example we are going to cover examples for String operations in python

Letters="ABCDEFGHIJK"
Letters[0:4]

# Substring creation by using slice object
# contains indices (0, 1, 2, 3)
sObject = slice(4)

print(Letters[sObject])

# changing the content by assignment
Letters="WXYZ"
print(Letters)

# print only YZ
print(Letters[2:])
