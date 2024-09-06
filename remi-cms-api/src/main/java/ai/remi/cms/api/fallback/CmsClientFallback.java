package ai.remi.cms.api.fallback;

import ai.remi.cms.api.client.CmsClientApi;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CmsClientFallback implements CmsClientApi {
    @Setter
    private Throwable cause;

    @Override
    public String findById(int goodsId) {
        log.error("findById = {}", cause.getMessage());
        return null;
    }
}
