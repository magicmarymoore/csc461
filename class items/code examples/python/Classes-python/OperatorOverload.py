'''
   Want to overwrite an operator? These map to __Name__(self)
   There is a large set of these
      str(), (), +, -, *, /, >, <, ==, >=
      ...basically ALL of them
   Docs: https://docs.python.org/3/reference/datamodel.html#special-method-names
'''


class Ops:
    def __init__( self, x, y ):
        self.__x = x
        self.__y = y

    # overloads the ==
    def __eq__( self, other ):
        return self.__x == other.__x and self.__y == other.__y

    # overloads str()
    def __str__( self ):
        return "( " + str(self.__x) + ", " + str(self.__y) + " )"

    # MANY of these. Try typing "def __"





if __name__ == '__main__':
    a = Ops( 1, 2 )
    b = Ops( 1, 2 )
    c = Ops( 2, 3 )

    print( "a: ", a )
    print( "b: ", b )
    print( "c: ", c )

    print( "a==b: ", a == b )
    print( "a==c: ", a == c )
