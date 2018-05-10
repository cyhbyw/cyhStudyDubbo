package bhz.dubbo.sample;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"sample-consumer.xml"});
        context.start();

        SampleService sampleService = (SampleService) context.getBean("sampleService");
        String hello = sampleService.sayHello("SampleConsumer");
        System.out.println(hello);

        List list = sampleService.getUsers();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

}
