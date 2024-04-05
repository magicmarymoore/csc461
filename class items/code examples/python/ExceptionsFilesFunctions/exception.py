try:
    x = int( input( "X: " ) )
    y = int( input( "Y: " ) )

    result = x / y
    if result == 3:
        # Can throw/cause an exception with “raise”
        raise LookupError

except ZeroDivisionError:  # specific to general again!
    print( "division by zero!" )
# except:    # catches everything, but no info...
#    print("some error occurred!")
except Exception as e:  # get more info
    print( type( e ) )
else:  # executed if no exception
    print( "result is", result )
finally:  # always executed
    print( "executing finally clause" )


print( "returning from divide" )




'''
Some common exceptions you may want:
LookupError
--when a key or index used on a mapping or sequence is invalid
--IndexError, KeyError are specific variations

TypeError
--operation or function is applied to an object of inappropriate type

NameError
--Raised when a local or global name is not found. 
'''


"""
QUESTION:
Write a try catch block in Python that throws a TypeError 
is the user input is negative. Catch the error and print “negative”. 
If not negative, print “positive”

"""


#Answer:
try:
    x = int( input( "#: " ) )
    if x < 0:
        raise TypeError
except TypeError:
    print( "negative!" )
else:
    print( "positive" )



