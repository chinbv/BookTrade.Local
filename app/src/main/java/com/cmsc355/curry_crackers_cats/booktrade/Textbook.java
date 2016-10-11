package com.cmsc355.curry_crackers_cats.booktrade;
/**
 *
 * @author Vishakha
 *Attributes: id, title, condition, price, decsription, favorite
 *Constructor: three parameter
 *Getter & Setters: all attributes
 */
public class Textbook {

    // private variable
    int textbookId;
    String title;
    String condition;
    String price;
    String description;
    boolean favorite = false;
    boolean sold = false;
    int userID;
//    Bitmap image;

    public Textbook () {
        this.title = "";
        this.condition = "";
        this.price = "";
        this.description = "";
        this.favorite = false;
        this.sold = false;
        this.userID = 0;
    }


    public Textbook(String title, String condition, String price, String des, int usID){
        this.setTitle(title);
        this.condition = condition;
        this.description = des;
        this.price = price;
        this.userID = usID;
    }
    public Textbook(String title, String condition, String price, int usID){
        this.setTitle(title);
        this.condition = condition;
//        this.description = des;
        this.price = price;
        this.userID = usID;
    }
    /**
     * @return the id
     */
    public int getTextbookId() {
        return textbookId;
    }

    /**
     * @param id the id to set
     */
    public void setTextbookId(int id) {
        this.textbookId = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        if (title.trim() == null) throw new IllegalArgumentException("Please fill in all fields.");
        this.title = title;
    }

    /**
     * @return condition the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(String condition) {
        if (condition.trim() == null) throw new IllegalArgumentException("Please fill in all fields.");
        this.condition = condition;
    }

    /**
     * @return description the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        if (description.trim() == null) throw new IllegalArgumentException("Please fill in all fields.");
        this.description = description;
    }

    /**
     * @return price the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        if (price == null) throw new IllegalArgumentException("Please fill in all fields. P");
        if (price.contains("-")) throw new IllegalArgumentException("Price must be at 0 or greater.");
        this.price = price;
    }

    /**
     * @return favorite the favorite
     */
    public boolean getFavorite() {
        return favorite;
    }

    /**
     * @param favorite the favorite to set
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    /**
     * @return sold the sold
     */
    public boolean getSold() {
        return sold;
    }

    /**
     * @param sold the sold to set
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     * @return owner the owner
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the owner to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

//    public byte[] getBytes (Bitmap image) {
//        return
//    }


}
