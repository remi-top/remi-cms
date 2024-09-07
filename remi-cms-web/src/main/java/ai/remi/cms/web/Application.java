package ai.remi.cms.web;

import ai.remi.comm.feign.annotation.EnableRemiFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 系统服务启动程序
 */
 //@EnableLogRecord
//@EnableDiscoveryClient
@EnableRemiFeignClients
@SpringBootApplication(scanBasePackages = "ai.remi")
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class Application {

    public static void main(String[] args) {

        System.setProperty("cfg.env","dev");

        SpringApplication.run(Application.class, args);

        System.out.println("(♥◠‿◠)ﾉﾞ  Remi CMS Web Startup Completed!   ლ(´ڡ`ლ)ﾞ ");

    }

}
