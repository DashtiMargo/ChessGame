package com.example.chess.board;

import com.example.chess.entity.Piece;

public record Board(int[] board) {
    public Board() {
        this.board = new Piece[8][8];
        initializeBoard();
    }
}
