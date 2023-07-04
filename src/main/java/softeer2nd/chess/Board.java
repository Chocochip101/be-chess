package softeer2nd.chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawnList = new ArrayList<>();

    Board() {
    }

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public Integer size() {
        return pawnList.size();
    }

    public Pawn findPawn(Integer idx) {
        return pawnList.get(idx);
    }
}
