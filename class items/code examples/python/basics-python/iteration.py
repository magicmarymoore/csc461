from math import sqrt

print( "normal while" )
while True:
    cmd = input( "Enter a command [abq]: " )
    if cmd == 'a':
        print( "You selected menu option a!" )
    elif cmd == 'b':
        print( "You selected menu option b!" )
    elif cmd == 'q':
        break
    else:
        print( 'Invalid command, please try again!' )




# ===========================================================
print( "\n\nwhile with else" )
cmd = 'a'
while cmd != 'q':
    cmd = input( "Enter a command [abxq]: " )
    if cmd == 'a':
        print( "You selected menu option a!" )
    elif cmd == 'b':
        print( "You selected menu option b!" )
    elif cmd == 'x':
        print( "Break! no while-else!" )
        break
    elif cmd == 'q':
        cmd = 'q'
    else:
        print( 'Invalid command, please try again!' )
else: #executes on normal termination,  (not when breaking out of loop)
    print( 'finished loop' )

print( )





# ===========================================================

print( 'For loop' ) #for-each, technically
print( '  i  sqrt(i)' )
for i in range( 0, 10):
    print( '%3d %7.2f' % (i, sqrt( i )) )

print( )




# ===========================================================

print( 'For loop, with steps' )
print( '  i  sqrt(i)' )
# does not permit floats, the following would fail: for i in range( 0, 10, 2.2 )
for i in range( 0, 10, 2 ):
    print( '%3d %7.2f' % (i, sqrt( i )) )

print( )





# ===========================================================

print( 'For loop, with else' )
n = int( input( "Input iterations: " ) )
for i in range( 1, n + 1 ):
    print( i )
    if i > 10: break
else:
    print( "normal loop exit" )
print( "out of loop" )

print( )




# ===========================================================

# for works in a list, array, dictionary, etc
# …ANY collection really
print( '\nFor each loop' )
print( '  i  sqrt(i)' )
for i in [ 1, 2, 4, 6, 8, 20 ]:
    print( '%3d %7.2f' % (i, sqrt( i )) )

print( '\nFor each loop with index' )
for idx, val in enumerate( [ 1, 2, "two", 6, 8, 20 ] ):
    print( idx, val )


#will fail since range only accepts ints
#for i in range (0, 15, 0.5):
#    print(i)





# Question:
# Print out 0, 0.2, 0.4, …10 with their indices,
# in a for loop without typing in the entire array
# answer below





print( 'Range only permits ints. You have to do the conversions for floats' )
start = 0
end = 10
step = 0.2
for i, v in enumerate( range( start, int( end / step ) + 1 ) ):
    print( i, v * step )
