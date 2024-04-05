from moore_mary.Boat import Boat
from moore_mary.PassThrough import PassThrough
from moore_mary.RiverPart import RiverPart


class Lock(RiverPart):
    def __init__(self, depth: int = 3, behavior=PassThrough):
        self.boat = None
        self.depth = depth
        self.waterLevel = 0
        self.behavior = behavior(lock=self)

    def __str__(self):
        return f"_{self.boat if self.boat else 'X'}( {self.waterLevel})_"

    def __add__(self, other: int): # So i can just add in the lock behavior instead of using a add water level function
        if self.waterLevel + other > self.depth:
            self.waterLevel = self.depth

        else:
            self.waterLevel += other

    def __sub__(self, other: int):# So i can just subtract in the lock behavior instead of using a subtract water level function
        if self.waterLevel - other < 0:
            self.waterLevel = 0

        else:
            self.waterLevel -= other

    def update(self) -> None:
        self.behavior.update()

    def printIds(self) -> str:
        if self.boat:
            strId = str(self.boat.id)
            return strId + "." * (7 - len(strId))
        else:
            return "." * 7

    def boatCanLeave(self) -> bool:
        return self.behavior.boatCanLeave()

    def removeLeavingBoat(self) -> Boat:
        tmpBoat = self.boat
        self.boat = None
        return tmpBoat

    def canAcceptBoat(self) -> bool:
        return self.behavior.canAcceptBoat()

    def acceptBoat(self, boat: Boat) -> bool:
        if self.boat or self.waterLevel != 0:
            return False

        self.boat = boat
        return True
