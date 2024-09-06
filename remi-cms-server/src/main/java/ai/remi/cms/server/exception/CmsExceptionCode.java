package ai.remi.cms.server.exception;

import ai.remi.comm.exception.enums.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CmsExceptionCode implements ExceptionCode {

    /**
     * 业务异常code
     */
    INVENTORY_CHECK_FAIL("B2006", "库存不足"),
    QUERY_ORDER_FAIL("B2007", "查询订单失败");


    private String code;

    private String key;
}
