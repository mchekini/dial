import com.workshop.back.authentication.AuthenticationConfiguration
import com.workshop.back.persistence.DatabaseConfig
import com.workshop.back.persistence.entity.Member
import com.workshop.back.persistence.entity.Role
import com.workshop.back.persistence.repository.MemberRepository
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import javax.inject.Inject

import static groovyx.net.http.ContentType.JSON
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

/**
 * @Author mahdchek.
 */

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = [AuthenticationConfiguration, DatabaseConfig])
@ActiveProfiles("test")
@EnableAutoConfiguration
class AuthenticationResourceSpec extends Specification {

    @LocalServerPort
    int port

    @Inject
    MemberRepository repo

    RESTClient client

    void setup() {
        println 'the selected port  = ' + port
        client = new RESTClient("http://localhost:$port")
        client.handler.failure = { resp, data ->
            resp.data = data
            resp
        }
    }


    @Unroll
    def 'it should check if user is authenticated'() {
        given:
        Member member = Member.builder()
                .login("hocine")
                .password('08bb247e704fefee83a0541b92aba052')
                .role(Role.ADMIN)
                .email('h_goumez@esi.fr')
                .firstName('hocine')
                .lastName('hacene')
                .build()

        repo.save(member)

        when:
        HttpResponseDecorator resp = client.post(
                path: '/authenticate/check',
                contentType: JSON,
                requestContentType: JSON,
                body: user
        )
        then:
        resp.responseData.status == status
        resp.responseData.entity == message

        where:
        user                                  | status | message
        [login: 'hocine', password: 'hocine'] | 200    | [firstName: 'hocine', lastName: 'hacene', login: 'hocine', role: 'ADMIN']
        [login: 'hocine', password: 'test']   | 401    | 'password incorrect'
        [login: 'hacene', password: 'test']   | 401    | 'utilisateur introuvable'
    }
}

