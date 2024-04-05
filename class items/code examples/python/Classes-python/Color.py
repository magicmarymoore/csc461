
class Color( object ):
    '''An RGB color, with red, green and blue components.'''

    def __init__( self, r=0, g=0, b=0 ):
        '''A new color with red value r, green value g, and blue value b.  
        All components are integers in the range 0-255.'''
        self._red = r
        self._green = g
        self._blue = b

    # str(myColor)
    def __str__( self ):
        '''Return a string representation of this Color in the form
           Color( red, green, blue ).'''
        return 'Color( %s, %s, %s )' % (self._red, self._green, self._blue)

    # color1 + color2
    def __add__( self, other_color ):
        '''Return a new Color made from adding the red, green, and blue
        components of this Color to Color other_color's components.  If the
        sum is greater than 255, then the color is set to 255.'''
        return Color( min( self._red + other_color.red, 255 ),
                      min( self._green + other_color.green, 255 ),
                      min( self._blue + other_color.blue, 255 ) )

    def __sub__( self, other_color ):
        '''Return a new Color made from subtracting the red, green, and blue
        components of this Color from Color other_color's components.  If
        the difference is less than 0, then the color is set to 0.'''
        return Color( max( self._red - other_color.red, 0 ),
                      max( self._green - other_color.green, 0 ),
                      max( self._blue - other_color.blue, 0 ) )

    def __eq__( self, other_color ):
        '''Return True if this Color's components are equal to Color
        other_color's components.'''
        return self._red == other_color._red and \
               self._green == other_color._green and \
               self._blue == other_color._blue

    def lightness( self ):
        '''Calculate the lightness of this color.'''
        strongest = max( self._red, self._green, self._blue )
        weakest = min( self._red, self._green, self._blue )
        return 0.5 * (strongest + weakest) / 255

    def gray( self ):
        '''Calculate the grayscale value of this color.'''
        return int( 0.3 * self._red + 0.6 * self._green + 0.1 * self._blue + 0.5 )

    def intensity( self ):
        '''Calculate the intensity of this color.'''
        return (self._red + self._green + self._blue) / 3

    def saturation( self ):

        '''Calculate the saturation of this color.'''
        i = self.intensity( )
        if i > 0:
            return 1 - min( self._red, self._green, self._blue ) / i
        else:
            return 0.0


# derive from class format
# class name (parent)
class AlphaColor( Color ):
    def __init__( self, r=0, g=0, b=0, a=255 ):
        #Color.__init__(self, r, g, b) # works with multiple inheritance
        super( ).__init__( r, g, b )  # works with single inheritance (sort of on multiple)
        self._alpha = a

    def __str__( self ):
        '''Return a string representation of this Color in the form
           Color( red, green, blue ).'''
        # result = Color.__str__(self) # works with multiple inheritance
        result = super( ).__str__( )  # works with single inheritance (sort of on multiple)
        result += " Alpha: " + str( self._alpha )
        return result


# typical main() function pattern
# test Color class
if __name__ == '__main__':
    # some predefined colors
    Black = Color( 0, 0, 0 )
    White = Color( 255, 255, 255 )
    Red = Color( 255, 0, 0 )
    Green = Color( 0, 255, 0 )
    Blue = Color( 0, 0, 255 )
    Cyan = Color( 0, 255, 255 )
    Yellow = Color( 255, 255, 0 )
    Magenta = Color( 255, 0, 255 )
    Orange = Color( 255, 128, 64 )
    TranslucentOrange = AlphaColor( 255, 128, 64, 128 )
    TranslucentBlue = AlphaColor( 0, 0, 255, 55 )

    print( Black.saturation( ) )
    print( "Orange =", Orange )
    print( "Orange lightness = %.3f" % Orange.lightness( ) )
    print( "Orange saturation = %.3f" % Orange.saturation( ) )
    print( "Orange == Magenta:", Orange == Magenta )
    print( "Orange == Color( 255, 128, 64 ):", AlphaColor( 255, 128, 64, 0 ) == Orange)

    colorList = [ Black, White, Red, Green, Blue, Cyan, Yellow, Magenta, Orange, \
                  TranslucentOrange, TranslucentBlue ]

    print( "\nList of Colors:" )
    for color in colorList:
        print( color )

'''
QUESTION:
Extend Color to make a greyscale class (RGB will all be one value). 
Make a constructor and override the string function to output a 
single value in the form: Grey( val )

'''

'''Answer
class GreyColor( Color ):
    def __init__( self, g = 0 ):
        Color.__init__(self, g, g, g)
    def __str__( self ):
        return 'Grey( %s )' % (self._red)
g = GreyColor(100)
print(g)
'''
