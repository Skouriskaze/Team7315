package a7315.jd.a7315.Models;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import a7315.jd.a7315.Items.ItemDate;

/**
 * Created by Jesse on 4/1/2018.
 */

public class DatePopulator {
    public List<ItemDate> populateDates() {
        List<ItemDate> items = new ArrayList<>();

        GregorianCalendar gc = new GregorianCalendar(2018, 5, 1);
        items.add(new ItemDate("Deadline for Out-Of-State Tuition Waivers", gc.getTime()));

        gc = new GregorianCalendar(2018, 5, 21);
        items.add(new ItemDate("Payment Deadline", gc.getTime()));

        gc = new GregorianCalendar(2018, 6, 20);
        items.add(new ItemDate("Payment Deadline - Summer Freshman", gc.getTime()));

        gc = new GregorianCalendar(2018, 6, 30);
        items.add(new ItemDate("FAFSA Deadline", gc.getTime()));

        gc = new GregorianCalendar(2018, 8, 24);
        items.add(new ItemDate("Payment Deadline", gc.getTime()));

        return items;
    }
}
