package arun;
import java.util.*;
import java.util.Map.Entry;
class FoodOrder
{
	static int amount;
	static int BillAmount=0;
	static int n;
	static Scanner scn = new Scanner(System.in); 
	static LinkedHashMap<String, Integer> fd = new LinkedHashMap<String, Integer>();
	static Map<String, Integer>  fo = new LinkedHashMap<>();
	FoodOrder()
	{
		fd.put("idly",20);
		fd.put("dosa",30);
		fd.put("pongal",30);
		fd.put("upma",30);
		fd.put("chapati",20);
		fd.put("curdrice",40);
		fd.put("tomatorice",40);
		fd.put("lemonrice",30);
		fd.put("chickenbiryani",100);
		fd.put("muttonbiryani",150);
		fd.put("eggbiryani",80);
		fd.put("nonvegmeal",90);
		fd.put("chillychicken",70);
		fd.put("chicken65",80);
		fd.put("lolipop",80);
		}
	void calculation(String ufood) {
		int price =fd.get(ufood);
		 System.out.println("Enter your quantity:");
         n = scn.nextInt();
         if(n>0){
              amount = n*price;
              fo.put(ufood,amount);
              BillAmount += amount;
         }
         else{
             System.out.println("Enter your valid quantity!!");
             
         }
	}
	
}
public class OnlineFoodOrder extends FoodOrder {
	static int amount;
	static int i=0;
	static String ufood;
	
	public static void main(String agrs[]) {
		System.out.println("Dear customer please enter your name to go next:");
        String cus_name = scn.nextLine();
        System.out.println("\n-------- " + "Dear "+cus_name +", Welcome to My Online Food order portal! --------\n\n");
		System.out.println("Here is our menu: \n");
		OnlineFoodOrder z = new OnlineFoodOrder(); 
		for(Map.Entry m : fd.entrySet()){    
		    System.out.println(m.getKey()+"   -  "+m.getValue());
		}
		try{ 
		boolean wantAddMore = true;
		while(wantAddMore) {
		System.out.println("\nEnter your food would you like to order:");
		String ufood=scn.next().trim();
		ufood=ufood.toLowerCase();
		Set<Entry<String,Integer>> entrySet =fd.entrySet();
		for(Entry<String,Integer> entry : entrySet){
			if (entry.getKey().equals(ufood)) {
				z.calculation(ufood);
				//i++;
				break;
			}
			else if(entry.getKey().equalsIgnoreCase("lolipop")) {
				System.out.println("Food not Available");
			}		
		}
		System.out.println("To continue---> press.1\n To place your Order---> press2.");
		int r =scn.nextInt();
		if(r!=1){
			if (r==2) {
				wantAddMore= false;
			}
			else {
				System.out.println("Enter Valid Number");
			}
		
		}
		}}
		catch(Exception e)
		{
			System.err.println("pls enter valid data!");
		}
		System.out.print("\nDear "+cus_name +", You have ordered: \n---------------------------------");
		System.err.println("\nitem   "  + " qty" + "   amount");
		for(Map.Entry s : fo.entrySet()){    
		    System.out.println(s.getKey()+"    "+n+"       "+s.getValue());
		}
		System.out.println("----------------------------------");
		System.out.println("\n Your Total bill Amount is RS."+BillAmount+"/--");
		}
	}
