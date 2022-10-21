import java.util.Scanner;
public class EmployeeDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        String name;
        int id;
        double pay;
        Employee testEmployee;
        
        System.out.print("Enter your name: ");
        name = keyboard.nextLine();
        System.out.print("Enter your ID: ");
        id = keyboard.nextInt();
        System.out.print("Enter your pay: ");
        pay = keyboard.nextDouble();
        System.out.println("");
        testEmployee = new Employee(name, id, pay);
        testEmployee.printInfo();
    }

}
