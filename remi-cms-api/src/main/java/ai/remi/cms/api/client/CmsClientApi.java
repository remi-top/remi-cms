package ai.remi.cms.api.client;

import ai.remi.cms.api.factory.CmsClientFactory;
import ai.remi.comm.feign.aspect.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "remi-cms-web", configuration = FeignAutoConfiguration.class, fallbackFactory = CmsClientFactory.class)
public interface CmsClientApi {

    @GetMapping("/books/findByBooksId")
    String findById(@RequestParam("booksId") int booksId);
}
