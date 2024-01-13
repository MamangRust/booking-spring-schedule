package com.sanedge.bookinghotel.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.sanedge.bookinghotel.domain.response.user.UserResponse;
import com.sanedge.bookinghotel.models.User;

public class UserMapper {
    public static UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setRoles(user.getRoles());
        return userResponse;
    }

    public static List<UserResponse> toUserResponseList(List<User> userList) {
        return userList.stream().map(UserMapper::toUserResponse).collect(Collectors.toList());
    }
}
