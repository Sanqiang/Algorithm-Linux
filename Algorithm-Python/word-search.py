class Solution(object):
    def existRecursive(self, board, word, row, col,nrow,ncol, ind,nword):

        if board[row][col] == word[ind]:
            temp = board[row][col]
            board[row][col] = '*'
            if ind == nword - 1:
                return True
            elif (row + 1 < nrow and board[row + 1][col] != '*' and self.existRecursive(board, word, row + 1, col,nrow,ncol,
                                                                               ind + 1,nword)) or (
                                    row - 1 >= 0 and board[row - 1][col] != '*' and self.existRecursive(board, word, row - 1,
                                                                                               col,nrow,ncol,
                                                                                               ind + 1,nword)) or (
                                    col + 1 < ncol and board[row][col + 1] != '*' and self.existRecursive(board, word, row,
                                                                                                 col + 1,nrow,ncol,
                                                                                                 ind + 1,nword)) or (
                                    col - 1 >= 0 and board[row][col - 1] != '*' and self.existRecursive(board, word, row,
                                                                                               col - 1,nrow,ncol,
                                                                                               ind + 1,nword)):
                return True
            board[row][col] = temp
        else:
            return False

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        nrow = len(board)
        ncol = len(board[0])
        nword = len(word)

        for row in range(0, nrow):
            for col in range(0, ncol):
                if board[row][col] == word[0] and self.existRecursive(board, word, row, col,nrow,ncol, 0,nword):
                    return True
        return False


s = Solution()
