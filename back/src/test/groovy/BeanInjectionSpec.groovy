import com.workshop.back.BackApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.inject.Inject

@SpringBootTest
@ContextConfiguration(classes = [BackApplication.class])
class BeanInjectionSpec extends Specification {

    @Inject
    BackApplication app

    void setup() {
        println 'setup'
    }

    def 'it should run the app'() {
        expect:
        app
    }






}