/*

Class: CSCI 470 - 2
Program: Assignment 2 (Rational Number Class)
Author: Priyanka Kondapuram
Z-ID: Z1795449
Due Date: 10/04/2017

Purpose: To implement the Rational Number class.

*/


import java.lang.Math;

public class Ratl
{
  private int num;
  private int denom;

  public Ratl() //Default constructor. Taking the zero and 1.
  {
    num = 0;
    denom = 1;
  }
  public Ratl(int num, int denom)  //Copying the given values to the numeratore and denominator
  {
    this.num = num;
    this.denom = denom;
    int g = gcd(num, denom);   //calling gcd function.
    num = num/g;
    denom = denom/g;
  }
  public Ratl(Ratl a)
  {
    num = a.num;
    denom = a.denom;
  }

/*Implementing the Getters*/

  public int getNum()
  {
    return num; //Returning the numerator.
  }
  public int getDenom()
  {
    return denom; //Returning the denominator.
  }
/*Implementing the Setters*/
  public void setNum(int num)
  {
    this.num = num; //Setting the numerator.
  }
  public void setDenom(int denom)
  {
    this.denom = denom; //Setting the denominator.
  }

  @Override
  public String toString() //Implementing the toString.
  {
   String ratresult;
   if(denom == 1)
   {
     ratresult = String.format(num + ""); //Formatting string if denom is 1.
   }
   ratresult = String.format(num + "/" + denom); //Formatting string for all other values.
   return ratresult;
  }

  public void reduce() //Implementing the reduce function.
  {
    int gcd = gcd(num,denom); //Calling gcd.
    num = num/gcd;
    denom = denom/gcd;
    if(denom < 0)
    {
      denom = -denom;     //Removing the negative signs from the denominator.
      num = -num;
    }
  }

  public void add(Ratl b) // Implementing the add function.
  {
    this.num = (num * b.getDenom()) + (b.getNum() * denom);
    this.denom = denom * b.getDenom();
    this.reduce();
  }
  public void sub(Ratl b) // Implementing the subtraction function.
  {
    this.num = (num * b.getDenom()) - (b.getNum() * denom);
    this.denom = denom * b.getDenom();
    this.reduce();
  }
  public void mult(Ratl b) // Implementing the multiplication function.
  {
    this.num = (num * b.getNum());
    this.denom = (denom * b.getDenom());
    this.reduce();
  }
  public void div(Ratl b) // Implementing the division function.
  {
    this.num = this.num / b.num;
    this.denom = this.denom / b.denom;
    this.reduce();
  }



  public static int gcd(int a, int b) // Implementing the gcd function.
  {
    a = Math.abs(a);
    b = Math.abs(b);
    while(b != 0)
    {
      int c = a % b;
      a = b;
      b = c;
    }
    return a; // returing the gcd.
  }


  public static Ratl negate(Ratl a) // Implementing the Negate function.
  {
    a.num = -a.num;
    a.denom = -a.denom;
    a.reduce(); // calling the reduce function.
    return a;
  }

  public static Ratl invert(Ratl a) // Function to return the inverted value.
  {
    int temp = a.num;
    a.num = a.denom;
    a.denom = temp; // Storing the denom in num and num in denom.
    a.reduce();
    return a;
  }

/* Implementing the nom member functions (add, sub, mult and div)  */

  public static Ratl add(Ratl a, Ratl b)
  {
    Ratl temp = new Ratl();
    temp.num = a.num * b.denom + b.num * a.denom;
    temp.denom = a.denom * b.denom;
    temp.reduce();
    return temp;
  }

  public static Ratl sub(Ratl a, Ratl b)
  {
     Ratl temp = new Ratl();
     temp.num = a.num * b.denom - b.num * a.denom;
     temp.denom = a.denom * b.denom;
     temp.reduce();
     return temp;
  }

  public static Ratl mult(Ratl a, Ratl b)
  {
    Ratl temp = new Ratl();
    temp.num = a.num * b.num;
    temp.denom = a.denom * b.denom;
    temp.reduce();
    return temp;
  }

  public static Ratl div(Ratl a, Ratl b)
  {
    Ratl temp = new Ratl();
    temp.num = a.num * b.denom;
    temp.denom = a.denom * b.num;
    temp.reduce();
    return temp;
  }

/* Member functions (identical rational numbers and equivalent rational numbers) */

  public boolean ident(Ratl a)
  {
    if(this.num == a.num)
    {
      return true; // Returing true if numerators are identical.
    }
    if(this.denom == a.denom)
    {
      return true; // Returing true if the denominators are identical.
    }
    else
    {
      return false; // else returing false.
    }
  }

  public boolean equiv(Ratl a) // Checking for quivalence.
  {
    if (this.num * a.denom == this.denom * a.num)
    {
      return true; // Returing true if the values are equal.
    }
    else
    {
      return false; // else returning false.
    }
  }

  public static boolean ident(Ratl a, Ratl b) // Non member function.
  {
    if(a.num != b.num)
    {
      return false; // Returning false if num is not identical.
    }
    if(a.denom != b.denom)
    {
      return false; // Returning false if the denom is not identical.
    }
    else
    {
      return true; // else returning true.
    }
  }

  public static boolean equiv(Ratl a, Ratl b) // Non member function.
  {
    if (a.num * b.denom == a.denom * b.num)
    {
      return true; //returning true if denoms are equivalent.
    }
    else
    {
      return false; // else returning false.
    }
  }
}
