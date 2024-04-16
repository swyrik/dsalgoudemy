### Full binary tree
The tree nodes points to either two nodes or no nodes.
If a node has only one child it is not a full binary tree.

### Perfect Binary Tree
If all the nodes are filled at all the levels is called Perfect binary tree

### Complete Binary Tree
All levels are completed filled except the last level.
Nodes in the last level are filled from left to right

### Balanced Binary Tree
Height of the tree should be O(log N)
constraint: [ left subTree - right subTree ] <= 1


### Degenerate/Pathological Tree
Every internal node has only one child
Performance wise same as LinkedList


linked list is best suited for insert operation
BST is best suited for lookup and remove operations

Breadth First Search
    BFS uses queue to traverse level wise

Depth First Search
    DFS uses stack to traverse depth wise
    we have 
    - pre order
    - post order
    - in order

inOrder -> (a+b) (left root right)
preOrder -> (+ab) (root left right)
postOrder -> (ab+) (left right root)


The inroder values are always in sorted order