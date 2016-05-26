package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tictactoe.Board.Piece;

public class EnumerateBoards {

	// determine number of diff board configurations - from beginning

	public static void main(String[] args) {
		Board emptyBoard = new Board();
		int boards = 0;
		int xWins = 0;
		int oWins = 0;
		int ties = 0;

		Stack<Board> stack = new Stack<Board>();
		stack.push(emptyBoard);

		while (!stack.isEmpty()) {
			Board board = stack.pop();
			boards++;

			Piece winner = board.getWinner();
			if (winner != null) {
				if (winner == Piece.X) {
					xWins++;
					continue;
				} else if (winner == Piece.O) {
					oWins++;
					continue;
				}
			}

			List<Integer> moves = board.getMoves();

			if (moves.size() == 0) {
				ties++;
				continue;
			}

			for (Integer i : moves) {
				Board newBoard = new Board(board);
				newBoard.set(i, board.getActive());
				stack.push(new Board(newBoard));
			}
		}

		System.out.println(String.format("boards=%d, x wins=%d, o wins=%d, ties=%d, leaves=%d", boards, xWins, oWins, ties, (xWins + oWins + ties)));
		
	}
}
