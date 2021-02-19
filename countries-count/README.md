# Country Counting

Your task is to count the number of countries in a map. The map is encoded as a matrix of integers representing the colors of each position. Two positions are in the same country if they are neighbours up, down, left or right) and have the same color.

For example:
```
{
{ 5, 4, 4 },
{ 4, 3, 4 },
{ 3, 2 ,4 },
{ 2, 2 ,2 },
{ 3, 3 ,4 },
{ 1, 4 ,4 },
{ 4, 1 ,1 },              
}
=> 11
```

Identifying countries:
```
{
{ 1, 2, 2 },
{ 3, 4, 2 },
{ 5, 6 ,2 },
{ 6, 6 ,6 },
{ 7, 7 ,8 },
{ 9, 8 ,8 },
{ 10, 11 ,11 },           
}
```