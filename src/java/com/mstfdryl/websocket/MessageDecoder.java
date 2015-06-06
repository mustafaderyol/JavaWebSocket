package com.mstfdryl.websocket;

import com.mstfdryl.websocket.message.ChatMessage;
import com.mstfdryl.websocket.message.Message;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author MstfDryl
 */
public class MessageDecoder implements Decoder.Text<Message>{

    @Override
    public Message decode(String message) throws DecodeException {
        ChatMessage chatMessage = new ChatMessage();
        JsonObject jsonObject = Json.createReader(new StringReader(message)).readObject();
        chatMessage.setMessage(jsonObject.getString("message"));
        chatMessage.setLocation(jsonObject.getString("location"));
        return chatMessage;
    }

    @Override
    public boolean willDecode(String message) {
        
        boolean flag = true;
        try
        {
            Json.createReader(new StringReader(message)).readObject();
        }
        catch(Exception e)
        {
            flag = false;
        }
        return flag;
    }

    @Override
    public void init(EndpointConfig config) {}

    @Override
    public void destroy() {}
    
}
