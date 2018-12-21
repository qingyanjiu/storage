//package stream.mokulive.storage.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import stream.mokulive.storage.mapper.UserMapper;
//import stream.mokulive.storage.vo.User;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userMapper.findByName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("UserName " + username + " not found");
//        }
//        return new UserDetails() {
//            @Override
//            public Collection<? extends GrantedAuthority> getAuthorities() {
//                List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//                GrantedAuthority authority = new GrantedAuthority() {
//                    public String getAuthority() {
//                        return "ROLE_USER";
//                    }
//                };
//                list.add(authority);
//                return list;
//            }
//
//            @Override
//            public String getPassword() {
//                return "{MD5}"+user.getPassword();
//            }
//
//            @Override
//            public String getUsername() {
//                return user.getUserName();
//            }
//
//            @Override
//            public boolean isAccountNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isAccountNonLocked() {
//                return true;
//            }
//
//            @Override
//            public boolean isCredentialsNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isEnabled() {
//                return true;
//            }
//        };
//
//    }
//}
