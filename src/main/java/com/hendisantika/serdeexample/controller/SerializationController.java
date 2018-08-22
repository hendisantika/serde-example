package com.hendisantika.serdeexample.controller;

import com.hendisantika.serdeexample.entity.User;
import com.hendisantika.serdeexample.service.SerializedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : serde-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/08/18
 * Time: 06.53
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/rest/serialize")
public class SerializationController {
    @Autowired
    private SerializedService serializedService;

    @PostMapping
    public String post(@RequestBody final User user) {

        serializedService.persist(user);

        return "User data saved..!";
    }
}
