from moore_mary.Boat import Boat
from moore_mary.RiverPart import RiverPart

class Section(RiverPart):
    def __init__(self, length: int, flow: int = 0) -> None:
        self.units = [None for _ in range(length)]  # each piece of section will either be a boat or None
        self.flow = flow

    def __str__(self) -> str:
        return ''.join([f'{x if x else "〜"}〜〜' for x in self.units])

    def printIds(self) -> str:
        return ''.join(
            [f'{str(x.id) + "〜" * (3 - len(str(x.id)))}' if isinstance(x, Boat) else '〜〜〜' for x in self.units])

    def update(self) -> None:
        #iterator = SectionIterator(units)
        pass

    def details(self):
        return f"Boats: {sum([1 if isinstance(x, Boat) else 0 for x in self.units])} Flow: {self.flow}"

    def boatCanLeave(self) -> bool:
        return True if isinstance(self.units[0], Boat) else False

    def removeLeavingBoat(self) -> Boat:
        assert self.boatCanLeave()

        tmpBoat = self.units[-1]
        self.units[-1] = None
        return tmpBoat

    def canAcceptBoat(self) -> bool:
        return False if isinstance(self.units[0], Boat) else True

    def acceptBoat(self, boat: Boat) -> bool:
        if not self.canAcceptBoat(): return False

        self.units[0] = boat
        return True
