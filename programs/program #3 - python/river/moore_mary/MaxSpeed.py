from moore_mary.BehaviorBoat import BehaviorBoat


class MaxSpeed(BehaviorBoat):
    def move(self, flow: int) -> int:
        speed = self._boat.power - flow  #GRADING: MAX_TRAVEL
        if speed > 0: return speed
        return 1
