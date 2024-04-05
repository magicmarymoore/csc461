from moore_mary.BehaviorBoat import BehaviorBoat


class Steady(BehaviorBoat):
    def move(self, flow: int) -> int:
        return 1  #GRADING: STEADY_TRAVEL
