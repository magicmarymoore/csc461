x = 2  # x is a integer
x = 2.23  # x is now a  float
d, e = 10, 11  # 0+ return variables now permitted!
x = 'test'  # X is now a string!
b = 't'  # b is STILL a string! There is no primitive  char type
c = "'test'"  # X now has ' embedded in the string
print( x, b, c, d, e )

# Tradeoff: flexibility vs. reliability (type checking) and efficiency


'''
QUESTION
What is the code to assign the values “text” (including the “”) 
and 2 to the variable names a and b, respectively, in one line?





Answer
a, b = '"text"', 2
'''


# no built in arrays, instead uses lists
lst = [ 1, 2, 3, "three" ]
print( 'original [] list:', lst )

lst = range( 10, 100, 10 )  # ranges give us a set of values in a range(start, exclusive_end, step)
print( 'range list:', lst )
lst = list( lst ) #casting --> datatype( from )
print( 'casted range list:', lst )
print( 'indexing:', lst[ 0 ] )

# append, two ways
lst.append( 110 ) # expressive
lst += [ 120 ]
print( 'append 110 and 120:', lst )

# if you want to resize
lst = [ 1 ] * 5
print( 'resize and initialized:', lst )





x = 2 + 2  # normal math operator work the same as Java and C++
x += 2  # as do compound
# x++     # no ++ or -- operators
x = 2 ** 3  # exponent
x = 3 / 5  # floating point division
x = 3 // 5  # integer division
b = 2 == 2  # as do boolean operations
c = 2 == 2 or 2 == 3  # conditional use the word instead
d = 2 == 2 and 2 == 3  # conditional use the word instead
e = 2 < 3 < 4  # this works in the algebra sense
print( x, b, c, d, e )
# careful: |, ~, ^, &	are bitwise ops


# orthogonality!!!
x = "test"  # operations work on strings too
x += "test"
c = x * 2
# c = c + 2  # will not work as python will not cast an int to string
c = c + str( 2 )  # casting similar to C++, but function form ONLY
print( x, c )
