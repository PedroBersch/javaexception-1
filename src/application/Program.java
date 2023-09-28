package application;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args)  {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date checkIn = sdf.parse("20/09/2023");
            Date checkOut = sdf.parse("19/09/2023");

            Reservation reservation = new Reservation(1001, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            checkIn = sdf.parse("30/09/2023");
            checkOut = sdf.parse("29/09/2023");
            reservation.updateDate(checkIn, checkOut);
            System.out.println("Reservation Updated: " + reservation);
        }catch (ParseException e){
            System.out.println("Invalid date format");
        }catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
    }
}
