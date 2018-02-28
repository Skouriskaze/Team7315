package a7315.jd.a7315.Items;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by jonji on 2/28/2018.
 */

public class ItemDate implements Serializable {
    private String title;
    private LocalDate date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
