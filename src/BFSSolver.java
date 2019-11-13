import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSSolver extends Solver {

    private State start;

    BFSSolver(int[][] board) {
        super(board);

        start = new State(board, 0);
    }

    @Override
    public int run() {

        Queue<State> states = new LinkedList<>();
        states.add(start);

        Map<String, Boolean> stateTracker = new HashMap<>();
        stateTracker.put(start.toString(), true);

        while(states.size() != 0) {

            State currentState = states.peek();
            states.remove();

            if(!areLightsOut(currentState)) {

                for(int i = 0; i < currentState.getBoardHeight(); i++) {

                    for(int j = 0; j < currentState.getBoardWidth(); j++) {

                        State nextState = currentState.getStateWithMove(i, j);

                        if(!stateTracker.containsKey(nextState.toString())) {
                            stateTracker.put(nextState.toString(), true);
                            states.add(nextState);
                        }
                    }
                }
            }
            else {

                return currentState.getMovesToGetHere();
            }
        }

        return -1;
    }
}
