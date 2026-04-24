package com.viniparg.course.config;

import com.viniparg.course.entities.Order;
import com.viniparg.course.entities.User;
import com.viniparg.course.entities.enums.OrderStatus;
import com.viniparg.course.repositories.OrderRepository;
import com.viniparg.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "mariab@email.com", "987654321", "12345");
        User u2 = new User(null, "Alex Green", "alex@email.com", "123456789", "12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:27Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2019-06-20T19:42:37Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2019-06-20T19:33:17Z"), OrderStatus.WAITING_PAYMENT,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
