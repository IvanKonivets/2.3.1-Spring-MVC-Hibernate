package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User read(Long id) {
        return userDao.read(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
