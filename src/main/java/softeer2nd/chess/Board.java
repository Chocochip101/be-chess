package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    public final static int ROW_COUNT = 8;
    public final static int COL_COUNT = 8;
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

    public void initialize() {
        pawnList.clear();
        for (int line = 0; line < ROW_COUNT; ++line) {
            pawnList.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION, 6, line));
            pawnList.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION, 1, line));
        }
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        buildPrintString(stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private void buildPrintString(StringBuilder stringBuilder) {
        for (int col = 0; col < COL_COUNT; ++col) {
            buildRowString(stringBuilder, col);
            stringBuilder.append("\n");
        }
    }

    private void buildRowString(StringBuilder stringBuilder, int rowIndex) {
        for (int col = 0; col < COL_COUNT; ++col) {
            boolean isPawnPresent = isPawnAtPosition(rowIndex, col);
            if (isPawnPresent) {
                stringBuilder.append(getPawnSymbol(rowIndex, col));
            } else {
                stringBuilder.append(".");
            }
        }
    }

    private boolean isPawnAtPosition(int x, int y) {
        for (Pawn pawn : pawnList) {
            if (pawn.getX() == x && pawn.getY() == y) {
                return true;
            }
        }
        return false;
    }

    private String getPawnSymbol(int x, int y) {
        for (Pawn pawn : pawnList) {
            if (pawn.getX() == x && pawn.getY() == y) {
                if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
                    return "p";
                } else {
                    return "P";
                }
            }
        }
        return "";
    }


    public String getWhitePawnsResult() {
        return pawnList.stream()
                .filter(pawn -> pawn.getColor().equals(Pawn.WHITE_COLOR))
                .map(pawn -> String.valueOf(Pawn.WHITE_REPRESENTATION))
                .collect(Collectors.joining());
    }

    public String getBlackPawnsResult() {
        return pawnList.stream()
                .filter(pawn -> pawn.getColor().equals(Pawn.BLACK_COLOR))
                .map(pawn -> String.valueOf(Pawn.BLACK_REPRESENTATION))
                .collect(Collectors.joining());
    }

}
