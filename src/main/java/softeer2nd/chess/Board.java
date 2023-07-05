package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.chess.pieces.Piece.*;

public class Board {
    public final static int ROW_COUNT = 8;
    public final static int COL_COUNT = 8;
    private final List<Piece> pieceList = new ArrayList<>();

    public Board() {
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public int pieceCount() {
        return pieceList.size();
    }

    public Piece findPiece(int idx) {
        return pieceList.get(idx);
    }

    public void initialize() {
        pieceList.clear();

        initializePawn();
        initializeRook();
        initializeKnight();
        initializeBishop();
        initializeQueen();
        initializeKing();
    }

    private void initializeKing() {
        pieceList.add(createWhiteKing(new Point(7, 4)));
        pieceList.add(createBlackKing(new Point(0, 4)));
    }

    private void initializeQueen() {
        pieceList.add(createWhiteQueen(new Point(7, 3)));
        pieceList.add(createBlackQueen(new Point(0, 3)));
    }

    private void initializeBishop() {
        pieceList.add(createWhiteBishop(new Point(7, 2)));
        pieceList.add(createWhiteBishop(new Point(7, 5)));
        pieceList.add(createBlackBishop(new Point(0, 2)));
        pieceList.add(createBlackBishop(new Point(0, 5)));
    }

    private void initializeKnight() {
        pieceList.add(createWhiteKnight(new Point(7, 1)));
        pieceList.add(createWhiteKnight(new Point(7, 6)));
        pieceList.add(createBlackKnight(new Point(0, 1)));
        pieceList.add(createBlackKnight(new Point(0, 6)));
    }

    private void initializeRook() {
        pieceList.add(createWhiteRook(new Point(7, 0)));
        pieceList.add(createWhiteRook(new Point(7, 7)));
        pieceList.add(createBlackRook(new Point(0, 0)));
        pieceList.add(createBlackRook(new Point(0, 7)));
    }

    private void initializePawn() {
        for (int line = 0; line < ROW_COUNT; ++line) {
            pieceList.add(createWhitePawn(new Point(6, line)));
            pieceList.add(createBlackPawn(new Point(1, line)));
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
            if (piece.getPoint().isSamePoint(x, y)) {
                return true;
            }
        }
        return false;
    }

    private Character getPieceSymbol(int x, int y) {
        for (Piece piece : pieceList) {
            if (piece.getPoint().isSamePoint(x, y)) {
                return piece.getRepresentation();
            }
        }
        return null;
    }

    public String getWhitePiecesResult() {
        return pieceList.stream()
                .filter(piece -> piece.getColor().equals(Piece.WHITE_COLOR))
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

    public String getBlackPiecesResult() {
        return pieceList.stream()
                .filter(piece -> piece.getColor().equals(Piece.BLACK_COLOR))
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        buildPrintString(stringBuilder);
        return stringBuilder.toString();
    }
}