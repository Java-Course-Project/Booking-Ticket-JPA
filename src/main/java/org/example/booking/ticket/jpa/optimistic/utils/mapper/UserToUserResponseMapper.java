package org.example.booking.ticket.jpa.optimistic.utils.mapper;

import org.example.booking.ticket.jpa.model.response.UserResponse;
import org.example.booking.ticket.jpa.optimistic.entity.User;
import org.example.booking.ticket.jpa.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseMapper implements Mapper<User, UserResponse> {
    @Override
    public UserResponse map(User user) {
        return UserResponse.builder()
                           .id(user.getId())
                           .name(user.getUsername())
                           .dob(user.getDob())
                           .balance(user.getBalance())
                           .build();
    }

    @Override
    public Class<User> getSourceClass() {
        return User.class;
    }

    @Override
    public Class<UserResponse> getDestinationClass() {
        return UserResponse.class;
    }
}
