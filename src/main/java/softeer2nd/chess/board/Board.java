package softeer2nd.chess.board;

import softeer2nd.chess.board.rankFactory.*;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;

public class Board {
    private final static int WHITE_PIECE_ROW = 0;
    private final static int WHITE_PAWN_ROW = 1;
    private final static List<Integer> BLANK_ROW = List.of(2, 3, 4, 5);
    private final static int BLACK_PAWN_ROW = 6;
    private final static int BLACK_PIECE_ROW = 7;

    private final List<Rank> board = new ArrayList<>();

    public Board() {
    }

    public List<Rank> getRankList() {
        return this.board;
    }

    public void initialize() {
        board.clear();
        board.add(Rank.initializePieces(WHITE_PIECE_ROW, new WhiteRankFactory()));
        board.add(Rank.initializePieces(WHITE_PAWN_ROW, new WhitePawnRankFactory()));
        for (int ROW : BLANK_ROW) {
            board.add(Rank.initializePieces(ROW, new BlankRankFactory()));
        }
        board.add(Rank.initializePieces(BLACK_PAWN_ROW, new BlackPawnRankFactory()));
        board.add(Rank.initializePieces(BLACK_PIECE_ROW, new BlackRankFactory()));
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
        for (int idx = board.size() - 1; idx >= 0; --idx) {
            stringBuilder.append(appendNewLine(getPieceResult(board.get(idx))));
        }
        return stringBuilder.toString();
    }

    public Piece findPiece(String strPoint) {
        Point p = new Point(strPoint);
        return board.get(p.getY()).findPiece(p.getX());
    }

    public Piece findPiece(Point p) {
        return board.get(p.getY()).findPiece(p.getX());
    }

    public Piece findPiece(int x, int y) {
        return board.get(y).findPiece(x);
    }

    private List<Piece> findPieceByColor(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (Rank rank : board) {
            pieces.addAll(rank.findPieceByColor(color));
        }
        return pieces;
    }

    public double calculatePoint(Color color) {
        List<Piece> pieces = findPieceByColor(color);
        double point = 0.0;
        for (Piece piece : pieces) {
            point += piece.getScores(pieces);
        }
        return point;
    }

    public int countPieceByColorAndType(Color color, Type type) {
        int result = 0;
        for (Rank rank : board) {
            result += rank.countPieceByColorAndType(color, type);
        }
        return result;
    }
}