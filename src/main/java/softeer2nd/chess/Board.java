package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawnList = new ArrayList<>();

    public Board() {
    }

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int size() {
        return pawnList.size();
    }

    public Pawn findPawn(int idx) {
        return pawnList.get(idx);
    }
}
