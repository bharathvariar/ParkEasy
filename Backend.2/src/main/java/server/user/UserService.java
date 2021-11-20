package server.user;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	 private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User users = userRepository.findByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority("user");
		UserDetails userDetails = (UserDetails) new User(users.getUsername(),
		users.getPassword(), Arrays.asList(authority));
		
       return userDetails;
}

	

}
