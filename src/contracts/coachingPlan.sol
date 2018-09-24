pragma experimental ABIEncoderV2;

contract CoachingPlan {
    string public coach;
    string public coachee;
    string[] public goals;

    function CoachingPlan(string _coach, string _coachee){
        coach = _coach;
        coachee = _coachee;
    }

    function addGoal(string _goal) {
        goals.push(_goal);
    }

    function getCoachingPlan() constant returns (string, string, string[]) {
        return (coach, coachee, goals);
    }
}