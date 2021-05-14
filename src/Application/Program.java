package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date dateIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date dateOut = sdf.parse(sc.next());
			
			//Aqui crio a minha reserva atraves do constructor que criei lá classe reservation
			Reservation rs= new Reservation(room, dateIn, dateOut);
			System.out.println(rs);
			
			
			//Atualização das datas de reserva:
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dateIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dateOut = sdf.parse(sc.next());
	 
				  
	     //Agora vou ter que mandar atualizar as datas  
	    // e vou ter que criar aqui um "If" para saber se a minha string irá retornar um erro ou não;
	   // Para isso guardei a informação dentro de uma variavel do Tipo String e depois com essa variavel verificar se ela é diferente de Null ou nao; 
			rs.updateDates(dateIn, dateOut);// Agora já nao vai lançar uma string mas sim uma excepção caso ela ocorra;
	     
			System.out.println("Reservation" + rs);
    	  
			}
    	  	catch(ParseException e) {
    		  System.out.println("Invalid date format");
    	  	}
			catch (DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
			}
		
			catch(RuntimeException e) {
				System.out.println("Unxpected error");
			}
    	  	sc.close();
    	  	
		}
		
	}

	
	     
	   
		
	


