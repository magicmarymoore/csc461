from Classes.Color import Color
from abc import ABC, abstractmethod


# make the class abstract with ABC
class Sphere( ABC ):
    def __init__( self, radius=1 ):
        self._radius = radius

    @abstractmethod  # make this method abstract
    def __str__( self ):
        return "Radius: " + str( self._radius )


# multiple inheritance format
# class name (parentClassList)
class ColoredSphere( Sphere, Color ):
    def __init__( self, radius=1, r=0, g=0, b=0 ):
        Sphere.__init__( self, radius )
        Color.__init__( self, r, g, b )
        # super().__init__() # this would find the first Class that has __init__, and stop

    # MUST have this now
    def __str__( self ):
        return Sphere.__str__( self ) + " " + Color.__str__( self )


if __name__ == '__main__':
    sphere = ColoredSphere( )
    sphere2 = ColoredSphere( 2, 125, 3, 20 )

    print( sphere )
    print( sphere2 )
