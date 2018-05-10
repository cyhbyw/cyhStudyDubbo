package bhz.dubbo.direct;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DirectConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"direct-consumer.xml"});
        context.start();

        DirectService directService = (DirectService) context.getBean("directService");
        String ret = directService.direct();
        System.out.println(ret);
    }

}
