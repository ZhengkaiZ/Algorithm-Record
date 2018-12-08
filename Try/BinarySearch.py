a = [1, 1, 2, 2, 3, 4, 4, 5, 5]
b = [1, 2, 2, 3, 3, 4, 4, 5, 5]
c = [1, 1, 2, 2, 3, 3, 4, 4, 5]

def bianry_search(a):

    if a is None or len(a) == 0:
        return -1

    left = 0
    right = len(a) - 1
    while left + 2 < right:
        mid = left + (right - left) // 2
        if a[mid] == a[mid + 1]:
            mid += 1
        if (mid % 2) == 1:
            left = mid
        else:
            right = mid

    if left == 0 or a[left] != a[left - 1]:
        return left
    if right == len(a) - 1 or a[right] != a[right - 1]:
        return right

    return -1

print(bianry_search(a))
print(bianry_search(b))
print(bianry_search(c))


