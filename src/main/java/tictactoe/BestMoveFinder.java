package tictactoe;

import java.util.List;
import java.util.Random;

public class BestMoveFinder {

	static Random RAND = new Random();
	public int getBestMove(Board board) {
		Board.Piece activePlayer = board.getActive();
		List<Integer> moves = board.getMoves();
		
		for (int move : moves) {
			Board child = new Board();
			child.set(move, activePlayer);
			if(child.getWinner() == activePlayer){
				return move;
			}
		}
		return moves.get(RAND.nextInt(moves.size()));
	}

	public static void main(String[] args) {

	}
}
