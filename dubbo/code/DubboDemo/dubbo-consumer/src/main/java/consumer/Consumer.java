package consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import nfcapi.DemoService;

public class Consumer {

	public static void main(String[] args) {
		//测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.err.println("consumer start");
        DemoService demoService = context.getBean(DemoService.class);
        System.err.println("consumer");
        System.out.println(demoService.helloDubbo());
	}
}
