package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

public interface UserDao extends Dao<User> {
    /**
     * Returns user with given username
     * @param username search string for users
     * @return User
     */
    User searchByUsername(String username);
}