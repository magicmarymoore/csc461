import sys
from time import gmtime, strftime

"""
Similar to C++ in ease
The basics:

open(), close(), read(), write() 
"""

filename = "bunyip.txt"

# open input file for reading
try:
    fin = open( filename )
except IOError:
    print( "Unable to open file:", filename )
    sys.exit()

# open the output file for writing
fout = open( 'output.txt', 'w' )

# Also has 'r', 'a' options
# ...and more:
# https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files
#OR!!!
#help( open )


'''
General read options
ifp.read() - entire file contents 
ifp.readline() - one line of file 
ifp.readlines() - all lines, in an array 
for line in ifp:   #streams in the lines one at a time
'''

# process the input file one line at a time,
# echoing each line to stdout and the output file
limit = 0
for line in fin:
    if limit < 10:
        print( line, end = '' )
        fout.write( line )
    limit = limit +1

# always a good idea to clean up by closing file handles
fin.close()
fout.close()


#if you want EVERYTHING in a array
print("\n\nIf you want EVERYTHING in an random access array-------------------------")
fin = open( filename )
line = fin.readlines()
for i in range(0, 5):
    print(line[i])
fin.close()



# shorter alternative: read in entire file into a string, and copy to output file
fin = open( filename )
fout = open( 'output2.txt', 'w' )
f = fin.read()
fout.write( f )

# always a good idea to clean up by closing file handles
fin.close()
fout.close()

# can read one line at a time
print("\n\nIf you want it one line at a time-------------------------")
fin = open( filename )
line = fin.readline()
line = fin.readline()
line = fin.readline()
line = fin.readline(20) #can limit to some number of chars..e.g. 20 will only print up to THE in bunyip.txt
print("partial 4th line: " + line)




# more control on how many get added
# in that you can limit to end at the first \n after a X number of char
lines = fin.readlines(200)
print("\n\n\narray of lines: ------------------------")
print(str(lines))
fin.close()

#Unlike C++, readline() and readlines() leave the new lines inside the array
fin = open("bunyip.txt")
lines = fin.readlines()
print('\n\n\nto remove excess whitespace ------------------------')
for i, v in enumerate(lines):
    lines[i] = v.strip() # remove before and after whitespace
    #lines[ i ] = v.lstrip( )
    #lines[ i ] = v.rstrip( )
    #lines[ i ] = v.strip(" T") # only strip when you see the argument

print("array of lines: " + str(lines))
fin.close()



# best method to open
# append to a log file the current time
with open("log.txt", "a") as ifp:
    ifp.write("Opened at: " + strftime("%Y-%m-%d %H:%M:%S", gmtime()) + "\n")


'''
QUESTION:
Open a file named “file.txt” and print out the 3 lines to a file named “out.txt”
'''




#ANSWER
fin = open( "file.txt" )
fout = open( 'out.txt', 'w' )
for i in range(0, 3):
    line = fin.readline()
    fout.write(line)
fout.close() #could have used fout.flush() too
