from moore_mary.BehaviorLock import BehaviorLock


class FastEmpty(BehaviorLock):  # GRADING: FAST_EMPTY
    def __init__(self, lock):
        super().__init__(lock)

    def update(self):
        if self.lock.boat:
            self.lock.waterLevel += 1
            self.lock.waterLevel = min(self.lock.waterLevel, self.lock.depth)

        else:
            self.lock.waterLevel -= 2
            self.lock.waterLevel = max(self.lock.waterLevel, 0)

    def canAcceptBoat(self):
        return self.lock.waterLevel == 0

    def boatCanLeave(self):
        return self.lock.waterLevel == self.lock.depth
