package com.example.chess.board;

import com.example.chess.entity.Color;
import com.example.chess.entity.Move;
import com.example.chess.entity.Piece;
import com.example.chess.entity.Position;

import java.util.ArrayList;
import java.util.List;

public class MoveGenerator {
    public List<Move> getMoves(Piece piece, Board board) {
        List<Move> moves = new ArrayList<>();
        Position from = piece.position();

        switch (piece.type()) {
            case PAWN -> addPawnMoves(piece, board, moves, from);
            case ROOK -> addRookMoves(piece, board, moves, from);
            case KNIGHT -> addKnightMoves(piece, board, moves, from);
            case BISHOP -> addBishopMoves(piece, board, moves, from);
            case QUEEN -> addQueenMoves(piece, board, moves, from);
            case KING -> addKingMoves(piece, board, moves, from);
        }

        return moves;
    }

    private void addPawnMoves(Piece piece, Board board, List<Move> moves, Position from) {
        int direction = piece.color() == Color.WHITE ? 1 : -1;
        int startRow = piece.color() == Color.WHITE ? 1 : 6;

        Position forward1 = new Position(from.row() + direction, from.col());
        if (isOnBoard(forward1) && board.isEmpty(forward1)) {
            moves.add(new Move(from, forward1, piece));

            if (from.row() == startRow) {
                Position forward2 = new Position(from.row() + 2 * direction, from.col());
                if (board.isEmpty(forward2)) {
                    moves.add(new Move(from, forward2, piece));
                }
            }
        }

        for (int colOffset : new int[]{-1, 1}) {
            Position capture = new Position(from.row() + direction, from.col() + colOffset);
            if (isOnBoard(capture)) {
                Piece target = board.get(capture);
                if (target != null && target.color() != piece.color()) {
                    moves.add(new Move(from, capture, piece));
                }
            }
        }
    }

    private void addRookMoves(Piece piece, Board board, List<Move> moves, Position from) {
        for (int[] dir : new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}) {
            addLineMoves(piece, board, moves, from, dir[0], dir[1]);
        }
    }

    private void addBishopMoves(Piece piece, Board board, List<Move> moves, Position from) {
        for (int[] dir : new int[][]{{1,1}, {1,-1}, {-1,1}, {-1,-1}}) {
            addLineMoves(piece, board, moves, from, dir[0], dir[1]);
        }
    }

    private void addQueenMoves(Piece piece, Board board, List<Move> moves, Position from) {
        addRookMoves(piece, board, moves, from);
        addBishopMoves(piece, board, moves, from);
    }

    private void addKingMoves(Piece piece, Board board, List<Move> moves, Position from) {
        for (int[] dir : new int[][]{
                {0,1}, {0,-1}, {1,0}, {-1,0},
                {1,1}, {1,-1}, {-1,1}, {-1,-1}
        }) {
            Position to = new Position(from.row() + dir[0], from.col() + dir[1]);
            if (isOnBoard(to)) {
                Piece target = board.get(to);
                if (target == null || target.color() != piece.color()) {
                    moves.add(new Move(from, to, piece));
                }
            }
        }
    }

    private void addKnightMoves(Piece piece, Board board, List<Move> moves, Position from) {
        for (int[] offset : new int[][]{
                {2,1}, {2,-1}, {-2,1}, {-2,-1},
                {1,2}, {1,-2}, {-1,2}, {-1,-2}
        }) {
            Position to = new Position(from.row() + offset[0], from.col() + offset[1]);
            if (isOnBoard(to)) {
                Piece target = board.get(to);
                if (target == null || target.color() != piece.color()) {
                    moves.add(new Move(from, to, piece));
                }
            }
        }
    }

    private void addLineMoves(Piece piece, Board board, List<Move> moves, Position from, int dRow, int dCol) {
        int row = from.row() + dRow;
        int col = from.col() + dCol;

        while (isOnBoard(row, col)) {
            Position to = new Position(row, col);
            Piece target = board.get(to);

            if (target == null) {
                moves.add(new Move(from, to, piece));
            } else {
                if (target.color() != piece.color()) {
                    moves.add(new Move(from, to, piece));
                }
                break;
            }

            row += dRow;
            col += dCol;
        }
    }

    private boolean isOnBoard(Position pos) {
        return pos.row() >= 0 && pos.row() < 8 && pos.col() >= 0 && pos.col() < 8;
    }
}
