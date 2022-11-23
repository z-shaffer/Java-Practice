/*
* Playing with nuts solutions in 3667 cookies assignment
*/


class Demo {
   public static void main(String[] args) {
	   System.out.println("Cookies!");
	   Cookie s = new SugarCookie();
	   System.out.println(s);
	   System.out.println("calories = " + s.calories());
	   System.out.println("nuts= " + s.hasNuts());
	   System.out.println("--------");

	   Cookie ss = new Sprinkles(s);
	   System.out.println(ss);
	   System.out.println("calories = " + ss.calories());
	   System.out.println("nuts= " + ss.hasNuts());
	   System.out.println("--------");

	   Cookie nss = new Walnuts(ss);
	   System.out.println(nss);
	   System.out.println("calories = " + nss.calories());
	   System.out.println("nuts= " + nss.hasNuts());
	   System.out.println("--------");

	   Cookie snss = new Sprinkles(nss);
	   System.out.println(snss);
	   System.out.println("calories = " + snss.calories());
	   System.out.println("nuts= " + snss.hasNuts());
	   System.out.println("--------");

	   Cookie ssnss = new Sprinkles(snss);
	   System.out.println(ssnss);
	   System.out.println("calories = " + ssnss.calories());
	   System.out.println("nuts= " + ssnss.hasNuts());

	String[] toppings = {"Sprinkles","Walnuts"};
	CookieFactory factory = new CookieFactory();
	CookieStore store = new CookieStore(factory);
	Cookie yum = store.orderCookie("SugarCookie", toppings);
	System.out.println("FINAL: " + yum);
   }
}
