package softeer2nd.chess.board;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import softeer2nd.chess.pieces.Piece.*;
import softeer2nd.chess.board.rankFactory.RankFactory;

public class Rank {

    private List<Piece> pieces = new ArrayList<Piece>();

    public List<Piece> getPieces() {
        return pieces;
    }

    public static Rank initializePieces(int index, RankFactory rankFactory) {
        Rank rank = new Rank();
        rank.pieces = rankFactory.createPieces(index);
        return rank;
    }

    public Piece findPiece(int xPos) {
        return pieces.get(xPos);
    }

    public void move(int pos, Piece piece) {
        this.pieces.set(pos, piece);
    }

    public int countPieceByColorAndType(Color color, Type type) {
        int countOfPiece = 0;
        for (Piece piece : pieces) {
            countOfPiece += checkColorType(piece, color, type) ? 1 : 0;
        }
        return countOfPiece;
    }

    private boolean checkColorType(Piece piece, Color color, Type type) {
        return piece.checkColorType(color, type);
    }
}
