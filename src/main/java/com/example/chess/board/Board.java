package com.example.chess.board;

import com.example.chess.entity.Color;
import com.example.chess.entity.Piece;
import com.example.chess.entity.PieceType;
import com.example.chess.entity.Position;

import lombok.Getter;

@Getter
public class Board {
    private final Piece[][] board;

    public Board() {
        this.board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Piece(PieceType.PAWN, Color.WHITE, new Position(1, col));
            board[6][col] = new Piece(PieceType.PAWN, Color.BLACK, new Position(6, col));
        }

        PieceType[] backRow = {PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN,
                PieceType.KING, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK};

        for (int col = 0; col < 8; col++) {
            board[0][col] = new Piece(backRow[col], Color.WHITE, new Position(0, col));
            board[7][col] = new Piece(backRow[col], Color.BLACK, new Position(7, col));
        }
    }
}
