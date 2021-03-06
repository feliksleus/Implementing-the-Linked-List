# Implementing-the-Linked-List
Consider a grid (in Manhattan) and a taxi driver who drives around Manhattan. In this exercise, we implement methods on a linked list which lists Taxi driver’s move in a single day, called TaxiMove class. You must write and revise the following methods: 

1. (20 pts) Move Class : stores a position on the grid as two integers from 0 to 50, an integer that stores integer fuel level (max 100) of the cab at that position, and finally a double that stores current balance of the cab. 


2. (10 pts) boolean validMoveCheck(int a, int b) inside Move Class : Checks if a move from a position stored in Move m to a point in grid (a,b) is reachable under the current fuel level. Remember, moving a block costs a fuel. For example, if current fuel level is 5, a move from (2,4) to (11,0) is not a valid move. If reachable, should output yes. Otherwise, should return false 

3. (10 pts) fillGas() should add a Move to the linked list such that (a) the position stays the same (b) current fuel level becomes 100 (by default) (c) deducts 0.5 per unit of gas that were filled (d) if there is not enough balance to fill the gas to 100, fill the fuel with current balance. For example if the current balance is 20.3 and 0 fuel level, after fillGas() method is called, it should have 0.3 current balance and 40 fuel level. 

4. (30 pts) add(int a, int b) should do the following: checks if (a,b) is reachable if yes, create Move with the following updates to fuel level and current balance ; (a) fuel level should decrease per block moved. For instance a move from (2,3) to (4,6) should pay 2 + 3 = 5 in fuel; (b) balance should increase (0.8) per block moved. For example the above move should increase the balance by 5. (c) last node is updated accordingly If not, then check if it is reachable after calling fillGas() method (** You should not call fillGas() method, it would add a Move, but we do not want to add a move at this point) If yes, then call fillGas() method then do the update as described above. If no even after filling gas, then should output an illegal argument error. 1 

5. A Constructor with following parameter • (10pt) With no parameter, the linked list should be a singly linked list with a simple element : cab at 0,0 with maximum fuel level (100) and 0 balance. 6. (20 pt) printMoves() : print all moves in the linked list as a String. For example if (1,5), (2,6), (8,9) were on linked list, it should print as “(1,5) → (2,6) → (8,9)”.
