'''
Python is pass by value...so same parameter passing problems as java!
'''


class MemCell( object ):
    '''Memcell class - stores an object'''

    def __init__( self, value=0 ):
        '''constructor'''
        self.__value = value


    def __call__( self ):
        '''class call method...aka the () operator'''
        return self.__value

    # comment out str() method to show class call method better
    def __str__( self ):
        '''Convert MemCell to str for printing'''
        return str( self.__value )


    def __eq__( self, mc ):
        '''overload the equality op =='''
        return self.__value == mc.__value


    def __add__( self, mc ):
        '''overload the addition op + (also +=)'''
        return MemCell( self.__value + mc.__value )


# typical main() function pattern
# test MemCell class
if __name__ == '__main__':
    x = 2
    mc1 = MemCell( 1 )
    mc2 = MemCell( 2 )
    print( "mc1 object =", mc1 )  # str() method would print value instead of object
    print( "mc2 object =", mc2 )
    print( "\nmc1() = ", mc1( ), ", mc2() = ", mc2( ), sep='' )  # call() method prints value
    print( "mc1 == mc2: ", mc1 == mc2 )

    mc3 = mc1 + mc2
    print( "\nmc3 = mc1 + mc2\nmc3 object =", mc3 )
    print( "\nmc1() = ", mc1( ), ", mc2() = ", mc2( ), ", mc3() = ", mc3( ), sep='' )
    mc1 += mc2
    print( "after mc1 += mc2\nmc1 New object =", mc1 )
    print( "after mc1 += mc2\nmc1()  =", mc1 )
