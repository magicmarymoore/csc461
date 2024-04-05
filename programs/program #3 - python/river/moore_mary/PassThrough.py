from moore_mary.BehaviorLock import BehaviorLock


class PassThrough(BehaviorLock):
    def __init__(self, lock):
        super().__init__(lock)

    def update(self):
        pass

    def canAcceptBoat(self):
        return True

    def boatCanLeave(self):
        return True