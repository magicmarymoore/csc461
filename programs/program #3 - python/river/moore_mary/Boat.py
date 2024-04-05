from moore_mary.Steady import Steady


class Boat:
    behavior = None

    def __init__(self, id: int, power: int) -> None:
        self.id = id
        self.power = power
        self.behavior = None

    def __str__(self) -> str:
        return '⛴'

    def move(self, flow: int) -> int: # move the boat according to the behavior set
        return self.behavior.move(flow)

    def setBehavior(self, behavior=Steady) -> None:  # default behavior is steady
        self.behavior = behavior(self)  # create a new instance of the desired behavior and pass in this boat
