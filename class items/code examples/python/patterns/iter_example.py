class Collection:

    #need a collection to work on
    def __init__(self):
        self.__stuff = [1, 2, 3, 4, 5, 6, 7, 8]

    #initalize the iterator, this is now a iterator class
    def __iter__(self):
        self.__index = -1
        return self #think of this as similar to an interface

    #walkthrough the collection returning one at a time and update the location
    def __next__(self): #controls the iterator
        try:
           self.__index +=1 #equivalent to next()
           return self.__stuff[self.__index] #equivalent to get()
        except:
            raise StopIteration() #equivalent to hasNext()/atEnd()

    #example second iterator as a nested class----------------------------------------------------
    def getSkipIter( self):
        return self.SkipIter(2, self.__stuff)
        # a nested iterator that returns every other element

    class SkipIter:
        # need to store skip amount AND array internally
        def __init__(self, skip, array):
            self.__skip = skip
            self.__array = array

        # same as before
        def __iter__(self):
            self.__index = -1
            return self

        # same as before
        def __next__(self):
            try:
                self.__index += self.__skip  # equivalent to next()
                return self.__array[self.__index]  # equivalent to get()
            except:
                raise StopIteration()  # equivalent to hasNext()/atEnd()


    # example second iterator as a outer class----------------------------------------------------
    def getMultIter( self):
        return MultIter(2, self.__stuff)

#a outer iterator that returns every other element that return every "power" index
class MultIter:
    #same as nested
    def __init__(self, skip, array):
        self.__skip = skip
        self.__array = array

    # same as nested
    def __iter__(self):
        self.__index = 1
        return self

    # same as nested
    def __next__(self):
        try:
            self.__index *= self.__skip #equivalent to next()
            return self.__array[ self.__index] #equivalent to get()
        except:
            raise StopIteration() #equivalent to hasNext()/atEnd()

if __name__ == '__main__':
    temp = Collection( ) #is a class AND iterator now

    print("regular")
    for i in temp: #goes to the iterator
        print(i)

    print( "nested" )
    for i in temp.getSkipIter():
        print( i)

    print( "other class" )
    for i in temp.getMultIter():
        print(i)
