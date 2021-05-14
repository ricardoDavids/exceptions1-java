package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int room = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date dateIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date dateOut = sdf.parse(sc.next());
		
		
		//Tenho que ver se a data do checkOut � depois da data do checkIn, se n�o for dar� um erro
		
		if(!dateOut.after(dateIn) ) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation rs= new Reservation(room, dateIn, dateOut);
			System.out.println(rs);
			
			
			
			
			//Atualiza��o das datas:
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			 dateIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
		     dateOut = sdf.parse(sc.next());
 
			  
		   //Agora vou ter que mandar atualizar as datas  
		   // e vou ter que criar aqui um "If" para saber se a minha string ir� retornar um erro ou n�o;
		   // Para isso guardei a informa��o dentro de uma variavel do Tipo String e depois com essa variavel verificar se ela � diferente de Null ou nao; 
		      String error= rs.updateDates(dateIn, dateOut);
		      if(error != null) {
		    	  System.out.println("Error in reservation: " + error);
		      }
		      else {
		    	  System.out.println("Reservation" + rs);
		      }
				
				}
		
		
		     }
		   
		
	}


