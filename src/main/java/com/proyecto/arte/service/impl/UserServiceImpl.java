package com.proyecto.arte.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.arte.exception.UserNotFoundException;
import com.proyecto.arte.model.User;
import com.proyecto.arte.repository.UserRepository;
import com.proyecto.arte.service.UserService;

import java.util.List;
import java.util.Optional;


/**
 * Implement UserService
 * @author Roberto Crespo
 * @since 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User findByUserId(String userId) {
        Optional<User> user = userRepository.findOne(userId);
        if (user.isPresent()) {
            log.debug(String.format("Read userId '{}'", userId));
            return user.get();
        }else
            throw new UserNotFoundException(userId);
    }

   
    public List<User> findAll() {
        Optional<List<User>> user = userRepository.findAll();
        return user.get();      
    }
    
   
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

 
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }

}
