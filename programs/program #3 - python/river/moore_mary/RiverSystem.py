from Iterator import Iterator
from RiverPart import RiverPart
from moore_mary.Lock import Lock
from moore_mary.Section import Section
from moore_mary.Steady import Steady


class RiverSystem(Iterator):
    __sections = []  # list of river sections

    def __init__(self) -> None:
        self.__sections = []

    def __iter__(self) -> Iterator:
        self.__index = -1
        return self

    def __next__(self) -> Section:
        self.__index += 1
        if self.__index >= len(self.__sections):  # if the end of the list has been reached, stop
            raise StopIteration

        return self.__sections[self.__index]  # otherwise return the next value in the list

    def details(self):
        pass

    def clear(self) -> None:
        self.__sections = []

    def addBoat(self, id, power, behavior):
        from moore_mary.Boat import Boat
        boat = Boat(id, power)
        boat.setBehavior(behavior)
        self.__sections[0].acceptBoat(boat)

    def addDefaultBoat(self, id: int):
        self.addBoat(id, 1, Steady)

    def addPart(self, part: RiverPart):
        self.__sections.append(part)

    def __str__(self):
        top, bottom = "", ""
        for part in self:
            top += str(part)
            bottom += part.printIds()

        return top + "\n" + bottom

    def update(self):
        self.__sectionList = self.__sections[::-1]  # reverse the list to start at the end

        for i, part in enumerate(self):
            wasUpdated = False

            part: RiverPart
            if isinstance(part, Lock):
                part.update()  # fill the lock
                wasUpdated = True  # set flag so it doesn't get filled twice

            if part.boatCanLeave():
                if i == 0:
                    part.removeLeavingBoat()  # remove boat from river as it is at the end
                else:
                    sectionAhead = i - 1  # subtract one because the list is reversed

                    if self.__sections[sectionAhead].canAcceptBoat():
                        self.__sections[sectionAhead].acceptBoat(part.removeLeavingBoat())  # pass the boat to the next section

            if not wasUpdated:
                part.update()

        self.__sections = self.__sections[::-1]  # set list back to correct order
