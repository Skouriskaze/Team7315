package a7315.jd.a7315.Items;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by jonji on 2/28/2018.
 */

public class ItemDate implements Serializable, Comparable<ItemDate> {
    private String title;
    private Date date;

    public ItemDate(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(@NonNull ItemDate itemDate) {
        return this.date.compareTo(itemDate.getDate());
    }
}
