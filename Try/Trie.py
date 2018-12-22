class Node():
    
    def __init__(self):
        self.children = {}
        self.value = None

class Trie():
    def __init__(self, strings, values):
        self.root = Node()
        for index, string in enumerate(strings):
            self.insert(string, values[index])
    
    def find(self, string):
        node = self.root
        for char in string:
            if char in node.children:
                node = node.children[char]
            else:
                return None

        return node.value

    def insert(self, string, value):
        if self.root is None:
            self.root = Node()
        
        node = self.root
        lastIndex = None
        for index, char in enumerate(string):
            if char in node.children:
                node = node.children[char]
            else:
                lastIndex = index
                break

        if lastIndex != None:
            length = len(string)
            for i in range(index, length):
                node.children[string[i]] = Node()
                node = node.children[string[i]]

        node.value = value


if __name__ == '__main__':
    t = Trie(['abc', 'abcd', 'aefefe', 'asda', 'fgddfg'],['abc', 'abcd', 'aefefe', 'asda', 'fgddfg'])
