package ai.remi.cms.api.factory;

import ai.remi.cms.api.client.CmsClientApi;
import ai.remi.cms.api.fallback.CmsClientFallback;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CmsClientFactory implements FallbackFactory<CmsClientApi> {

    @Override
    public CmsClientApi create(Throwable cause) {
        CmsClientFallback fallback = new CmsClientFallback();
        fallback.setCause(cause);
        return fallback;
    }
}

