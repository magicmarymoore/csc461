# Python script that illustrates functional programming features of Python,
# including lambda (anonymous) functions, map(), filter(), and reduce().
#
# Alternatives include list comprehensions and generator expressions.


lst = list( range( 11 ) )

# named functions
print( "\nfunctions" )
def sqr( x ):
    return x*x
def even( x ):
    return x % 2 == 0

#key functions for functional programming are map, filter, and reduce
#map applies a function to all element in a collection
lstsqr = list( map( sqr, lst ) )
# filter pull a subset out of a collection based on some criteria (true\false function)
lstflt = list( filter( even, lstsqr ) )
print( "lst:", lst )
print( "map:", lstsqr )
print( "filter:", lstflt )
print()



'''
reduce “reduces” the list down to one element using a function.
Applies the function using the current STORED answer with the next item in the list
'''
from functools import reduce
print( "\nreduce by summation" )
print( "reduce lst:", reduce( lambda x,y: x + y, lst ), '==', sum( lst ) )
print( "reduce lstsqr:", reduce( lambda x,y: x + y, lstsqr ), '==', sum( lstsqr ) )
print( "reduce lstflt:", reduce( lambda x,y: x + y, lstflt ), '==', sum( lstflt ) )




# lambda expressions (aka anonymous functions)
# basic syntax: lambda paramList : body
print( "\nlambda expressions" )
lstsqr = list( map( lambda x: x * x, lst ) )
lstflt = list( filter( lambda x: x % 2 == 0, lstsqr ) )
print( "lst:", lst )
print( "map:", lstsqr )
print( "filter:", lstflt )


'''
tenets of functional programming

# no-side effects
# no void
# focus on operation
# chain mathematical ops
'''