package com.example.BoardGameProject.services;

import com.example.BoardGameProject.models.RoleSystem.Role;
import com.example.BoardGameProject.models.RoleSystem.User;
import com.example.BoardGameProject.repositories.RolesRepository;
import com.example.BoardGameProject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService
{
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UsersRepository userRepository;
    @Autowired
    RolesRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User findUserById(Long userId)
    {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveCustomer(User user)
    {
        var roles = Collections.singleton(new Role(1L, "ROLE_CUSTOMER"));
        return saveUser(user, roles);
    }

    public boolean saveAdmin(User user)
    {
        var roles = Collections.singleton(new Role(3L, "ROLE_ADMIN"));
        return saveUser(user, roles);
    }

    public boolean saveStore(User user)
    {
        var roles = Collections.singleton(new Role(2L, "ROLE_STORE"));
        return saveUser(user, roles);
    }

    private boolean saveUser(User user, Set<Role> roles)
    {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId)
    {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
