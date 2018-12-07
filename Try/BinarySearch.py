# get 3
a = [1, 1, 2, 2, 3, 4, 4, 5, 5]
b = [1, 2, 2, 3, 3, 4, 4, 5, 5]
c = [1, 1, 2, 2, 3, 3, 4, 4, 5]


def bianry_search(a):
    left = 0
    right = len(a) - 1
    while left + 1 < right:
        mid = left + (right - left) // 2
        

