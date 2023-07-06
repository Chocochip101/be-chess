package softeer2nd.chess.board;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;
import softeer2nd.chess.pieces.factory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Board {
    private final static int ROW_COUNT = 8;
    private final static int COL_COUNT = 8;
    private final static int WHITE_PIECE_ROW = 0;
    private final static int WHITE_PAWN_ROW = 1;
    private final static List<Integer> BLANK_ROW = List.of(2, 3, 4, 5);
    private final static int BLACK_PAWN_ROW = 6;
    private final static int BLACK_PIECE_ROW = 7;

    private List<Rank> board;

    public Board() {
    }

    public void initialize() {
        board = new ArrayList<>();
        board.add(Rank.initializePieces(WHITE_PIECE_ROW, new WhitePiecesFactory()));
        board.add(Rank.initializePieces(WHITE_PAWN_ROW, new WhitePawnPiecesFactory()));
        for (int ROW : BLANK_ROW) {
            board.add(Rank.initializePieces(ROW, new BlankPiecesFactory()));
        }
        board.add(Rank.initializePieces(BLACK_PAWN_ROW, new BlackPawnPiecesFactory()));
        board.add(Rank.initializePieces(BLACK_PIECE_ROW, new BlackPiecesFactory()));
    }

    private String getPieceResult(Rank rank) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            stringBuilder.append(piece.getRepresentation());
        }
        return stringBuilder.toString();
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.rangeClosed(board.size() - 1, 0)
                .forEach(idx -> {
                    stringBuilder.append(appendNewLine(getPieceResult(board.get(idx))));
                });
        return stringBuilder.toString();
    }

    public Piece findPiece(String strPoint) {
        Point p = new Point(strPoint);
        return board.get(p.getY()).findPiece(p.getX());
    }

    public int countPieceByColorAndType(Color color, Type type) {
        int result = 0;
        for (Rank rank : board) {
            result += rank.countPieceByColorAndType(color, type);
        }
        return result;
    }
}