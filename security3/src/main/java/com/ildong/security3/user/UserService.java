package com.ildong.security3.user;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    public final static Map<String,UserDto> store = new HashMap<String,UserDto>();

    public void save(UserDto userDto){
        store.put(userDto.getUsername(),userDto);
    }

    public UserDto findByUsername(String username){
        return store.get(username);
    }
}
