class Solution {
    public void solveSudoku(char[][] board) {

        // Solution 1
        // 2 sub-solutions
        // 
        // fillWithValidNumbers
        // do while there is at least one change
        //   for every cell find-potential-numbers-in-cell
        //   if potential number is single - write
        //
        // foreach empty cell
        // guess-backtrack
        //   copy board
        //   fill with potential number
        //   
        //   if board is filled check it's valid
        // O(10^81)

        // Solution 2
        // backtrack
        // just try to input all numbers to empty cells one by one 
        // at the end if sudoku is valid

        // Solution 3
        // backtrack
        // 1. For every row

        // 1.1. Calculate map of possible values Map<Index, Set<Possible Value>>
        
        // it's like how to find all permutations, but with tricky limitation of single in column and already taken numbers
        
        // 1.2 For every row find all possible permutations
        // How to find row all permutations?
        // O(N!), because 9*9! is 9!
        // permutations(LinkedHashSet path, result, possibleValuesMap)
        //   int nextNumberIndex = path.size
        //   if nextNumberIndex === 9
        //     result.push(path);
        //     return
        //   foreach 1...9
        //     if number not in possibleValues[nextNumberIndex] or path contains number
        //       skip
        //     path.add(number)
        //     permutations(path, result, possibleValuesMap)
        //     path.remove(path.size() - 1)
        
        // 2. List of rows permutations to sudokus
        // [ 
        //   [
        //     [1, 2, 4, 6, 8, 9],
        //     [1, 2, 4, 6, 9, 8],
        //     ...
        //   ],
        //   [
        //     [2, 3, 4, 7, 8],
        //     ...
        //   ], [], [], [], ...(9) ]
        //
        // buildAndCheckSudoku(board, allPermutations, currentPermutationIndex, currentSudoku)
        //   if currentSudoku.size == 9
        //     return isValid(currentSudoku) ? currentSudoku : null
        //   if currentPermutationRowIndex >= allPermutationsRows.length
        //     return null
        //   foreach currentPermutation in allPermutationsRows[currentPermutationRowIndex]
        //     currentSudoku.push(currentPermutation)
        //     sudoku = buildAndCheckSudoku(board, allPermutations, currentPermutationIndex, currentSudoku)
        //     if sudoku is not null
        //        return sudoku
        //     currentSudoku.remove(currentSudoku.size())
        //
        // O(N!!) ???
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char cell = board[i][j];
                if (cell != '.') {
                    continue;
                }

                for (char letter = '1'; letter <= '9'; letter++) {
                    if (isValid(board, i, j, letter)) {
                        board[i][j] = letter;
                        if (solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }

                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char letter) {
        for (int i = 0; i < 9; ++i) {
            if (i != col && board[row][i] == letter) {
                return false;
            }
            if (i != row && board[i][col] == letter) {
                return false;
            }
        }
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[boxStartRow + i][boxStartCol + j] == letter) {
                    return false;
                }
            }
        }

        return true;
    }
}