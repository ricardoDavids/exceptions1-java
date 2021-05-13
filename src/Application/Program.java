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
		
		
		//Tenho que ver se a data do check in não é superior a data do check out
		
		if(!dateOut.after(dateIn) ) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation rs= new Reservation(room, dateIn, dateOut);
			System.out.println(rs);
			
			//Atualização das datas:
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			 dateIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
		     dateOut = sdf.parse(sc.next());
		     
		     Date now = new Date();
		     if(dateIn.before(now) || dateOut.before(now)) {
		    	 System.out.println("Error in reservation: Reservation dates for update must be future dates");
		     }
		     else if(!dateOut.after(dateIn) ) {
					System.out.println("Error in reservation: Check-out date must be after check-in date");
				}
		     else {
		    	  //Agora vou ter que mandar atualizar as datas
					rs.updateDates(dateIn, dateOut);
					System.out.println(rs);
		     }
		   
		}
	}

}
