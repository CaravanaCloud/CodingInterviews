# Robot Loop

Your task is to detect cycles in a series of robot instruction sets, so that it does not get stuck.
The instructions represent movements in a cartesian grid and can be: "G" for go ahead, "R" for turn right or "L" for turn left.

So that:

INPUT
"""
L
G
GR
"""

OUTPUT
"""
YES # Robot in the same position turning left
NO  # Robot going infinitely ahead
YES # Robot moves in a square
"""
