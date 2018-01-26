package a7315.jd.a7315.Items;

/**
 * Created by Jesse on 1/22/2018.
 */

public class ItemAid {
    private String title;
    private float amount;

    public ItemAid(String title, float amount) {
        this.title = title;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
