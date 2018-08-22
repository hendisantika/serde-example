package com.hendisantika.serdeexample.service;

import com.hendisantika.serdeexample.entity.SerializedUser;
import com.hendisantika.serdeexample.entity.User;
import com.hendisantika.serdeexample.repository.SerializedUserRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : serde-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/08/18
 * Time: 06.50
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SerializedService {

    private SerializedUserRepository repository;

    public SerializedService(SerializedUserRepository repository) {
        this.repository = repository;
    }

    public void persist(User user) {
        byte[] serializedUser = convert(user);
        SerializedUser serialiazedObject = new SerializedUser(serializedUser);
        repository.save(serialiazedObject);
    }

    private byte[] convert(User user) {
        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(user);
            return outputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsers() {

        return repository.findAll()
                .stream()
                .map(serializedUser -> convert(serializedUser.getSerializedUser()))
                .collect(Collectors.toList());

    }

    private User convert(byte[] serializedUser) {
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(serializedUser);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            User user = (User) objectInputStream.readObject();
            return user;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}