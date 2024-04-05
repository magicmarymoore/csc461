# return a function that adds x (the argument)
# to y (the argument of the returned function
def f( x ): #x=3
    h = 0

    def g( y ): #2
        nonlocal h
        print( h, end=" " )
        h+=1
        # Have access to x since scope range is set at creation time!
        # This is called 'closure'
        return x + y

    return g

# these function calls should all print 7 (3 + 4)
a = f( 3 )  # function that adds 3 to its argument
print( a( 4 ) )  # pass 4 to the function
print( a( 2 ) )  # pass 2 to the function
print( f( 5 )( 4 ) )  # currying



print("\nCompare this to C++'s version")
def eval( f, x=2):
    return f(x)
f0 = lambda x : 1
f1 = lambda x : x
fv = [f0, f1]
fv.append(lambda x : x * x)
for f in fv:
    print(f(4))
print(eval(f0), eval(f1))