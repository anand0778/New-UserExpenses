package com.sintoli.service;

import com.sintoli.entity.User;
import com.sintoli.entity.UserModel;

public interface UserService {
              User createUser(UserModel user);
              User read(Long id);
              User update(User user,Long id);
              void delete(Long id);
              
              User getLoggedInUser();
}
