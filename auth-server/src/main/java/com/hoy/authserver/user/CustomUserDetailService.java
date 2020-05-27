package com.hoy.authserver.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Id Not Found");
        }


        return makeUserDetail(user);
    }

    public UserDetails makeUserDetail(User user) {
        CustomUserDetail customUserDetail = new CustomUserDetail();


        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        if(user.getUserType() == 0){

            grantedAuthorityList.add(new SimpleGrantedAuthority("ADMIN"));
        }else  if (user.getUserType() == 1){
            grantedAuthorityList.add(new SimpleGrantedAuthority("USER"));
        }

        customUserDetail.setUserName(user.getUsername());
        customUserDetail.setPassword(user.getPassword());
        customUserDetail.setGrantedAuthorities(grantedAuthorityList);
        return customUserDetail;
    }


}
