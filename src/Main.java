public class Main {

    public static void main(String[] args) {

        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 1, 0}};

        BFSSolver solver = new BFSSolver(board);

        System.out.println(solver.run());
    }
}
