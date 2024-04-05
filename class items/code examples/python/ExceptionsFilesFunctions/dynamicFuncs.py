"""
Functions are first-class objects in Python:
--pass as function parameters
--return as function value
--assign to symbols
"""

def getFunc():
    answer = input( 'compute square or cube? ' )
    if answer == 'square':
        #legal to return a function
         def g( x ): #first class objects
            return x * x
         return g
    else:
        def f( x ):
            return x * x * x
        return f

# f(x) now computes square or cube, depending on user response
f = getFunc()   #legal to assign a function
print( '  x  f(x)' )
for x in range( 11 ):
    #legal to use as arugment to a parameter!
    print( '%3d %4d' % ( x, f( x) ) )
