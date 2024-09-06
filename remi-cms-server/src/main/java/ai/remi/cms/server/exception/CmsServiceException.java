package ai.remi.cms.server.exception;

import ai.remi.comm.exception.custom.BusinessException;

public class CmsServiceException extends BusinessException {

    public CmsServiceException(String code, String message) {
        super(code, message);
    }

    public CmsServiceException(String code, Throwable cause) {
        super(code, cause);
    }

    public CmsServiceException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public CmsServiceException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
