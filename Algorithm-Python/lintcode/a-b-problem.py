import sys

class Solution:
    """
    @param a: The first integer
    @param b: The second integer
    @return:  The sum of a and b
    """
    def aplusb(self, a, b):
        # write your code here, try to do it without arithmetic operators.
        method = "seq"
        if method == "xor":
            while b > 0:
                sum = a^b
                carry = (a&b)<<1
                a = sum
                b = carry
            return sum
        elif method == "seq": #todo : http://stackoverflow.com/questions/37135106/what-is-good-way-to-negate-an-integer-in-binary-operation-in-python
            len = sys.getsizeof(a)
            mask_sign = 1<<(len-1)

            neg = False
            if ((a<0 and b>0 and abs(a)>abs(b)) or (a>0 and b<0 and abs(a)<abs(b)) or (a<0 and b<0)):
                a = -a
                b = -b
                neg = True

            carry = 0
            sum = 0
            mask = 1
            while mask < mask_sign or mask < mask_sign:
                cur_a = a & mask
                cur_b = b & mask
                if cur_a == mask and cur_b == mask:
                    if carry == 1:
                        sum |= mask
                    carry = 1
                elif cur_a ==mask or cur_b ==mask:
                    if carry == 1:
                        carry = 1
                    else:
                        sum |= mask
                        carry = 0
                else:
                    if carry:
                        sum |= mask
                    carry = 0
                mask <<= 1

            if neg:
                sum = -sum

            return sum

s = Solution()
res = s.aplusb(-2,-5)
print(res)