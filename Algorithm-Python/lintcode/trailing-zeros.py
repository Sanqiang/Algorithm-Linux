class Solution:
    # @param n a integer
    # @return ans a integer
    def trailingZeros(self, n):
        zero_count = 0
        while n != 0:
            n /= 5
            zero_count += 1
        return zero_count


solu = Solution()
z = solu.trailingZeros(10)
print(z)