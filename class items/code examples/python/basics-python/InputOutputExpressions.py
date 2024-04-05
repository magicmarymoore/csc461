# input(prompt) gets console input, but ALWAYS returns a string
a = input( "Input integer a: " )  # a is a string (line!)
a = int( a )  # no other choice!
print( "Input float b: ", end='' )  # end? Named parameters! More on this later!
b = float( input( ) )
print( "Input string c: ", end='' )
c = input( )

# no keyword argument just means append, then no str() is needed
print( "Floating division of a / b using print()'s  concatenation: ", a / b )
print( "Concatenation of c using print()'s  separator parameter:", c, sep="--" )  # named parameters!
print( "Example print parameters" )
print( "AA", "BB", end="CC", sep="_" )  # more named parameters!

'''
NOTE: Unlike C++, 
2 2 2 
is NOT equivalent to 
2
2
2
When reading in. python ONLY reads in the entire line. split() will be your friend
'''
print( )
a = input( "Input integers: " )
print( a.split(  ) )

'''
QUESTION
How do you read in (and print) the following data types
int float text 
Such that the input of "2 2.5 text" would print out
   5.0
   texttext
Where 
1) 5 is the first two numbers multiplied together
2) The last line is the third word printed the first number, number of times







Answer:
a = input("Input integers: " )
a = a.split()
i = int(a[0])
f = float(a[1])
print(i*f)
print(a[2]*i)

'''
