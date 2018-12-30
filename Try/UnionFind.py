class UnionFind:
    def __init__(self, n):
        self.father = []
        for i in range(n + 1):
            self.father.append(i)

    def find(self, target):
        path = []
        while self.father[target] != target:
            path.append(target)
            target = self.father[target]

        for n in path:
            self.father[n] = target

        return target

    def union(self, a, b):
        self.father[self.find(a)] = self.find(b)

if __name__ == '__main__':
    uf = UnionFind(10)
    uf.union(1, 10)
    uf.union(10, 2)
    uf.union(10, 3)
    print(uf.find(10))
    print(uf.find(1))

