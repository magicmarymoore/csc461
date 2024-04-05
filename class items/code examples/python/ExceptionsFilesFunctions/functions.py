print( "Normal function with x = 3: ", end="" )


def sqr_v1( x ):
    """
    Normal squared function
    :param x: number to square
    :type x: number
    :return: the square of a number
    :rtype: number
    """

    return x * x


x = 2  # x will never change in a function, python is strictly pass by value/sharing
print( sqr_v1( x ), end=" " )
print( x )

# =================================================================================
print( "\n\nDefault function with x set to 2 in the parameter: ", end="" )


def sqr_v2( x=2 ):
    """
    Default parameter squared function
    :param x: number to square
    :type x: number
    :return: the square of a number
    :rtype: number
    """
    return x * x


print( sqr_v2() )
print( sqr_v2( 2 ) )
print()

# =================================================================================
print( "\n\nFunction with yield with x = 2:" )


def sqr_v3():
    """
    generator squared function that squared the past value each time
    :return:  x^2 power starting at x = 2
    :rtype:
    """
    x = 2
    while True:
        x = x * x
        # actually pauses the execution of a function at the
        # yield until the function is called again!
        yield x  # optional return


sqr = sqr_v3()
print( sqr )
print( next( sqr ) )
print( next( sqr ) )
print( next( sqr ) )
print()


# What will the following output?
def interpolate( m, y, start, end ):
    while start < end:
        yield m * start + y
        start = start + 1


t = interpolate( 2, 4, 0, 4 )
print( next( t ) )
print( next( t ) )
print( next( t ) )
print( next( t ) )
print()

"""
Answer:
4
6
8
10
"""


# another example (Blum-Blum-Shub random numbers
# without yeild
def bbs_rand( x=3 ):
    M = 11 * 23
    return x ** 2 % M


print( "\n\nBBS without yeild-----" )
start = bbs_rand()
print( start )
start = bbs_rand( start )
print( start )
start = bbs_rand( start )
print( start )
start = bbs_rand( start )
print( start )
start = bbs_rand( start )
print( start )
print()


# after
def bbs_rand_yeild():
    x = 3
    M = 11 * 23
    while True:
        x = x ** 2 % M
        yield x


print( "BBS WITH yeild-----" )
start = bbs_rand_yeild()
print( next( start ) )
print( next( start ) )
print( next( start ) )
print( next( start ) )
print( next( start ) )
print()

# =================================================================================
print( "\n\nFunction with named parameter usage:" )


def sqr_v4( start=0, end=5, step=1 ):
    """
    a function the squares the value in the range given, with the step size given
    :param start: first number to square
    :type start: integer
    :param end: last number to square (exclusive)
    :type end: integer
    :param step: step size between start and end
    :type step: integer
    :return: none
    """
    for i in range( start, end, step ):
        print( i * i )


print( "-----" )
sqr_v4( step=2 )
print( "-----" )
sqr_v4( 2, step=3 )
print( "-----" )
# sqr_v4( step = 3, 2 ) # as soon as a use a named parameter, the rest need to be named
print( "-----" )
sqr_v4( step=5, end=20 )
print()

# =================================================================================
print( "\n\nYou can grab the functions comments with help:" )
help( sqr_v1 )
