# generator functions contain a yield expression
print( "\nBounded Generator example:", end=' ' )
def genfunc( n ):
    for i in range( n ):
        yield i

# calling a generator function creates a generator iterator
f = genfunc( 4 )

# note similarity to iterator code above
while True:
    try:
        print( next( f ), end=' ' )
    except StopIteration:
        break




print()
print()
print("Infinite Generator version")
def genfuncInfinite( n ):
    i = n
    while True:
        yield i
        i+=1

f2 = genfuncInfinite(10)
for i in range(1,10):
    print(next(f2), end=' ')

print()
for i in range(1,10):
    print(next(f2), end=' ')




print()
print()
print("Class Generator version")
class GenIncrement:
    def __init__(self, n):
        self.__i = n-1

    def __next__(self):
        self.__i += 1
        return self.__i

f3 = GenIncrement(10)
for i in range(1,10):
    print(next(f3), end=' ')

print()
for i in range(1,10):
    print(next(f3), end=' ')