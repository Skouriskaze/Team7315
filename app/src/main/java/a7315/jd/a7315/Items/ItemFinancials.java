package a7315.jd.a7315.Items;

/**
 * Created by Jesse on 2/18/2018.
 */

public interface ItemFinancials {
    /**
     * Gets the title of the item
     * @return Title of the item
     */
    String getTitle();

    /**
     * Sets the title of the item
     * @param title Title of the item
     */
    void setTitle(String title);

    /**
     * Gets the amount of the item
     * @return The amount of the item
     */
    float getAmount();

    /**
     * Sets the amount of the item
     * @param amount The amount of the item
     */
    void setAmount(float amount);

    /**
     * Gets whether or not this item should be used or not
     * @return Whether this item is active or not
     */
    boolean isActive();

    /**
     * Sets whether or not this item should be used or not
     * @param active Whether or not this item is active
     */
    void setActive(boolean active);
}
