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

            checkIn = sdf.parse("25/09/2023");
            checkOut = sdf.parse("26/09/2023");
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Reservation dates for update must be future dates");
            }else if (!checkOut.after(checkIn)){
                System.out.println("Check-out date must be after check-in date");
            }else {
                reservation.updateDate(checkIn,checkOut);
                System.out.println("Reservation: "+ reservation);
            }

        }
    }
}
