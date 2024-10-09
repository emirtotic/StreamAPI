package com.streamApi.groupBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {

        User u1 = new User("John", 33);
        User u2 = new User("Maria", 38);
        User u3 = new User("Antony", 24);
        User u4 = new User("Mark", 27);
        User u5 = new User("Simon", 24);
        User u6 = new User("Ben", 32);
        User u7 = new User("Clara", 24);

        List<User> users = Arrays.asList(u1, u2, u3, u4, u5, u6, u7);

        Map<Integer, List<User>> usersByAge = users.stream()
                .collect(Collectors.groupingBy(User::getAge));

        System.out.println(usersByAge);
    }

}
