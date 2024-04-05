from moore_mary.BehaviorLock import BehaviorLock


class Basic(BehaviorLock):  # GRADING: BASIC_FILL
    def __init__(self, lock) -> None:
        super().__init__(lock)

    def update(self) -> None:
        if self.lock.boat:
            self.lock.waterLevel += 1
            self.lock.waterLevel = min(self.lock.waterLevel, self.lock.depth)

        else:
            self.lock.waterLevel -= 1
            self.lock.waterLevel = max(self.lock.waterLevel, 0)

    def canAcceptBoat(self) -> bool:
        return self.lock.waterLevel == 0

    def boatCanLeave(self) -> bool:
        return self.lock.waterLevel == self.lock.depth
