package com.mstfdryl.websocket.message;

/**
 *
 * @author MstfDryl
 */
public class ChatMessage implements Message {
    private String name;
    private String location;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
