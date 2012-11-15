import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.*;


public class Predator extends Fish implements Meeting
{
	int teeth; //nr dintilor
	float voracity;//coificientul projorlivosti
	boolean hungry = true;
	
	
	public Predator() throws Exception
	{
		super();
		BufferedReader br = new BufferedReader(new
				InputStreamReader(System.in));
		//System.out.print(" Pestele dat  este un Pradator.");
		System.out.print(" Numarul dintilor a pradatorului: " );
		teeth = Integer.parseInt (br.readLine());
		System.out.print(" Coificientul de voracitate a pradatorului: " );
		voracity = Float.parseFloat (br.readLine());
		//System.out.print(" ************************************\n  ");
	}

	public Predator(String name,String color,float new_w,float new_l,int new_s,int new_teeth,float new_voracity)
	{
		super(name,color,new_w,new_l,new_s);
		//System.out.print(" Pestele dat  este un Pradator.");
		if (new_teeth > 0)
			teeth = new_teeth;
		else
			teeth = 40;
		if ((new_voracity >0.0f) && (new_voracity <=1.0f))
			voracity = new_voracity;
		else 
			if(new_voracity==0.0f)
				System.out.println(" Pestele a murit de foame!");
			else 
				System.out.println(" Pestele a bufnit :-((( !");
			
	}

	
	//METODELE GET
	
	public int get_teeth()
	{
		return teeth;
	}
	public float get_voracity()
	{
		return voracity;
	}
	
	//METODELE SET
	
	public void set_teeth(int new_teeth)
	{
		if (new_teeth > 0)
			teeth = new_teeth;
		else
			teeth = 10;
	}
	public void set_voracity(float new_voracity)
	{
		if ((new_voracity >0) && (new_voracity <=1))
			voracity = new_voracity;
		else 
			if(new_voracity==0)
				System.out.println(" Pestele a murit de foame!");
			else 
				System.out.println(" Pestele a bufnit :-((( !");
	}
	
	public void printInfo()
	{
		//System.out.println(" \n*********************************************************** ");
		System.out.println(" \n");
		System.out.println(" Numele pradatorului: "+" "+ name);
		System.out.println(" Culoarea pradatorului: "+" "+ color);
		System.out.println(" Greutatea pradatorului: "+" "+ weight + " " + "kg");
		System.out.println(" Lungimea pradatorului: "+" "+ length + " " + "cm");
		System.out.println(" Viteza pradatorului: "+" "+ speed + " " + "m/h");
		System.out.println(" Numarul dintilor a pradatorului: "+" "+ teeth);
		System.out.println(" Coificientul de voracitate a pradatorului: "+" "+ voracity);
		//System.out.println(" ************************************************ ");
	}
	
//METODA DE SATURATIE A PRADATORULUI DE LA IERBIVOR
	public void saturation(Herbivore herbivore)
	{
		if((this.weight * voracity) == herbivore.weight)
		{   
			hungry = false;
			System.out.println(" Dar alt ierbivor nu a scapat.");
			System.out.println(" Pradatorul s-a saturat de la consumul unui ierbivor si se simte foarte bine :-)))!");
			herbivore.life = false;
			Fish.nr_fish--;
		}
		else 
			if((this.weight * voracity) > herbivore.weight)
			{
				System.out.println(" Dar alt Ierbivor nu a scapat.");
				System.out.println(" El era atit de mic,incat Pradatorul nu s-a saturat deloc!");
				herbivore.life = false;
				hungry = true;
				Fish.nr_fish--;
				int nr_herb = (int)((this.weight * voracity)/herbivore.weight);
				//Fish.nr_fish--;
				System.out.println(" Pentru satisfactia poftei,Pradatorul are nevoie de " + " " + nr_herb + " " + " ierbivori.");
				//Fish.nr_fish--;
			}
	}
			//}
		//else
			//System.out.println(" Ierbivorul era atit de mare ca Pradatorul a bufnit :-(((!");
	
	
	
//METODA STATICA DE COLIZIUNE
	public static void collision(Predator predator1, Predator predator2)
	{
		int total_speed = predator1.speed + predator2.speed; 
		if((total_speed/predator1.teeth) < predator1.teeth)
		{
			predator1.teeth = total_speed/predator1.teeth;
			System.out.println(" Pradatorul1 si-a dezbatut " + " "+ predator1.teeth + " dinti!");	
		}
		else 
			if((total_speed/predator1.teeth) == predator1.teeth)
			{
				predator1.teeth = 0;
				System.out.println(" Pradatorul1 a ramas cu " + " "+ predator1.teeth + " " + "dinti!");
			}
			
		else
			System.out.println(" Pradatorul1 a pierdut toti dintii pe care ii avea!");
		
		if((total_speed/predator2.teeth) < predator2.teeth)
		{
			predator2.teeth = total_speed/predator2.teeth;
			System.out.println(" Pradatorul2 si-a dezbatut " + " "+ predator2.teeth + " " +" dinti!");
		}
		else 
			if((total_speed/predator2.teeth) == predator2.teeth)
			{
				predator2.teeth = 0;
				System.out.println(" Pradatorul2 a ramas cu " + " "+ predator2.teeth + " " + "dinti!");
			}
		else
			System.out.println(" Pradatorul2 a pierdut toti dintii pe care ii avea!");
						
	}
	

//METODA interfetei
	public void meetings(Predator predator)
	{
		System.out.println(" Dupa coliziune pradatorii si-au pierdut dintii:");
	}
	
	 public String toString()
	 {
		 String str = "";
		 str += name + " ";
		 str += color + " ";
		 str += Float.toString(weight) + " ";
		 str += Float.toString(length) + " ";
		 str += Integer.toString(speed) + " "; 
		 str += Integer.toString(teeth) + " ";
		 str += Float.toString(voracity) + " ";
		 str += Boolean.toString(hungry) + " ";
		 
		 return str;
	 }
			
}
