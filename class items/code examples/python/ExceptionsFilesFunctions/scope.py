z = 20 # global

def scoper( x ):
    ''' scope rules '''
    y = 10

    '''
    Global x
        Look for x globally and allow read/write access
    Nonlocal x
        Essentially: read/write access the variable scope one level up
    '''

    def inner( x ):
        nonlocal y  # note: must be previously bound
        global z  # note: access anywhere
        x += 5  # local x (shadows)
        y += 5  # nonlocal y
        z += 5  # global z

    print( "scoper:", x, y, z )
    inner( x )
    print( "inner: ", x, y, z )


def scoper2( ):
    #print(y) #fails since y is not in outer block
    print( "global:", z )


scoper( 5 )
scoper2( )
