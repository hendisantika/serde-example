package com.hendisantika.serdeexample.controller;

import com.hendisantika.serdeexample.entity.User;
import com.hendisantika.serdeexample.service.SerializedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : serde-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/08/18
 * Time: 06.51
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/rest/deserialize")
public class DeSerializationController {
    @Autowired
    private SerializedService serializedService;

    @GetMapping
    public List<User> getUsers() {

        return serializedService.getUsers();
    }
}
