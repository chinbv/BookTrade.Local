package com.cmsc355.curry_crackers_cats.booktrade;
/**
 *
 * @author Vishakha
 *Attributes: id, content, userOne, userTwo, timestamp
 *Constructor: four parameter
 *Getter & Setters: all attributes
 */

public class Messages {

    // private variable
    int messageId;
    String content;
    int userOne;
    int userTwo;
    String timeStamp;

    public Messages() {
        this.content = "";
        this.userOne = 0;
        this.userTwo = 0;
        this.timeStamp = "";
    }
    public Messages(String content, int userOne, int userTwo, String timeStamp){
        this.content = content;
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.timeStamp = timeStamp;
    }

    /**
     * @return the id
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * @param id the id to set
     */
    public void setMessageId(int id) {
        this.messageId = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the userOne
     */
    public int getUserOne() {
        return userOne;
    }

    /**
     * @param userOne the user to set
     */
    public void setUserOne(int userOne) {
        this.userOne = userOne;
    }

    /**
     * @return the userTwo
     */
    public int getUserTwo() {
        return userTwo;
    }

    /**
     * @param userTwo the user to set
     */
    public void setUserTwo(int userTwo) {
        this.userTwo = userTwo;
    }


    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the time to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
