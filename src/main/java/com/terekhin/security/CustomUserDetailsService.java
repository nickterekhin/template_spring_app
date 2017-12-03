package com.terekhin.security;

import com.terekhin.database.DBContext;
import com.terekhin.database.IDBContext;
import com.terekhin.domain.Group;
import com.terekhin.domain.Permission;
import com.terekhin.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nick on 13.11.17.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    @Autowired
    @Qualifier("DBContext")
    private IDBContext dbContext;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = dbContext.getUsers().findByEmail(email);
        logger.info("User : {}",user);
        if(user==null)
        {
            logger.info("User not found");
            throw new UsernameNotFoundException("UserName not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.isActive(),true,
                true,true, this.getAuthorities(user.getGroups()));

    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Group> groups) {

        return this.getGrantedAuthorities(getGroups(groups));
    }


    private  List<String> getGroups(final Collection<Group> groups)
    {
        List<String> permissions = new ArrayList<>();
        for(Group g : groups)
        {
            permissions.add(g.getGroupName());
            permissions.addAll(g.getPermissions().stream().map(Permission::getName).collect(Collectors.toList()));

        }
        return permissions;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final List<String> permissions)
    {
        return permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
