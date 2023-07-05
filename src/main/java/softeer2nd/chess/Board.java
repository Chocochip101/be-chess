package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;
import softeer2nd.chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static softeer2nd.chess.pieces.Piece.*;

public class Board {
    private final static int ROW_COUNT = 8;
    private final static int COL_COUNT = 8;
    private final static int WHITE_PAWN_ROW = 6;
    private final static int BLACK_PAWN_ROW = 1;
    private final static int WHITE_PIECE_ROW = 7;
    private final static int BLACK_PIECE_ROW = 0;
    private final static int WHITE_ROOK_LEFT_COL = 0;
    private final static int WHITE_ROOK_RIGHT_COL = 7;
    private final static int BLACK_ROOK_LEFT_COL = 0;
    private final static int BLACK_ROOK_RIGHT_COL = 7;
    private final static int WHITE_KNIGHT_LEFT_COL = 1;
    private final static int WHITE_KNIGHT_RIGHT_COL = 6;
    private final static int BLACK_KNIGHT_LEFT_COL = 1;
    private final static int BLACK_KNIGHT_RIGHT_COL = 6;
    private final static int WHITE_BISHOP_LEFT_COL = 2;
    private final static int WHITE_BISHOP_RIGHT_COL = 5;
    private final static int BLACK_BISHOP_LEFT_COL = 2;
    private final static int BLACK_BISHOP_RIGHT_COL = 5;
    private final static int QUEEN_COL = 3;
    private final static int KING_COL = 4;

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

    private void initializePawn() {
        IntStream.range(0, ROW_COUNT)
                .forEach(line -> {
                    pieceList.add(createWhitePawn(new Point(WHITE_PAWN_ROW, line)));
                    pieceList.add(createBlackPawn(new Point(BLACK_PAWN_ROW, line)));
                });

    }

    private void initializeRook() {
        pieceList.add(createWhiteRook(new Point(WHITE_PIECE_ROW, WHITE_ROOK_LEFT_COL)));
        pieceList.add(createWhiteRook(new Point(WHITE_PIECE_ROW, WHITE_ROOK_RIGHT_COL)));
        pieceList.add(createBlackRook(new Point(BLACK_PIECE_ROW, BLACK_ROOK_LEFT_COL)));
        pieceList.add(createBlackRook(new Point(BLACK_PIECE_ROW, BLACK_ROOK_RIGHT_COL)));
    }

    private void initializeKnight() {
        pieceList.add(createWhiteKnight(new Point(WHITE_PIECE_ROW, WHITE_KNIGHT_LEFT_COL)));
        pieceList.add(createWhiteKnight(new Point(WHITE_PIECE_ROW, WHITE_KNIGHT_RIGHT_COL)));
        pieceList.add(createBlackKnight(new Point(BLACK_PIECE_ROW, BLACK_KNIGHT_LEFT_COL)));
        pieceList.add(createBlackKnight(new Point(BLACK_PIECE_ROW, BLACK_KNIGHT_RIGHT_COL)));
    }

    private void initializeBishop() {
        pieceList.add(createWhiteBishop(new Point(WHITE_PIECE_ROW, WHITE_BISHOP_LEFT_COL)));
        pieceList.add(createWhiteBishop(new Point(WHITE_PIECE_ROW, WHITE_BISHOP_RIGHT_COL)));
        pieceList.add(createBlackBishop(new Point(BLACK_PIECE_ROW, BLACK_BISHOP_LEFT_COL)));
        pieceList.add(createBlackBishop(new Point(BLACK_PIECE_ROW, BLACK_BISHOP_RIGHT_COL)));
    }

    private void initializeQueen() {
        pieceList.add(createWhiteQueen(new Point(WHITE_PIECE_ROW, QUEEN_COL)));
        pieceList.add(createBlackQueen(new Point(BLACK_PIECE_ROW, QUEEN_COL)));
    }

    private void initializeKing() {
        pieceList.add(createWhiteKing(new Point(WHITE_PIECE_ROW, KING_COL)));
        pieceList.add(createBlackKing(new Point(BLACK_PIECE_ROW, KING_COL)));
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        buildPrintString(stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private void buildPrintString(StringBuilder stringBuilder) {
        IntStream.range(0, COL_COUNT)
                .forEach(col -> {
                    buildRowString(stringBuilder, col);
                    stringBuilder.append(StringUtils.appendNewLine(""));
                });
    }

    private void buildRowString(StringBuilder stringBuilder, int rowIndex) {
        IntStream.range(0, COL_COUNT)
                .forEach(col -> {
                    boolean isPiecePresent = isPieceAtPosition(rowIndex, col);
                    if (isPiecePresent) {
                        stringBuilder.append(getPieceSymbol(rowIndex, col));
                    } else {
                        stringBuilder.append(".");
                    }
                });
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
                .filter(piece -> piece.getColor().equals(Color.WHITE))
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

    public String getBlackPiecesResult() {
        return pieceList.stream()
                .filter(piece -> piece.getColor().equals(Color.BLACK))
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        buildPrintString(stringBuilder);
        return stringBuilder.toString();
    }
}