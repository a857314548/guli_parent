package com.zhangzhen.servicebase.config.hanled;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class customException extends RuntimeException {
    private Integer customCode;

    private String msg;
}
