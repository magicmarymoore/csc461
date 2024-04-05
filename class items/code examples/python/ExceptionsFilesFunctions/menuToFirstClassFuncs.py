# here is the "main" function
def main():

    # menu before (Normal)
    print("Normal Menu")
    while True:
        cmd = input( "Enter a command [abcdex]: " )
        if   cmd == 'a':
            a()
        elif cmd == 'b':
            b()
        elif cmd == 'c':
            c()
        elif cmd == 'd':
            d()
        elif cmd == 'e':
            e()
        elif cmd == 'x':
            break
        else:
            print( 'Invalid command, please try again!' )

    # menu after (first class functions)
    print( "\n\nFirst class functions Menu" )
    cmdlst = { 'a': a, 'b': b, 'c': c, 'd': d, 'e': e }

    #for the lambda lovers...
    #cmdlst = {'a': lambda: print("You selected menu option a!"),
    #          'b': b, 'c': c, 'd': d, 'e': e}
    while True:
        cmd = input( "Enter a command [abcdex]: " )
        if cmd and cmd in "abcde":
            cmdlst[ cmd ]( )
        elif cmd == 'x':
            break
        else:
            print( 'Invalid command, please try again!' )

# command functions
def a():
    print( "You selected menu option a!" )
def b():
    print( "You selected menu option b!" )
def c():
    print( "You selected menu option c!" )
def d():
    print( "You selected menu option d!" )
def e():
    print( "You selected menu option e!" )

# typical main() function pattern
if __name__ == '__main__':
    main()
