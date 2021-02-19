# Gifting Groups
At an audiobooks company, customers can give an audiobook from their library to any other non-subscriber to kick start their subscription. The first time subscriber can receive up to a maximum of N audiobooks from their friends/relatives. When a non-subscriber receives an audiobook, we can infer that the two may be related. Similarly, if the non-subscriber receives gifted books from two other subscribers, we can infer that all of them are related and the three of them form a group. More formally, a group is composed of all the people who know one another, whether directly or transitively. The company would like your help finding out the number of such distinct groups from the input data.

Description
At an audiobooks company, customers can give an audiobook from their library to any other non-subscriber to kick start their subscription. The first time subscriber can receive up to a maximum of N audiobooks from their friends/relatives. When a non-subscriber receives an audiobook, we can infer that the two may be related. Similarly, if the non-subscriber receives gifted books from two other subscribers, we can infer that all of them are related and the three of them form a group. More formally, a group is composed of all the people who know one another, whether directly or transitively. The company would like your help finding out the number of such distinct groups from the input data.

Example
Consider the following input matrix M:
110
110
001



Every row corresponds to a subscriber and the value M[i][j] determines if j was gifted a book by i. In the above example, user 0 has gifted a book to user 1 and so they are connected [0][1], while person w has not received a book from anyone. Therefore, there are 2 groups.
M[i][j] = 1 if i == j (Each person is connected to itself)

Given related[n] = array of strings of binary digits that represent connections of people, return the number of groups of people.

A sample signature for a Java method would be:

public static int countGroups(List<String> related){}
Constraints
1 <= N  <= 300
0 <= i <= n
related is a square matrix

Test Cases

Test Case 0

Output
2

Input
4
1100
1110
0110
0001



Test Case 1

Output
5

Input
5
10000
01000
00100
00010
00001



Ranking
Gold Rank: 45min
Silver Rank: 60min
Bronze Rank: 90min

Follow-Up
Summarize your approach for solving this problem
Can you estimate the complexity of your solution
Having more time, how would you improve this code
Solutions
https://gist.github.com/mreaugusto/062f48acf3a719f064cffe8211b40e3b

Example
Consider the following input matrix M:
110
110
001



Every row corresponds to a subscriber and the value M[i][j] determines if j was gifted a book by i. In the above example, user 0 has gifted a book to user 1 and so they are connected [0][1], while person w has not received a book from anyone. Therefore, there are 2 groups.
M[i][j] = 1 if i == j (Each person is connected to itself)

Given related[n] = array of strings of binary digits that represent connections of people, return the number of groups of people.

A sample signature for a Java method would be:

public static int countGroups(List<String> related){}
Constraints
1 <= N  <= 300
0 <= i <= n
related is a square matrix

Test Cases

Test Case 0

Output
2

Input
4
1100
1110
0110
0001



Test Case 1

Output
5

Input
5
10000
01000
00100
00010
00001



Ranking
Gold Rank: 45min
Silver Rank: 60min
Bronze Rank: 90min

Follow-Up
Summarize your approach for solving this problem
Can you estimate the complexity of your solution
Having more time, how would you improve this code
Solutions
https://gist.github.com/mreaugusto/062f48acf3a719f064cffe8211b40e3b

