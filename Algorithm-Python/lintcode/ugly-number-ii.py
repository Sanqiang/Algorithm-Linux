import heapq

class Solution:
    """
    @param {int} n an integer.
    @return {int} the nth prime number as description.
    """
    def nthUglyNumber(self, n):
        # write your code here
        method = "mex"
        if method == "me":
            if n <= 1:
                return 1
            n -= 1
            heap = []
            dup = {2:True,3:True,5:True}
            heapq.heappush(heap,2)
            heapq.heappush(heap,3)
            heapq.heappush(heap,5)

            while True:
                cur = heapq.heappop(heap)
                n -= 1
                if n == 0:
                    return cur
                else:
                    if cur*2 not in dup:
                        heapq.heappush(heap,2 * cur)
                    dup[cur * 2] = True
                    if cur*3 not in dup:
                        heapq.heappush(heap,3 * cur)
                        dup[cur * 3] = True
                    if cur*5 not in dup:
                        heapq.heappush(heap,5 * cur)
                        dup[cur * 5] = True
        else:
            if n <= 1:
                return n

            n -= 1
            key = [2, 3, 5]
            h = []
            for i in range(3):
                heapq.heappush(h, (key[i], i))

            value = key[0]
            while n > 0:
                value, level = heapq.heappop(h)
                while level < 3:
                    new_value = key[level] * value
                    heapq.heappush(h, (new_value, level))
                    level += 1
                n -= 1
            return value

sol = Solution()
n = sol.nthUglyNumber(9)
print(n)