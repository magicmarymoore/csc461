'''
Classes…are classes

Some _structure_ is very different
--ALL instance methods are effectively “virtual” Like Java
--Attributes created as needed!
----Good coding style has these in the constructor
----(trust me, I’ve erred on this before and…yikes that was a hard bug to find!)

'''


class Basic:
    # class/static variable ...NOT INSTANCE
    # Since C++/Java put their member variables here,
    # it is the second most common error I see
    CLASS_VAR = 3 # public const in C++, by convention

    # init() is the constructor
    def __init__( self, y=0 ):  # self -->this
        # ALL instance variables should go here
        self.__x = 0  # double _ means private-ish ...not using __ is the MOST common error I see
        self._y = y  # single _ means protected BY CONVENTION ONLY
        self.pub = 3  # no _ means public

    # no implicit “this” or self in python’s case
    def method1( self ):
        self.z = 3  # not a good idea, but legal
        print( "in method1: " + str( self.__x ) + " " + str( self._y ) )

    def method2( self ):
        print( "in method2: " + str( self.z ) )
        self.method3( )  # access other methods with self as well

    def method3( self ):
        print( "in method3 (does nothing)" )


    # Class\static (e.g. Math class)---------------------------------------------------------------------
    @classmethod  # technically optional
    def methodClass( cls ): #cls --> filled in with Basic
        print( "in class method. cls is '" + cls.__name__ + "'" )

    # example without the annotation
    def methodClassNoAnnotation( cls=None):
        print( "in class method with no annotation " )

    @staticmethod
    def methodStatic( ):
        print( "in static method " )


if __name__ == '__main__':
    temp = Basic( )
    # print(temp.__x) #fails because it is private
    print( "Private...not: ", temp._Basic__x )  # works, but you should NEVER do this!
    print( "Protected...not: ", temp._y )
    print( "Public...yes: ", temp.pub )
    temp2 = Basic( 2 )

    temp.method1( )
    temp2.method1( )
    temp.method2( )
    temp2.method2( )

    # careful on variable creation!
    temp3 = Basic( 3 )
    #temp3.method1()

    # want to see everything currently supported? Formally: reflection or introspection
    # Can check if there is an attribute with
    print( "\n\n\ntemp3 has attribute Z yet: ", hasattr( temp3, "z" ) )
    # or check everything with
    print( "What does it have: ", temp3.__dict__ )
    # temp3.method2()    #will crash due to trying to use Z before initialization

    # class\static variables\methods-----------------------------------------
    print( "\n\n\nClass var: ", Basic.CLASS_VAR  )  # access to class variables look the same
    # Basic.method3() #will fail...not a class method
    Basic.methodClass( )
    Basic.methodClassNoAnnotation( )
    Basic.methodStatic( )  # static function



    '''
QUESTION:
Make a Square class with a class variable for updatable default sized squares 
(start with length = 1), a constructor with a given size length, 
a method to print the area, and a method to create a default square instance.

'''






#ANSWER
class Square:
    defaultSide = 1
    def __init__(self, len):
        self.__len = len

    def area(self):
        print(self.__len**2)

    @staticmethod
    def makeDefault():
        return Square(Square.defaultSide)

s = Square(2)
s.area()
s2 = Square.makeDefault()
s2.area()
Square.defaultSide = 3
s3 = Square.makeDefault()
s3.area()
