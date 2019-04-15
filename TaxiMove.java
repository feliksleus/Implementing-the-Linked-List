public class TaxiMove {

	
	
  public static class Move {
    // Your definition of Move Class, as similar to Node class in class
    // Exercise 1
	  
    public int x; // first coordinate in (x, y)
    public int y; // second coordinate in (x, y)
    public int fuel; // fuel amount
    public double balance; // balance
    public Move next; //
    public Move prev;
    
    public Move() {
    	x = 0;
    	y = 0;
    	fuel = 100;
    	balance = 0;
    }
    
    public Move(int x, int y) {
    	this.x = x;
    	this.y = y;
    	fuel = 100;
    	balance = 0;
    }
    
    public Move(int x, int y, int fuel, double balance) {
    	this.x = x;
    	this.y = y;
    	this.fuel = fuel;
    	this.balance = balance;
    }
    
    
    
    // You should also create constructors

    public boolean validMoveCheck(int a, int b) {
    	boolean flag = true;
    	
    	if ((a > 50) || (b > 50)) // the coordinates can't exceed 50.
    		flag = false;
      // Exercise 2
    	
    	else
    	{
	    	int distance = Math.abs((x - a) + (y - b)); // getting the fuel spent for the distance between two points: (x,y) and (a, b).
	    	
	    	if (distance > fuel) {
	    		flag = false;
	    		}
	    	
	    	else {
	    		flag = true;
	    	}
    	}
    	
    	return flag;
    }
    
    
  }

  public Move header; // This is a "ghost" Move
  private Move last; // This should store the last actual Move, but not the tail (this is a real Move)
  public int size = 1; 
  


  public int size() { return size; }
  

  public TaxiMove() {
	    // Initial Constructor :: Exercise 5
      last = new Move();
      header = last;

	  }

 
  
  public void fillGas() {
  	 // Exercise 3
	  
	  // create a clone.
	  Move clone = new Move(last.x, last.y, last.fuel, last.balance); // the next of last will be the clone variable.
	  this.last.next = clone;
	  clone.prev = this.last;
	  this.last = clone;
	  

	  size++;
	  
	   while (((this.last.balance - 0.5) >= 0) && (this.last.fuel < 100))  // once the 100 limit for the fuel is reached AND the balance 
		   													    //will be 0 or greater, after subtracting 0.5 from the current
    	  													   // amount, keep withdrawing the 0.5 units from the balance, while adding 1 unit to the fuel tank.
      {
        this.last.balance -= 0.5;
        this.last.fuel += 1;
      }
	  
       
	  
  }

  public void add(int a, int b) throws IllegalArgumentException  {
    // Exercise 4
	  
     
	  if (this.last.validMoveCheck(a, b))
	  {
		  Move newest_block = new Move(a, b); // creating a new node
		 		  
			 
		  this.last.next = newest_block;
		  newest_block.prev = this.last; // assigning the preceding node as the header
		  this.last  = newest_block;
		  
		  // assigning the newest node as the last node. 
		  
        
        
		  int fuel_formula = Math.abs((this.last.prev.x - a) + (this.last.prev.y - b)); //finding the fuel usage by blocks
		  double balance_formula = fuel_formula * 0.8; 
		  
		  this.last.fuel = this.last.prev.fuel - fuel_formula;
		  this.last.balance = this.last.prev.balance + balance_formula;

		  
		  size++;
		  

	  }
	  
	  else
	  
	  {
		  fillGas();
		  if (this.last.validMoveCheck(a, b))
		  {
			  Move newest_block = new Move(a, b); // creating a new node
	 		  
				 
			  this.last.next = newest_block;
			  newest_block.prev = this.last; 
			  this.last  = newest_block; // the newest block is now the recent blocl
			  
			  // assigning the newest node as the last node. 
			  
           
			  int fuel_formula = Math.abs((this.last.prev.x - a) + (this.last.prev.y - b));
			  double balance_formula = fuel_formula * 0.8;
			  
			  this.last.fuel = this.last.prev.fuel - fuel_formula;
			  this.last.balance = this.last.prev.balance + balance_formula;
           
			  size++;
		  }
		  
		  else {
			  throw new IllegalArgumentException("Invalid move");
		  }
		  
	  }
	  

  }
  
  public void printMoves() {
    // Exercise 6
	  String str = "";
	  Move current = header;
     
	  
	  for (int i = 0; i < size; i++)
	  {
		  if (current.next == null)
	        {
	           str += "(" + current.x + "," + current.y + ") "; // for the last element of the linked list
	        }
	        
	        else 
	        {
	           str += "(" + current.x + "," + current.y + ") -> ";
	        }
		  
		  current = current.next;
	  }
        
	 
	  System.out.println(str);
	  
	  
  }
  
  
  public void printBackwardsUsingNext() {
	    // Exercise 6
		  String str = "";
		  Move current = header;
	     
		  
		  while (current != null)
		  {
			  if (current.next == null)
		        {
		           str = "(" + current.x + "," + current.y + ") " + str; // for the last element of the linked list
		        }
		        
		        else 
		        {
		           str = "(" + current.x + "," + current.y + ") " + "<-" + str;
		        }
			  
			  current = current.next;
		  }
	        
		 
		  System.out.println(str);
		  
		  
	  }
  
  public void printBackwardsIteratively() {
	  String str = "";
	  Move current = last;
	  
	  while (current != null)
	  {
		  
		  if (current.prev == null)
		  {
			 str += "(" + current.x + "," + current.y + ")";
		  }
		  str +=  "(" + current.x + "," + current.y + ")" + "->";
		  current = current.prev;
	  }
	  
	  System.out.println(str);
  }
  

  public int realSum(Move current)
  {
	  Move position = current;
	  int sum = 0;
	  while (position != null)
	  {
		  if (position.next != null)
			  sum += Math.abs((position.next.x - position.x) + (position.next.y - position.y));
		  
		  position = position.next;
	  }
	  
	  return sum;
  }
  
  public int recursiveSum(Move position)
  {
	  if (position.next != null)
	  {
		  
		  int sum = Math.abs((position.next.x - position.x) + (position.next.y - position.y));
		  //sum += recursiveSum(position.next);
		  //return sum;
		  
		  return sum + recursiveSum(position.next);
		  
	  }
	  
	  else
		  return 0;
  }
  
  public int findSize(Move position) {
	  
	  if (position == null)
		  return 0;
	  
	  else 
	  {
		  
		  return 1 + findSize(position.next);
		  
		  
	  }
	  
	  
  }
  
  
  
 


}
