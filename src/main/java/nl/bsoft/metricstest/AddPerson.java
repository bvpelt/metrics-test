package nl.bsoft.metricstest;

import nl.bsoft.metricstest.model.Person;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class AddPerson {

    private Logger logger = Logger.getLogger(AddPerson.class.getName());

    private RestTemplate template = new RestTemplate();
    private Random r = new Random();

    public static void main(String[] args) {

        AddPerson za = new AddPerson();

        za.initialize();

        za.addData();
    }

    private void initialize() {
        List<HttpMessageConverter<?>> mc = template.getMessageConverters();
        mc.add(new MappingJackson2HttpMessageConverter());
        template.setMessageConverters(mc);
    }

    public void addData() {
        for (int j = 0; j < 1000; j++) {
            int ix = new Random().nextInt(100000);
            Person p = new Person();
            p.setFirstName("Jan" + ix);
            p.setLastName("Test" + ix);
            p.setGeslacht("M");
            p.setAge(ix % 100);
            p = template.postForObject("http://localhost:8080/persons", p, Person.class);
            logger.info("New person: " + p);

            p = template.getForObject("http://localhost:8080/persons/{id}", Person.class, p.getId());
            p.setAge(ix % 100);
            template.put("http://localhost:8080/persons", p);
            logger.info("Person updated: " + p + " with age=" + ix % 100);

            template.delete("http://localhost:8080/persons/{id}", p.getId());
        }
    }
}
