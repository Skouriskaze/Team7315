package a7315.jd.a7315.Items;

import java.io.Serializable;

/**
 * Created by Jesse on 1/22/2018.
 */

public class ItemAid implements Serializable, ItemFinancials {
    private String title;
    private float amount;
    private boolean active;

    public ItemAid(String title, float amount) {
        this.title = title;
        this.amount = amount;
        this.active = false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
