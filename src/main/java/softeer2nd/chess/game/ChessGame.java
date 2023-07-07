package softeer2nd.chess.game;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.board.Rank;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.List;

public class ChessGame {
    private List<Rank> board;

    public ChessGame(List<Rank> board) {
        this.board = board;
    }

    public void move(String source, String target) {
        Point sourcePoint = new Point(source);
        Point targetPoint = new Point(target);
        Piece piece = findPiece(source);

        board.get(targetPoint.getY()).move(targetPoint.getX(), piece);
        piece.setPoint(targetPoint);
        board.get(sourcePoint.getY()).move(sourcePoint.getX(), Piece.createBlank(sourcePoint));
    }

    public Piece findPiece(String strPoint) {
        Point p = new Point(strPoint);
        return board.get(p.getY()).findPiece(p.getX());
    }

}
