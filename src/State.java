public class State {

    private int[][] board;
    private int boardWidth;
    private int boardHeight;
    private int movesToGetHere;

    State( int[][] board, int movesToGetHere ) {

        this.board = board;
        boardHeight = board.length;
        boardWidth = board[0].length;
        this.movesToGetHere = movesToGetHere;
    }

    private int[][] getCopy() {

        int[][] newBoard = new int[boardHeight][boardWidth];

        for(int i = 0; i < boardHeight; i++) {

            if (boardWidth >= 0)
                System.arraycopy(board[i], 0, newBoard[i], 0, boardWidth);
        }

        return newBoard;
    }

    private void flipWithNeighbors( int[][] board, int i, int j ) {

        board[i][j] = 1 - board[i][j];

        if( i > 0 )
            board[i-1][j] = 1 - board[i-1][j];

        if( i < boardHeight-1 )
            board[i+1][j] = 1 - board[i+1][j];

        if( j > 0 )
            board[i][j-1] = 1 - board[i][j-1];

        if( j < boardWidth-1 )
            board[i][j+1] = 1 - board[i][j+1];
    }

    public State getStateWithMove( int i, int j ) {

        int[][] newBoard = getCopy();

        flipWithNeighbors(newBoard, i, j);

        return new State( newBoard, this.movesToGetHere + 1 );
    }

    public int get(int i, int j) {

        return board[i][j];
    }

    public int getBoardWidth() {

        return boardWidth;
    }

    public int getBoardHeight() {

        return boardHeight;
    }

    public int getMovesToGetHere() {

        return movesToGetHere;
    }

    public void print() {

        System.out.println("[");
        for(int i = 0; i < boardHeight; i++) {

            for(int j = 0; j < boardWidth; j++) {

                System.out.print(board[i][j]);
            }

            System.out.println();
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < boardHeight; i++) {

            for (int j = 0; j < boardWidth; j++) {

                stringBuilder.append(board[i][j]);
            }
        }

        return stringBuilder.toString();
    }
}
