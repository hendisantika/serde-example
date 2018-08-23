package com.hendisantika.serdeexample.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * Project : serde-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/08/18
 * Time: 06.48
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class SerializedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private byte[] serializedUser;

    public SerializedUser(byte[] serializedUser) {
        this.serializedUser = serializedUser;
    }

    public SerializedUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getSerializedUser() {
        return serializedUser;
    }

    public void setSerializedUser(byte[] serializedUser) {
        this.serializedUser = serializedUser;
    }
}
