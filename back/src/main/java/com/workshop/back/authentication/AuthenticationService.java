package com.workshop.back.authentication;


import com.workshop.back.authentication.dto.UserDto;
import com.workshop.back.authentication.dto.UserOutputDto;
import com.workshop.back.authentication.exceptions.InvalidPasswordException;
import com.workshop.back.authentication.exceptions.UserNotFoundException;
import com.workshop.back.persistence.entity.Member;
import com.workshop.back.persistence.repository.MemberRepository;
import com.workshop.back.utils.Security;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AuthenticationService {


    private final MemberRepository repo;

    @Inject
    public AuthenticationService(MemberRepository repo) {
        this.repo = repo;
    }

    public UserOutputDto checkAuthentication(UserDto user) throws UserNotFoundException, NoSuchAlgorithmException, InvalidPasswordException {

        Optional<Member> optionalMember = repo.findById(user.getLogin());

        if (!optionalMember.isPresent()) throw new UserNotFoundException("utilisateur introuvable");
        if (!optionalMember.get().getPassword().equals(Security.hashMD5(user.getPassword())))
            throw new InvalidPasswordException("password incorrect");

        return UserOutputDto.builder()
                            .firstName(optionalMember.get().getFirstName())
                            .lastName(optionalMember.get().getLastName())
                            .login(optionalMember.get().getLogin())
                            .role(optionalMember.get().getRole().name())
                            .build();

    }
}
