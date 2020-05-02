import java.util.*;
public class Divisors
{
    public static void main(String args[])
    {

    System.out.println("Enter the number");

    Scanner s=new Scanner(System.in);

    int n=s.nextInt();
    for(int i=1;i<=n;i++)
    {
    
          
      if(n%i==0)
      {
        System.out.print(i+", ");
      }
    }
    
    
    System.out.print("are divisors of "+n);
    
    }
}
