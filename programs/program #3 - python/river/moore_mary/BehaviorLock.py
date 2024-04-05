class BehaviorLock:
    def __init__(self, lock) -> None:
        self.lock = lock

    def update(self) -> None:
        pass

    def canAcceptBoat(self) -> bool:  # boat can only enter a lock when the water level is zero
        pass

    def boatCanLeave(self) -> bool:  # boat can only leave when the water level is the same as the depth
        pass
