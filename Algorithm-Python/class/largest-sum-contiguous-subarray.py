def maxSubArraySum(a,size):
    max_value = a[0]
    max_sofar = max(0, a[0])
    for i in range(1, size):
        if max_sofar + a[i] > 0:
            max_sofar = max_sofar + a[i]
        else:
            max_sofar = 0
        max_value = max(max_sofar, max_value)

    print(max_value)

if __name__ == '__main__':
    a  = [-2, -3, 4, -1, -2, 1, 5, -3]
    maxSubArraySum(a, len(a))