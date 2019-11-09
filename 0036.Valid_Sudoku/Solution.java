class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Possible other values? ([1-9.])
        // Solution 1
        // foreach line find duplicates by set
        // foreach row find duplicates by set
        // foreach 3-3 block find duplicates by set
        // Matrix N*N
        // O(N^2)
        return isValidRows(board) && isValidColumns(board) && isValidBoxes(board);
    }

    private boolean isValidRows(char[][] board) {
        for (int row = 0; row < board.length; ++row) {
            Set<Character> visited = new HashSet<>();
            for (int col = 0; col < board[row].length; ++col) {
                char digit = board[row][col];
                if (digit == '.') {
                    continue;
                }
                if (visited.contains(digit)) {
                    return false;
                }
                visited.add(digit);
            }
        }
        return true;
    }
    
    private boolean isValidColumns(char[][] board) {
        for (int col = 0; col < board.length; ++col) {
            Set<Character> visited = new HashSet<>();
            for (int row = 0; row < board[col].length; ++row) {
                char digit = board[row][col];
                if (digit == '.') {
                    continue;
                }
                if (visited.contains(digit)) {
                    return false;
                }
                visited.add(digit);
            }
        }
        return true;
    }

    private boolean isValidBoxes(char[][] board) {
        for (int startRow = 0; startRow < board.length; startRow += 3) {
            for (int startCol = 0; startCol < board[startRow].length; startCol += 3) {
                if (!isValidBox(board, startRow, startCol)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidBox(char[][] board, int startRow, int startCol) {
        Set<Character> visited = new HashSet<>();
        for (int row = startRow; row < startRow + 3; ++row) {
            for (int col = startCol; col < startCol + 3; ++col) {
                char digit = board[row][col];
                if (digit == '.') {
                    continue;
                }
                if (visited.contains(digit)) {
                    return false;
                }
                visited.add(digit);
            }
        }
        return true;
    }    
}