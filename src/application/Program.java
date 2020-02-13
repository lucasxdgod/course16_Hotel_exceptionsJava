package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { // throws propraga toda essa exce��o para o MAIN
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date: (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());  // Eu escrevo a data em texto, mas ele converte para o formato date
		System.out.print("Check-out date: (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());  // Eu escrevo a data em texto, mas ele converte para o formato date
		
		if (!checkOut.after(checkIn)) { 
			System.out.println("Error in reservation: check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date(dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
			
			// Tratando o erro das datas de reservas ser futuras bem como as datas de check-in ser futura a data de check-out 
			String error = reservation.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println("Error in reservation: " +error);
			}	
			else {
				System.out.println("Reservation: "+reservation);
			}
			
		}
		
		sc.close();
		
		
	}

}
