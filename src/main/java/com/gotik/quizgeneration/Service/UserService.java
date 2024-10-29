package com.gotik.quizgeneration.Service;

import java.util.ArrayList;
import java.util.List;

import com.gotik.quizgeneration.Model.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserService {
    @Builder.Default
    private List<Users> users = new ArrayList<>();
}
