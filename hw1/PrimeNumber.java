import java.util.Scanner;
class PrimeNumber
{
    public static void main(String args[])
    {
        int tmp;
        boolean isPrime=true;
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter a number:");
        int num=scan.nextInt();
        scan.close();
        for(int i=2;i<=num/2;i++)
        {
            tmp = num%i;
            if(tmp==0)
            {
                isPrime = false;
                break;
            }
        }
        if(isPrime)
            System.out.println(num + " is a Prime Number");
        else
            System.out.println(num + " is not a Prime Number");
    }
}