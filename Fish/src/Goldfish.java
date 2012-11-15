
import java.io.*;
class Goldfish extends Herbivore //?interface
{
	String nationality;
	int wishes;//nr dorintelor
	
	public Goldfish() throws Exception
	{
		super();
		BufferedReader br = new BufferedReader(new
				InputStreamReader(System.in));
		//System.out.print(" Pestele dat  este Pestisor de aur.");
		System.out.print(" Nationalitatea: " );
		nationality = br.readLine();
		System.out.print(" Dorinte: " );
		wishes = Integer.parseInt (br.readLine());
		//System.out.print(" ************************************\n ");	
	}
	
	
	public Goldfish(String n,String c,float w,float l,int s,int sc,float a,int new_wishes)
	{
		super(n,c,w,l,s,sc,a);
		//System.out.print(" Pestele dat  este Pestisor de aur.");
		nationality = "Japonez";
		wishes = new_wishes;
			
	}
	
	
//METODELE GET
	public String get_nationality()
	{
		return nationality;
	}
	public int get_wishes()
	{
		return wishes;
	}
	
//METODELE SET
	public void set_nationality(String nationality)
	{
		this.nationality = nationality;
	}
	public void set_wishes(int new_wishes)
	{
		wishes = new_wishes;
	}
	
	
	
	public void printInfo()
	{
		super.printInfo();
		System.out.println(" Nationalitatea pestisorului de aur: "+" "+ nationality);
		System.out.println(" Dorintele pestesorului de aur: "+" "+ wishes);
		System.out.println(" \n ");
	}
	
	public int fry()
	{
		
		System.out.println(" De teama sa fie prajit,Pestisorul de aur a promis sa infaptuiasca: ");
		wishes = (int)(((float)this.wishes) * 1.5);
		System.out.println( wishes + " " + " dorinte!!!");
		System.out.println(" Ce superb!");
		return wishes;
	}
	
	public String toString()
	 {
		 String str = "";
		 str += name + " ";
		 str += color + " ";
		 str += Float.toString(weight) + " ";
		 str += Float.toString(length) + " ";
		 str += Integer.toString(speed) + " ";
		 str += Integer.toString(scars) + " ";
		 str += Float.toString(acceleration) + " ";
		 str += Boolean.toString(life) + " ";
		 str += nationality + " ";
		 str += Integer.toString(wishes) + " ";
		
		 return str;
	 }		  
	
}
