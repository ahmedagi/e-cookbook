package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.sql.ResultSet;
import java.util.Map;

public class UserDaoSQLImplementation extends AbstractDao<User> implements UserDao{
    private static UserDaoSQLImplementation instance = null;

    public static UserDaoSQLImplementation getInstance() {
        if (instance == null) {
            instance = new UserDaoSQLImplementation();
        }
        return instance;
    }

    public static void removeInstance() {
        if (instance != null) {
            instance = null;
        }
    }

    public UserDaoSQLImplementation() {
        super("user");
    }

    @Override
    public User row2object(ResultSet rs) {
        return null;
    }

    @Override
    public Map<String, Object> object2row(User object) {
        return null;
    }

    @Override
    public User searchByUsername(String username) {
        return null;
    }
}
