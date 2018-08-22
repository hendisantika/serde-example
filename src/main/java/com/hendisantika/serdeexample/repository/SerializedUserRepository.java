package com.hendisantika.serdeexample.repository;

import com.hendisantika.serdeexample.entity.SerializedUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : serde-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/08/18
 * Time: 06.49
 * To change this template use File | Settings | File Templates.
 */
public interface SerializedUserRepository extends JpaRepository<SerializedUser, Integer> {
}