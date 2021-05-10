package com.estdois.leriando.service;

import com.estdois.leriando.entity.Usuario;
import com.estdois.leriando.persistence.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class LUserDetailsService implements UserDetailsService {

    private UsuarioRepository userRepository;

    public LUserDetailsService(UsuarioRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario user = userRepository.findByNome(username);
            if(user==null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(user.getNome(), user.getSenha(), getAuthories(user));
        }

        catch (Exception e)
        {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
    }

    private Set<GrantedAuthority> getAuthories(Usuario user){

        Set<GrantedAuthority> authorities = new HashSet<>();
        /*for (Role role: user.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);sdsdsdsdsssas
        }*/
        return authorities;
    }
}
