import  math

class Solution:
    # @param k & A a integer and an array
    # @return ans a integer
    def kthLargestElement(self, k, A):
        start = 0
        end = len(A)-1

        while True:
            pivot_idx  = self.partition(A,start,end)
            if pivot_idx == k:
                return A[k]
            elif pivot_idx > k:
                end = pivot_idx-1
            else:
                start = pivot_idx+1

    def partition(self, A, start, end):
        pivot = A[math.floor((start+end)/2)]
        while start < end:
            for start in range(start,end+1,1):
                if A[start] <= pivot:
                    break
            for end in range(end,start-1,-1):
                if A[end] >= pivot:
                    break
            if start < end:
                self.swap(A,start,end)
                start+=1
                end-=1
        return start

    def swap(self,A,i,j):
        temp = A[i]
        A[i] = A[j]
        A[j] = temp

sol = Solution()
kl = sol.kthLargestElement(4,[3,5,2,3,1])
print(kl)