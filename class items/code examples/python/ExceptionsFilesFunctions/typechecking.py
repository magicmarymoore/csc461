"""
Python 3.9 and under
----------------------------------------------
Problem:
C++---
Stuff GetStuff(int i){…};
Stuff_B GetStuff(string name){…};

Python---
def GetStuff(i)…
def GetStuff(name)…

------------------------------------------
3.10 and over-----
i : DataType

def temp( i : int) -> str:
    return "temp" * i

This is a "hint" only. Not enforced

"""
#3.10------------
def temp( i : int) -> str:
    return "temp" * i
print(temp(2))



#option 1) type(X) is className_or_type
x = 10
print( 'x =', x, ', type( x ) =', type( x ) )
if type( x ) is int:
    print( x, 'is of type int' )
print()


#option 2) isinstance(obj, className_or_type))
y = 3.14159
print( 'y =', y, ', type( y ) =', type( y ) )
if isinstance( y, float ):
    print( y, 'is an instance of type float' )
print()


#inheritance trees still work with type checking
class A:
    def __init__(self):
        print("Class A")
class B(A):
    def __init__(self):
        super().__init__()
        print("Class B")

bObj = B()
if isinstance( bObj, B):
    print( bObj, 'is an instance of type B' )
if isinstance( bObj, A): #type(...) only works on the exact type
    print( bObj, 'is an instance of type A' )
print()

"""
Question:
Make you own _printRange_ function that allows floating point steps, 
but defaults to a _start_ of 0, a _end_ of 10, and a _step_ of 1, 
such that this is a legal call: 
    printRange (end = 5, step = 0.5)

Your _start_ and _end_ MUST be _ints_ and _step_ MUST be a _float_, 
so you must type check input. Print “Ack” and return in the failure case
"""



'''
#Answer:
def printRange(start = 0, end = 10, step = 1.0):
    if type(start) != int or type(end) != int or type(step) !=float:
        print( "Ack!" )
        return
    while start < end:
        start = start + step
        print (start)
printRange(end = 5, step =0.5)
printRange(end = 5.0, step =0.5) #will print "Ack"
'''
