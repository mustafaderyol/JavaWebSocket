package com.mstfdryl.websocket.message;

import java.util.Set;

/**
 *
 * @author MstfDryl
 */
public class UsersMessage implements Message {
    private Set<String> users = null;
    public UsersMessage(Set<String> users)
    {
        this.users = users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public Set<String> getUsers() {
        return users;
    }
    
    
}
