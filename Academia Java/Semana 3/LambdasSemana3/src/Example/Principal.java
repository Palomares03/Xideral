package Example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;


public class Principal {

	public static void main(String[] args) {
		
		
		System.out.println("***Supplier***");
		//Definición de Lambda
		Supplier<Autos> aut5 = () -> new Autos(5, "Ford", "GT", 1000.0);
		//Ejecutar lambda
		Autos a1 = aut5.get();
		System.out.println(a1);
		
		
		System.out.println("***Consumer***");
		//Definición de Lambda
		Consumer<String> con1 = a -> System.out.println(a + " Mustang");
		//Ejecutar lambda
		con1.accept("Ford");
		
		//Definición de Lambda
		Autos a2 = new Autos(6, "Toyota", "Supra", 1200.0);
		Consumer<Autos> con2 = au -> au.setPrecio(au.getPrecio()*1.16);
		//Ejecutar lambda
		con2.accept(a2);
		System.out.println(a2);
		
		
		System.out.println("***BiConsumer***");
		//Definición de Lambda
		Autos a3 = new Autos(7, "Seat", "Leon", 600.0); 
				BiConsumer<Autos,Double> biCon = (a,iva) -> a.setPrecio(a.getPrecio()*iva);
		//Ejecutar lambda	
		biCon.accept(a3,1.16);		
		System.out.println(a3);
		
		
		System.out.println("***Predicate***");
		//Definición de Lambda
		Predicate <String> pre = s ->s.contains("ro");
		//Ejecutar lambda
		boolean a4 = pre.test("Camaro");
		System.out.println(a4);
		
		
		System.out.println("***BiPredicate***");
		List<Autos> Autos = new ArrayList<>();
		
			Autos.add(new Autos(0, "Ford","F150", 100.0));
			Autos.add(new Autos(1, "Nissan","Z", 200.0));
			Autos.add(new Autos(2, "Mazda","3", 300.0));
			Autos.add(new Autos(3, "Honda","City", 400.0));
			Autos.add(new Autos(4, "Seat","Ibiza", 500.0));
		
		//Definición de Lambda
		BiPredicate<Autos, Integer> biPredicate = (modelo, precio) -> modelo.getPrecio() > precio;
			//Ejecutar lambda
	        for(Autos modelo : Autos) {
	            if(biPredicate.test(modelo, 300)) {
	                System.out.println(modelo.getModelo() + " cuesta mas de 300 pesos.");
	            }
	        }
	    
	        
	    System.out.println("***Funtion***");
	    //Definición de Lambda
	    Function<StringBuilder,Autos> fun = sb -> new Autos(10,"BMW",sb.toString(),200.00);
	    //Ejecutar lambda
	    Autos a5 = fun.apply(new StringBuilder("M4"));
		System.out.println(a5);
	    
	    
	    System.out.println("***BiFuntion***");
	    //Definición de Lambda
	    BiFunction<String,Double,Autos> biFun = (x,y) -> new Autos(new Random().nextInt(200),"Ford",x,y);
		//Ejecutar lambda
	    Autos a6 = biFun.apply("Focus", 250.00);
		System.out.println(a6);
		
		
	    System.out.println("***UnaryOperation***");
	    //Definición de Lambda
	    UnaryOperator<String> nom = car -> car.concat("Cobra");	
	    //Ejecutar lambda
		System.out.println(nom.apply("Shellby "));
		
		//Definición de Lambda
		UnaryOperator<Autos> uop = a7 -> {a7.setPrecio(1000.00);
		  		a7.setModelo("G500");
		  		return a7;
			};		 
		Autos a7 = new Autos(4, "AMG","G Series", 500.0);
		//Ejecutar lambda
		Autos uo = uop.apply(a7);
		System.out.println(uo);	
	    
	       
	}

}
