import com.gome.o2m.swagger.SwaggerDemoStart
import com.gome.o2m.swagger.model.City
import com.gome.o2m.swagger.service.CityReadService
import com.gome.o2m.swagger.service.CityWriteService
import org.spockframework.spring.ScanScopedBeans
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@ScanScopedBeans
@SpringBootTest(classes = SwaggerDemoStart.class)
class CityReadServiceSpec extends Specification{

    @Autowired
    private CityReadService cityReadService;
    @Autowired
    private CityWriteService cityWriteService;

    def "test"(){
        expect:
        cityReadService != null
    }

    def "test2"(){
        when:
        def list = cityReadService.list();
        then:
        list.size() == 3
        def city = list.get(0);
        println "City" + city
    }

    @Unroll
    def "test3:(name->#name, state->#state, country->#country), expect:#result"(){
        /*前置*/
        given:
        def city = new City()
        city.setName(name)
        city.setCountry(country)
        city.setState(state)

        /*期望*/
        expect:
        result == cityWriteService.insert(city)

        /*条件*/
        where:
        name | state | country | result
        'San Francisco5' | 'CA5' | 'US5'| true
        'San Francisco6' | 'CA6' | 'US6'| true
        'San Francisco7' | 'CA7' | 'US7'| true

    }
}