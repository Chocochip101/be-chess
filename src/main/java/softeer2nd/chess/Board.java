package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    public final static int ROW_COUNT = 8;
    public final static int COL_COUNT = 8;
    private final List<Piece> pieceList = new ArrayList<>();

    public Board() {
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public int size() {
        return pieceList.size();
    }

    public Piece findPiece(int idx) {
        return pieceList.get(idx);
    }

    public void initialize() {
        pieceList.clear();
        for (int line = 0; line < ROW_COUNT; ++line) {
            pieceList.add(new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION, 6, line));
            pieceList.add(new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION, 1, line));
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
            boolean isPiecePresent = isPieceAtPosition(rowIndex, col);
            if (isPiecePresent) {
                stringBuilder.append(getPieceSymbol(rowIndex, col));
            } else {
                stringBuilder.append(".");
            }
        }
    }

    private boolean isPieceAtPosition(int x, int y) {
        for (Piece piece : pieceList) {
            if (piece.getPoint().getX() == x && piece.getPoint().getY() == y) {
                return true;
            }
        }
        return false;
    }

    private String getPieceSymbol(int x, int y) {
        for (Piece piece : pieceList) {
            if (piece.getPoint().getX() == x && piece.getPoint().getY() == y) {
                if (piece.getColor().equals(Piece.WHITE_COLOR)) {
                    return "p";
                } else {
                    return "P";
                }
            }
        }
        return "";
    }


    public String getWhitePiecesResult() {
        return pieceList.stream()
                .filter(piece -> piece.getColor().equals(Piece.WHITE_COLOR))
                .map(piece -> String.valueOf(Piece.WHITE_REPRESENTATION))
                .collect(Collectors.joining());
    }

    public String getBlackPiecesResult() {
        return pieceList.stream()
                .filter(piece -> piece.getColor().equals(Piece.BLACK_COLOR))
                .map(piece -> String.valueOf(Piece.BLACK_REPRESENTATION))
                .collect(Collectors.joining());
    }

}
