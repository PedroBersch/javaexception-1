package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date checkIn = sdf.parse("20/09/2023");
        Date checkOut = sdf.parse("21/09/2023");

        if (!checkOut.after(checkIn)){
            System.out.println("Check-out date must be after check-in date");
        }else {
            Reservation reservation = new Reservation(1001, checkIn,checkOut);
            System.out.println("Reservation: "+ reservation);

            checkIn = sdf.parse("30/09/2023");
            checkOut = sdf.parse("31/09/2023");
               String error =  reservation.updateDate(checkIn,checkOut);
               if(error!= null){
                   System.out.println("Error in reservation: " + error);
               }else{
                   System.out.println("Reservation: "+ reservation);
               }
        }
    }
}
