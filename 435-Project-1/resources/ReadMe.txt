for BFS i am using the built in priority queue and the priority is equal to the order they are entered into it
so add and remove are O(1) so the the search time is O(b^d) where d is the depth of the goal.

for DFS and DLS i am using  the built in stack so the add and remove functions are O(1) so for DFS the time 
is O(b^m) where m is the max possible depth and for DLS the time is O(b^d) where d is the specified limited depth

for A* and greedy search i am using the built in priority queue so the add and remove functions are O(log(n))
so for A* the worst case runtime would be O(log(n)*b^d) where d is the depth of the shortest path. and for greedy the 
worst case would be O(log(n)* b^m) where m is the max possible depth.


Start Board: 26341 B759A8DEFC
End Board: 123456789ABCDEF 
Nodes Created: 18681
Nodes Expanded: 6001
Depth: 10
Max Fringe: 9471
Search Used: BFS

Start Board: 26341 B759A8DEFC
End Board: 123456789ABCDEF 
Nodes Created: 407029
Nodes Expanded: 269121
Depth: 16
Max Fringe: 37
Search Used: DLS
Max Depth: 20

Start Board: 26341 B759A8DEFC
End Board: 123456789ABCDEF 
Nodes Created: 33
Nodes Expanded: 11
Depth: 10
Max Fringe: 24
Search Used: AStar
Heuristic Used: h1

Start Board: 26341 B759A8DEFC
End Board: 123456789ABCDEF 
Nodes Created: 101
Nodes Expanded: 33
Depth: 10
Max Fringe: 61
Search Used: AStar
Heuristic Used: h2

Start Board: 26341 B759A8DEFC
End Board: 123456789ABCDEF 
Nodes Created: 33
Nodes Expanded: 11
Depth: 10
Max Fringe: 24
Search Used: GBFS
Heuristic Used: h1

Start Board: 26341 B759A8DEFC
End Board: 123456789ABCDEF 
Nodes Created: 245
Nodes Expanded: 80
Depth: 16
Max Fringe: 116
Search Used: GBFS
Heuristic Used: h2

Start Board: 123456789AB DEFC
End Board: 123456789ABCDEF 
Nodes Created: 3
Nodes Expanded: 2
Depth: 1
Max Fringe: 3
Search Used: BFS

Start Board: 123456789AB DEFC
End Board: 123456789ABCDEF 
Nodes Created: 3
Nodes Expanded: 2
Depth: 1
Max Fringe: 3
Search Used: DFS

Start Board: 123456789AB DEFC
End Board: 123456789ABCDEF 
Nodes Created: 3
Nodes Expanded: 2
Depth: 1
Max Fringe: 3
Search Used: DLS
Max Depth: 2

Start Board: 123456789AB DEFC
End Board: 123456789ABCDEF 
Nodes Created: 3
Nodes Expanded: 2
Depth: 1
Max Fringe: 3
Search Used: AStar
Heuristic Used: h1

Start Board: 123456789AB DEFC
End Board: 123456789ABCDEF 
Nodes Created: 3
Nodes Expanded: 2
Depth: 1
Max Fringe: 3
Search Used: AStar
Heuristic Used: h2

Start Board: 123456789AB DEFC
End Board: 123456789ABCDEF 
Nodes Created: 3
Nodes Expanded: 2
Depth: 1
Max Fringe: 3
Search Used: GBFS
Heuristic Used: h1

Start Board: 123456789AB DEFC
End Board: 123456789ABCDEF 
Nodes Created: 3
Nodes Expanded: 2
Depth: 1
Max Fringe: 3
Search Used: GBFS
Heuristic Used: h2

Start Board: 123456789A BDEFC
End Board: 123456789ABCDEF 
Nodes Created: 7
Nodes Expanded: 3
Depth: 2
Max Fringe: 6
Search Used: DFS

