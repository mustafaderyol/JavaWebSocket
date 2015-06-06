package com.mstfdryl.websocket;

import com.mstfdryl.websocket.message.ChatMessage;
import com.mstfdryl.websocket.message.Message;
import com.mstfdryl.websocket.message.UsersMessage;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author MstfDryl
 */
public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public String encode(Message message) throws EncodeException 
    {
        String returnString = null;
        if(message instanceof ChatMessage)
        {
            ChatMessage chatMessage = (ChatMessage) message;
            returnString = Json.createObjectBuilder().add("messageType", chatMessage.getClass().getSimpleName())
                                                     .add("name", chatMessage.getName())
                                                     .add("message", chatMessage.getMessage())
                                                     .add("location", chatMessage.getLocation())
                                                     .build().toString();
        }
        else if(message instanceof UsersMessage)
        {
            UsersMessage usersMessage = (UsersMessage) message;
            returnString = buildJsonUsersData(usersMessage.getUsers(),usersMessage.getClass().getSimpleName());
            
        }
        return returnString;
    }

    @Override
    public void init(EndpointConfig config) {}

    @Override
    public void destroy() {}
    
    private String buildJsonUsersData(Set<String> set, String messageType)
    {
        Iterator<String> iterator = set.iterator();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        while(iterator.hasNext()) jsonArrayBuilder.add(iterator.next());
        
        return Json.createObjectBuilder().add("messageType", messageType)
                                         .add("users", jsonArrayBuilder)
                                         .build().toString();
    }
    
}
