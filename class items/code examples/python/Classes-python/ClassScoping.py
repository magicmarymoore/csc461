#example swiped from
# https://stackoverflow.com/questions/1537202/variables-inside-and-outside-of-a-class-init-function
#updated to python 3.X and added more explanation

class Foo:
    static_var = 'every instance has access'

    def __init__(self,name):
        self.instance_var = 'I am ' + name

    def printAll(self):
        print('self.instance_var = %s' % self.instance_var)
        # can be a shadowed static_var if ever set!!!!!!!!!!
        print('self.static_var = %s' % self.static_var)
        print('Foo.static_var = %s' % Foo.static_var)


print("Original......................................")
f1 = Foo('f1')
f1.printAll()

print("\nAltered INSTANCE shadows variable by using instance......................................")
f1.static_var = 'Shadowing static_var' #broke the original reference!!!!!!!!!!!
f1.printAll()

print("\nMake a new instance to show shadows variable is the original......................................")
f2 = Foo('f2')
f2.printAll()

print("\nAltered CLASS variable......................................")
Foo.static_var = 'modified class'

print("First instance......................................")
f1.printAll()
print("\nSecond instance......................................")
f2.printAll()

print("In the first instance, python actually ADDED a new instance variable. Python can add those ANYWHERE in its class")