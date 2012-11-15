import java.io.*;

public abstract class Fish implements Meeting 
{
	String name,color;
	float weight,length;//greutatea pestelui,lungimea pestelui
	int speed;
	static int nr_fish;
	
	public Fish () throws Exception //Constructor implicit a clasei parinte
	{
		BufferedReader br = new BufferedReader(new
		InputStreamReader(System.in));
		//System.out.print(" ************************************  ");
		//System.out.print(" \n Introduceti datele pestelui: ");
		System.out.print(" \n Numele pestelui: " );
		name = br.readLine();
		System.out.print(" Culoarea pestelui: " );
		color = br.readLine();
		System.out.print(" Greutatea pestelui,kg: " );
		weight = Float.parseFloat (br.readLine());
		System.out.print(" Lungimea pestelui,cm: " );
		length = Float.parseFloat (br.readLine());
		System.out.print(" Viteza pestelui,m/h: ");
		speed = Integer.parseInt (br.readLine());
		nr_fish++;
		
	}
	
//Constructor cu parametri	
	public Fish (String new_name, String new_color, float new_weight, float new_length, int new_speed)
	{
		name = new_name + nr_fish;
		color = new_color;
		if (new_weight > 0.0f)
			weight = new_weight;
		else 
			weight = 0.010f;
		if ((new_length > 0.0f) && (new_length <= 4000.0f))
			length = new_length;
		else
			length = 2.0f;
		if (new_speed > 0) 
			speed = new_speed;
		
		else 
			speed = 0;
		nr_fish++;
	}
	
//METODELE GET
		public String get_name()     
		{
			return name;
		}
		public String get_color() 
		{
			return color;
		}
		public float get_weight()
		{
			return weight;
		}
		public float get_length()
		{
			return length;
		}
		public int get_speed()
		{
			return speed;
		}
		
//METODELE SET
		public void set_name(String name)         
		{
			this.name = name;
		}
		public void set_color(String color)
		{
			this.color = color;
		}
		public void set_weight(float new_weight)
		{
			if (new_weight > 0.0f)
				weight = new_weight;
			else 
				weight = 0.010f;
		}
		public void set_length(float new_length)
		{
			if ((new_length > 0.0f) && (new_length <= 4000.0f))
				length = new_length;
			else
				length = 2.0f;
		}
		public void set_speed(int new_speed)
		{
			if (new_speed > 0) 
				speed = new_speed;
			
			else 
				speed = 0;
		}
		
		
//METODA INTERFETEI		
	     public void meetings()
	     {
	    	 System.out.println(" Pestisorii creati traiesc in adincurile intunecoase unui riu autohton.");
	    	 
	     }
	     
//METODA ABSTRACTA
		 public abstract void printInfo();			

}
