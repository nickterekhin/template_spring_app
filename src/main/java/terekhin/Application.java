package terekhin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import terekhin.person.Person;
import terekhin.services.ClientService;

/**
 * Created by Nick on 22.10.17.
 */
public class Application {
    public static void main(String[] args) {
        //ApplicationContextAware
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ClientService clientService = context.getBean("clientService", ClientService.class);
        Person pJohn = context.getBean("john-modern",Person.class);
        System.out.println(clientService.getName());
        System.out.println(pJohn.getName());
        System.out.println(pJohn.getSpouse().getName());
    }
}
