package com.deathjack.DeathJack.http_response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Object data;

    public Response (Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
