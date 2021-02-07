package com.sdk.duomai.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DuoMaiGoodsBaseResponse<R> implements Serializable {

    private String status;

    private String message;

    private R data;

}
