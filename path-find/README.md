
Finding a Path
Given a map of connected cities, your taks is to check if there is a viable path between two requested cities. Cities are represented as integers, and a request for a path is encoded in a string as follows:

First line: Total of cities Second line: Initial and destination cities, separated by spaces Other lines: Connected cities pair, separated by spaces, one per line

Consider that a city is always connected to itself. For example the map:

0-1 2-3-4
|
5 6 7 8 9
Checking for a path from 7 to 4 would be encoded as:

10
7 4
0 1
7 2
2 3
3 4
And your code should return true

Other cases:

10
1 1
=> true

10
1 3
=> false

10
1 3
1 2
2 3
=> true

