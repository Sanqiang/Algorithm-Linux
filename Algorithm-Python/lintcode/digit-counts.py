class Solution:
    # @param k & n  two integer
    # @return ans a integer
    def digitCounts(self, k, n):
        result = 0
        for cur in range(0,n+1):
            while True:
                if cur%10 == k:
                    result += 1
                cur /= 10
                if cur == 0:
                    break
        return result