# using "from" avoids need to write "math.sqrt"
from math import sqrt

# C++/C style formatting
i = int( input( "input a integer (i): " ) )
print( ' OLD style output formatting ' )
print( '  i  sqrt(i)' )
print( '%3d %7.2f' % (i, sqrt( i )) )



# python's intended improvement
print( ' NEW style output formatting ' )
print( '  i  sqrt(i)' )
x = '{:3d} {:7.2f}'.format( i, sqrt( i ) )
print( x )



print( ' Also able to reference location' )
print( '{1:3d} {0:7.2f}'.format( sqrt( i ), i ) )


#newest version (syntactic sugar)
print( ' mark string with a f' )
print( f'{i:3d} {sqrt( i ):7.2f}')
