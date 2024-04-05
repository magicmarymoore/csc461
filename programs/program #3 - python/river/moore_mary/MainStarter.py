from moore_mary.Boat import Boat
from moore_mary.Lock import Lock
from moore_mary.MaxSpeed import MaxSpeed
from moore_mary.RiverSystem import RiverSystem
from moore_mary.Section import Section
from moore_mary.Steady import Steady


def cleanInput(prompt):
    result = input(prompt)
    # strips out blank lines in input
    while result == '':
        result = input( )

    return result

# b/c testing was quirky i had to move this out here
nextBoatId = 1

def main( ):
    global nextBoatId
    river = RiverSystem()
    # set up the default river:
    river.addPart(Section(6, 0))
    river.addPart(Lock(0))
    river.addPart(Section(3, 1))

    menu = "\n" \
           "1) Add Default Boat\n" \
           "2) Update One Tick\n" \
           "3) Update X Ticks\n" \
           "4) Show Section Details\n" \
           "5) Add Boat\n" \
           "6) Make Tester\n" \
           "7) Make New Simulator\n" \
           "0) Quit\n"


    choice = -1
    print(river)
    while choice != 0:
        try:

            print( menu )
            choice = int(cleanInput( "Choice:> " ))

            # add default boat
            if choice == 1:
                river.addDefaultBoat(nextBoatId)
                nextBoatId += 1
                print(river)

            # update one time
            elif choice == 2:
                river.update()
                print(river)

            # update X number of times
            elif choice == 3:
                num = int(cleanInput("How many times would you like to update:> "))
                for _ in range(num):
                    river.update()
                    print(river)

            # print out station details
            elif choice == 4:
                river.details()

            # make a new box of any size
            elif choice == 5:
                power = int(cleanInput("What engine power:> "))
                method = cleanInput("What travel method. (1) Steady or (2) Max :> ")

                try:
                    method = int(method)
                except ValueError:
                    print("Please, input a positive integer")
                    continue

                if method != 1 and method != 2:
                    print("Input an option in the range 1-2")
                    print(river)
                    continue

                river.addBoat(nextBoatId, power, Steady if method == 1 else MaxSpeed)
                nextBoatId += 1

                print(river)

            # make new system
            elif choice == 6:
                print( "TODO" )

            # make new system
            elif choice == 7:
                print( "TODO" )

            # debug/check for D in SOLID in __str__
            elif choice == -1:
                b1 = Boat(nextBoatId)
                nextBoatId += 1
                b2 = Boat(nextBoatId)
                nextBoatId += 1

                print(b1)  # GRADING:TO_STR

                section = Section(1)
                section.acceptBoat(b1)
                print(section)

                lock = Lock()
                lock.acceptBoat(b2)
                print(lock)

                river.addDefaultBoat(nextBoatId) # third boat
                nextBoatId += 1
                print(river)

            elif choice == 0 or choice == '0':
                choice = 0
            else:
                print("Input an option in the range 0-7")

        except ValueError:
            print("Please, input a positive integer")

        except Exception as e:
            import traceback
            print(traceback.format_exc())

if __name__ == '__main__':
    main( )
