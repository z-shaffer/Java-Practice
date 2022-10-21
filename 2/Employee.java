public class Employee
{
    
    private String name;
    private int id;
    private double pay;
    
    public Employee(String initName, int initId, double initPay)
    {
       name = initName;
       id = initId;
       pay = initPay;
    }
    
    public String getName()
    {
        return name;
    }
    
        public int getId()
    {
        return id;
    }
    
        public double getPay()
    {
        return pay;
    }
    
        public void setName(String changeName)
    {
        name = changeName;
    }
    
        public void setId(int changeId)
    {
        id = changeId;
    }
    
        public void setPay(double changePay)
    {
        pay = changePay;
    }
    
            public void giveRaise(double amount)
    {
        pay += amount;
    }
    
            public void printInfo()
    {
        System.out.println("Employee Name:\t" + name);
        System.out.println("Employee ID:\t" + id);
        System.out.printf("Employee Pay:\t$%.2f", pay);
    }
}
