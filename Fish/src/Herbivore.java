import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Herbivore extends Fish implements Meeting 
{
	int scars;               //cicatrice
	final float acceleration;//coificient de accelerare a ierbivorului 
	boolean life = false;
	
	public Herbivore() throws Exception
	{
		super();
		BufferedReader in = new BufferedReader(new
				InputStreamReader(System.in));
		scars = 0;
		System.out.print(" Coificientul de accelerare : " );
		acceleration = Float.parseFloat (in.readLine());
	}
	
	public Herbivore (String new_n, String new_c, float new_w, float new_l, int  new_s, int sc, float a)
	{
		super(new_n, new_c, new_w, new_l, new_s);
		scars = sc;
		if (a > 0.0f)
			acceleration = a;
		else
		{
			acceleration = 0.0f;//va sta pe loc
			System.out.println(" Coificientul de accelerare a ierbivorului este 0.");
		}
			
	}
	
	//METODELE GET
	public int get_scars()
	{
		return scars;
	}
	public float get_acceleration()
	{
		return acceleration;
	}
	
	//METODELE SET
	public void set_scars(int sc)
	{
		scars = sc;
	}
	
	

	 public void printInfo()
	 {
		System.out.println(" \n ");
		System.out.println(" Numele ierbivorului: "+" "+ name);
		System.out.println(" Culoarea ierbivorului: "+" "+ color);
		System.out.println(" Greutatea ierbivorului: "+" "+ weight + " " + "kg");
		System.out.println(" Lungimea ierbivorului: "+" "+ length + " " + "cm");
		System.out.println(" Viteza ierbivorului: "+" "+ speed + " " + "m/h");
		System.out.println(" Coificientul de acceleratie a ierbivorului: "+" "+ acceleration);
	 }
	 
//ATITAREA PRADATORULUI ASUPRA IERBIVORULUI	 
	 public int Speed(Predator predator) 
	 {
		 return speed = (int) ((this.speed * acceleration) + predator.teeth);
	 }
	 
	 public int Scars(Predator predator)
	 {
		 return scars = predator.teeth;
	 }
	 
	 public void instigation(Predator predator) //atitare
	 {
		 this.Speed(predator);
		 this.Scars(predator);
		 System.out.println(" Un ierbivor a fugit de la pradator cu viteza " + " " + speed + " " + " m/h.");
		 System.out.println(" Insa a ramas cu  " + " " + scars + " " + " cicatrice.");
		 predator.hungry = true;
		 life = true;
		 
	 }
	 
//METODA DE INCRUCISARE A AMFIBIILOR	
	 public final Herbivore crossing(Herbivore partener) //incrucisare
	 {
		 String name_child = "Copilul pestisorilor: " +" "+ this.name + " si " + partener.name;
		 String color_child = color; //luam culoarea pestelui, care a initiat procesul de dragoste amfibiana
		 float weight_child = (weight + partener.weight) / 2.0f;
		 float length_child = (length + partener.length) / 2.0f;
		 int speed_child = (speed + partener.speed) / 2;
		 int scars_child = (scars + partener.scars) / 2;
		 float acceleration_child = (acceleration + partener.acceleration) / 2.0f;

		 Herbivore child = new Herbivore(name_child, color_child, weight_child, length_child, speed_child, scars_child, acceleration_child);
		 return child; 
		}
	 
//METODA INTERFETEI	 
	 public void meetings(Herbivore partener)
	 {
		 //System.out.println(" \n ");
		 System.out.println(" Conditii favorabile pentru incrucisarea ierbivorilor!");	 
			
	 }
	  
	 public String toString()
	 {
		 String str = "";
		 str += name + " ";
		 str += color + " ";
		 str += Float.toString(weight) + " ";
		 str += Float.toString(length) + " ";
		 str += Integer.toString(speed) + " ";
		 str = Integer.toString(scars) + " ";
		 str += Float.toString(acceleration) + " ";
		 str += Boolean.toString(life) + " ";
		
		 return str;
	 }		  
}
