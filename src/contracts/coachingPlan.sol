pragma experimental ABIEncoderV2;

contract CoachingPlan {
    string public coach;
    string public coachee;
    string[] public goals;

    function CoachingPlan(){
        coach = "Mike";
        coachee = "Paulien";
    }

    function addGoal(string _goal) {
        goals.push(_goal);
    }

    function getCoachingPlan() constant returns (string, string, string[]) {
        return (coach, coachee, goals);
    }
}