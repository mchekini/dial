import com.workshop.back.authentication.AuthenticationService
import com.workshop.back.authentication.dto.UserDto
import com.workshop.back.authentication.dto.UserOutputDto
import com.workshop.back.authentication.exceptions.InvalidPasswordException
import com.workshop.back.authentication.exceptions.UserNotFoundException
import com.workshop.back.persistence.entity.Member
import com.workshop.back.persistence.entity.Role
import com.workshop.back.persistence.repository.MemberRepository
import spock.lang.Specification
import spock.lang.Unroll

class AuthenticationServiceSpec extends Specification {


    def repo = Mock(MemberRepository)
    def service = new AuthenticationService(repo)


    void setup() {

    }


    @Unroll
    def 'it should test'() {
        given:
        UserDto userDto = UserDto.builder().login(login).password(password).build()
        Member member = Member.builder()
                .login("hocine")
                .password('08bb247e704fefee83a0541b92aba052')
                .role(Role.ADMIN)
                .email('h_goumez@esi.fr')
                .firstName('hocine')
                .lastName('hacene')
                .build()

        repo.findById('hocine') >> Optional.of(member)
        repo.findById('hacene') >> Optional.empty()

        when:
        UserOutputDto result = service.checkAuthentication(userDto)

        then:
        thrown exception



        where:
        login    | password | exceptionexist | exception
        'hocine' | 'hacene' | true           | InvalidPasswordException
        'hacene' | 'hacene' | true           | UserNotFoundException

    }

}
