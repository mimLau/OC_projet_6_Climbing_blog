package org.oc.escalade.consumer;

import org.oc.escalade.model.User;

public interface UserDao {

    User addUser(User user);
    User findUserByUsername(String username);
    boolean usernameExists(String username);
    User findUserByEmail(String email);

}
