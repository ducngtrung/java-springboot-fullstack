import java.util.HashSet;
import java.util.Set;

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//     1. Each row must contain the digits 1-9 without repetition.
//     2. Each column must contain the digits 1-9 without repetition.
//     3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

public class LeetCode_36 {
    public static void main(String[] args) {
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] board2 = {
            {'9','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board1));
        System.out.println(isValidSudoku(board2));
    }

    static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if (board[i][j] != '.') { // Nếu ô không rỗng
                    
                    String row = "row " + i + "  " + board[i][j];
                    String column = "column  " + j + "  " + board[i][j];
                    String matrix = "matrix  " + (i/3) + "  " + (j/3) + "  " + board[i][j];

                    // Nếu có số trùng lặp theo điều kiện hàng/cột/matrix thì return false
                    if (set.contains(row) || set.contains(column) || set.contains(matrix)) {
                        return false;
                    }

                    set.add(row);
                    set.add(column);
                    set.add(matrix);
                }
            }
        }
        
        return true;
    }
}