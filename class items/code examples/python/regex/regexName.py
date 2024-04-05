import re

print( 'regex methods' )

namelist = ['Lennon, John  Winston', 'McCartney , James Paul',
           'Harrison,George', 'Starr-Starkey, Ringo']
'''
Question:
What would the pattern be for a persons first, middle (optional), last name?
The end goal is to print these in "FirstName MiddleName LastName" format.
'''


pat = r'([\w-]+)\s*,\s*(\w+)\s*(\w+)?'


print( 'pattern:', pat )
print( 'strings:', namelist, '\n' )

# get all matched groups as a list
for name in namelist:
    print("-----------------------------------------------------")
    result = re.search( pat, name )
    if  result == None:
        print("Nothing matched")
    else:
        # groups in search or match can be pulled independently
        # E.g. have (…) in the pattern
        match = result.groups()
        print( name, "=>", match )
        if match:
            last = "NONE"
            first = "NONE"
            middle = "NONE"
            if(len(match) > 0):
                last = match[0]
            if (len(match) > 1):
                first = match[1]
            if (len(match) > 2):
                middle = match[2]

            if middle:
                print( name, "=>", first, middle, last )
            else:
                print( name, "=>", first, last )

















#some answers
pat = r'([a-zA-Z-]+)\s*,\s*([a-zA-Z-]+)\s*([a-zA-Z-]*)'
pat = r'\s*([-A-Za-z]+)\s*,\s*([-A-Za-z]+)\s*([-A-Za-z]+)?'