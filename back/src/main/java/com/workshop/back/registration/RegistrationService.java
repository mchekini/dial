package com.workshop.back.registration;

import com.workshop.back.authentication.dto.UserOutputDto;
import com.workshop.back.persistence.entity.Member;
import com.workshop.back.persistence.repository.MemberRepository;
import com.workshop.back.registration.dto.MemberDto;
import com.workshop.back.registration.exceptions.UserExistsException;
import com.workshop.back.registration.exceptions.ValidationException;
import com.workshop.back.utils.Security;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.workshop.back.persistence.entity.Role.USER;

@Service
public class RegistrationService {

    private final MemberRepository repo;
    private Validator validator;

    @Inject
    public RegistrationService(MemberRepository repo, Validator validator) {
        this.repo = repo;
        this.validator = validator;
    }

    public UserOutputDto register(MemberDto memberDto) throws ValidationException, UserExistsException, NoSuchAlgorithmException {


        Set<ConstraintViolation<MemberDto>> violations = validator.validate(memberDto);

        List<String> errors = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        if (!errors.isEmpty()) throw new ValidationException(errors);

        Optional<Member> optionalMember = repo.findById(memberDto.getLogin());

        if (optionalMember.isPresent()) throw new UserExistsException("utilisateur existe deja");


        Member member = Member.builder().email(memberDto.getEmail())
                                        .firstName(memberDto.getFirstName())
                                        .lastName(memberDto.getLastName())
                                        .login(memberDto.getLogin())
                                        .password(Security.hashMD5(memberDto.getPassword()))
                                        .role(USER)
                                        .build();

        repo.save(member);


        return UserOutputDto.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .login(member.getLogin())
                .role(member.getRole().name())
                .build();

    }
}
