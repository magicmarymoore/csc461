from math import sqrt

# find roots of a quadratic equation
# possibilities include zero, one or two roots
print( "Input (float on separate lines) a, b, and c:" )
a = float( input( ) )
b = float( input( ) )
c = float( input( ) )

print( "roots of", a, "x^2 +", b, "x +", c, "= 0" )

# discriminant is sqrt(b^2-4ac)
discrim = b * b - 4 * a * c

# linear equation: one solution (-c/b)
if (a == 0):  # ends with :, and () are NOT required
    print( "one root:", -c / b )


# discrim < 0, no solutions
elif discrim < 0:  # () are optional
    print( "no solution" )

# discrim == 0: one solution (b/2a)
elif discrim == 0:
    print( "one root:", -b / (2 * a) )

# discrim > 0: two solutions
# quadratic formula: (-b+sqrt(b^2-4ac))/2a and (-b-sqrt(b^2-4ac))/2a
else:
    print( "two roots:", (-b + sqrt( discrim )) / (2 * a),
           "and", (-b - sqrt( discrim )) / (2 * a) )



# another example with type checking
x =  float(input( "Input a number: " ))
if not (isinstance( x, int ) or isinstance( x, float )):
    print( x, "is not a number" )
elif x < 0:
    print( x, "is negative" )
elif x > 0:
    print( x, "is positive" )
else:
    print( x, "is zero" )

# no switch (before 3.10)! New in 3.10
x =  input( "Input a number for pattern matching: " )
match x:
    case '0':
        print("zero")
    case 1 | '1':
        print("one")
    case _:
        print("no match")

'''
match is well past a switch in power. It can match classes, tuples, part of tuples, 
and even has guards (case '0' if a==0:)

This looses the speed of a regular switch, though
'''