Description

You will be given a square chess board with one queen and a number of obstacles placed on it. Determine how many squares the queen can attack.
A queen is standing on an NxN chessboard. The chess board's rows are numbered from 1 to N, going from bottom to top. Its columns are numbered from 1  to N, going from left to right. Each square is referenced by a tuple, (r,c) , describing the row, r , and column, c , where the square is located.

The queen is standing at position (rq, cq) . In a single move, she can attack any square in any of the eight directions (left, right, up, down, and the four diagonals). In the diagram below, the green circles denote all the cells the queen can attack from (4,4):

There are obstacles on the chessboard, each preventing the queen from attacking any square beyond it on that path. For example, an obstacle at location (3,5) in the diagram above prevents the queen from attacking cells (3,5) (2,6) and (1,7) :

Given the queen's position and the locations of all the obstacles, find and print the number of squares the queen can attack from her position at . In the board above, there are  such squares.
Function Description
Complete the queensAttack function. It should return an integer that describes the number of squares the queen can attack.
queensAttack has the following parameters:
- n: an integer, the number of rows and columns in the board
- k: an integer, the number of obstacles on the board
- r_q: integer, the row number of the queen's position
- c_q: integer, the column number of the queen's position
- obstacles: a two dimensional array of integers where each element is an array of  integers, the row and column of an obstacle
  Function Signatures
  Java
  static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {}
  Python
  def queensAttack(n, k, r_q, c_q, obstacles):
  Constraints
  N <= 10^5
  K < 10^5
  A single cell may contain more than one obstacle.
  There will never be an obstacle at the position where the queen is located.

Sample Input 0
```
4 0
4 4
```

Sample Output 0
```
9
```

Explanation 0
The queen is standing at position  on a  chessboard with no obstacles:

Sample Input 1
```
5 3
4 3
5 5
4 2
2 3
```

Sample Output 1
```
10
```

Explanation 1
The queen is standing at position  on a  chessboard with  obstacles:

The number of squares she can attack from that position is .
Sample Input 2
```
1 0
1 1
```

Sample Output 2
```
0
```

Explanation 2
Since there is only one square, and the queen is on it, the queen can move 0 squares.

## Reference
https://www.hackerrank.com/challenges/queens-attack-2/problem

## Solutions
https://gist.github.com/faermanj/87efa2246eb4a2c5a5fa145fb8b9aa3a (Python)
https://gist.github.com/mreaugusto/bddfd37bc3b713d96b9ed91f935784aa (Java)
https://gist.github.com/fcbarros/c7e1c58af532b6d6bf2cd96de88f6cea (Java)

## Ranking
Gold Rank: 60 min
Silver Rank: 90 min
Bronze Rank: 120 min

