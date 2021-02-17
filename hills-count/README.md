Counting Mountains
Given the topology of a terrain, your task is to count the number of mountains. 
A series of characters is considered a mountain if and only if it goes up and back to the initial "sea level", disregarding the accidents and slopes in between. 

The topology is described as a string, be composed of "U", "D" and "X" characters according to the change of terrain upwards, downwards or equal. 
For example, this mountain:

```
    --
   /..\/\
  /......\
_/........\_
```
Would be represented as "XUUUXXDUDDDX" and so your code should return 1.

Other samples:
"UD" => 1
"UDXUUDDX" => 2
"XDUX" => 0

