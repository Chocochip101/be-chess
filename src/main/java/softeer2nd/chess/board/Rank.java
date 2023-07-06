package softeer2nd.chess.board;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import softeer2nd.chess.pieces.Piece.*;
import softeer2nd.chess.pieces.factory.PiecesFactory;

public class Rank {

    private List<Piece> pieces = new ArrayList<Piece>();

    public List<Piece> getPieces() {
        return pieces;
    }

    public static Rank initializePieces(int index, PiecesFactory piecesFactory) {
        Rank rank = new Rank();
        rank.pieces = piecesFactory.createPiece(index);
        return rank;
    }

    public Piece findPiece(int xPos) {
        return pieces.get(xPos);
    }


    public int countPieceByColorAndType(Color color, Type type) {
        int countOfPiece = 0;
        for (Piece piece : pieces) {
            countOfPiece += checkColorType(piece, color, type);
        }
        return countOfPiece;
    }

    private int checkColorType(Piece piece, Color color, Type type) {
        if (piece.checkColorType(color, type)) {
            return 1;
        }
        return 0;
    }
}
