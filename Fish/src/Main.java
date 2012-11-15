import java.io.*;
//import java.util.*;
public class Main 
{

//METODA FISIER	
	public static void fisier(String filename, String data)
	{
		try {
		File file = new File(filename);
		if (!file.exists()) {
		file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(data);
		bw.close();
		}
		catch (IOException e) {
		System.out.println("Failed to write to file " + filename);
		}
	}
	
	
	public static void main(String[] args) throws Exception 
	{
		int nr_herbivore;
		int nr_predator;
		int nr_goldfish;
		System.out.print(" Introduceti nr de ierbivori:");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		nr_herbivore = Integer.parseInt (br.readLine());
		System.out.print(" Introduceti nr de pradatori:");
		nr_predator = Integer.parseInt (br.readLine());
		System.out.print(" Introduceti nr de pestisori de aur:");
		nr_goldfish = Integer.parseInt (br.readLine());
		int nr_tot = nr_herbivore + nr_predator + nr_goldfish;
		System.out.println(" Numarul total pentru stocare in vector este: " + nr_tot);
		//System.out.println(" \n " );
		
		Fish examples[] = new Fish[nr_tot];//vector dinamic al tuturor exemplarelor
		for (int i=0; i<nr_herbivore; i++)
			examples[i] = new Herbivore("Oblet","argintiu", 0.045f, 17.0f, 80, 0, 0.6f);
		for (int i=nr_herbivore; i<(nr_herbivore+nr_predator); i++)
			examples[i] = new Predator("Biban", "cenusiu", 0.500f, 35.0f, 110, 30, 0.9f);
		for (int i=(nr_herbivore+nr_predator); i<nr_tot; i++)
		{
			System.out.println(" \n ");
			System.out.println(" Introduceti datele pentru Pestisor de aur: ");
			examples[i] = new Goldfish();
		}
		
	
		for (int i=0; i<nr_tot; i++)
			examples[i].printInfo();
		
		System.out.println(" Numarul total de pestisori creati este " + Fish.nr_fish);
		
		examples[0].meetings();
		
		//PRAJIREA PESTISORULUI DE AUR
		System.out.println(" Pescuind,am prins un pestisor.Si de mare foame,am vrut sa il prajesc.");
		System.out.println(" Dar spre marea mea mirare era un Pestisor de Aur!!!");
		((Goldfish)(examples[nr_herbivore+nr_predator])).fry();
		
		
		//ATITAREA UNUI IERBIVOR
		System.out.println(" In adincurile riului intunecos cineva devine o hrana gustoasa pentru cei ce vineaza.");
		System.out.println(" Si iata acum,chiar in momentul dat pradatorul s-a repezit pe furis dupa ierbivorul cel dulce!");
		if(!((Herbivore)(examples[0])).life)	
			((Herbivore)(examples[0])).instigation(((Predator)(examples[nr_herbivore])));
		else
		{
			System.out.println(" Ierbivorul a fost atitat de pradator!(((");
			Fish.nr_fish--;
		}
		
		//SATURATIA PRADATORULUI
			((Predator)(examples[nr_herbivore])).saturation(((Herbivore)(examples[0])));
	
		// COLIZIA PRADATORILOR
		if (((Predator)(examples[nr_herbivore])).hungry && ((Predator)(examples[nr_herbivore+1])).hungry)
		{
			((Predator)(examples[nr_herbivore])).meetings((Predator)(examples[nr_herbivore+1]));
			Predator.collision((Predator)examples[nr_herbivore],(Predator) examples[nr_herbivore+1]);
		}
		else
			System.out.println(" Nu are loc coliziune.");
		
		System.out.println(" Numarul total de pestisori ramasi este " + Fish.nr_fish);
		
		//INCRUCISAREA IERBIVORILOR
		if(!((Herbivore)(examples[0])).life && !((Herbivore)(examples[1])).life)
		{
			((Herbivore)(examples[0])).meetings((Herbivore)(examples[1])); 
			((Herbivore)(examples[0])).crossing((Herbivore)(examples[1])).printInfo();
			
			//((Herbivore)(examples[0])).crossing((Herbivore)(examples[1])).toString();
		}
		else if(((Herbivore)(examples[0])).life && !((Herbivore)(examples[1])).life)
			 System.out.println(" Conditiile pentru incrucisare sunt nefavorabile si nu are loc incrucisarea!");
		else 
			System.out.println(" Conditiile pentru incrucisare sunt nefavorabile si nu are loc incrucisarea!");
		
		System.out.println(" Numarul total de pestisori in riu este " + Fish.nr_fish);
		
		//inscrierea in fisier
		String container = "";
		String head = "Name\t\tColor\t\tWeight\t\tLeigth\t\tSpeed\t\tAcceleration\t\tScars\t\tLife\t\tNationality\t\tWishes\t\tTeeth\t\tVoracity\t\tHungry";
		
		container = head + "\n";
		container += (((Herbivore)(examples[0])).crossing((Herbivore)(examples[1]))).toString();
		
		for (int i = 0; i < nr_herbivore; i++)
		//{
		  container +=  ((Herbivore)(examples[i])).toString() + "\n";
		 // fisier("fisier.txt", container);
		//}
		for (int i = nr_herbivore; i < (nr_herbivore+nr_predator); i++)
		//{
		  container +=  ((Predator)(examples[i])).toString() + "\n";
		 // fisier("fisier.txt", container);
		//}
		for (int i=(nr_herbivore+nr_predator); i<nr_tot; i++)
		//{
		  container +=  ((Goldfish)(examples[i])).toString() + "\n";
		  //fisier("fisier.txt", container);
		//}
		//container = ((Herbivore)(examples[0])).crossing((Herbivore)(examples[1])).toString();
		fisier("fisier.txt", container);
		
	}

}
