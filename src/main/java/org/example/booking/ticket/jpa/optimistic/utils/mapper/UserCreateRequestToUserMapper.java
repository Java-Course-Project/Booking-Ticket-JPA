package org.example.booking.ticket.jpa.optimistic.utils.mapper;

import org.example.booking.ticket.jpa.model.request.UserCreateRequest;
import org.example.booking.ticket.jpa.optimistic.entity.User;
import org.example.booking.ticket.jpa.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserCreateRequestToUserMapper implements Mapper<UserCreateRequest, User> {

    @Override
    public User map(UserCreateRequest userCreateRequest) {
        return User.builder()
                   .dob(userCreateRequest.getDob())
                   .balance(userCreateRequest.getBalance())
                   .username(userCreateRequest.getUsername())
                   .build();
    }

    @Override
    public Class<UserCreateRequest> getSourceClass() {
        return UserCreateRequest.class;
    }

    @Override
    public Class<User> getDestinationClass() {
        return User.class;
    }
}
