package com.aydog4nn.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestRootEntity<T> {

        private Integer status;

        private T payload;

        private String ErrorMessage;

        public static <T> RestRootEntity<T> ok(T payload){
            RestRootEntity<T> rootEntity = new RestRootEntity<>();
            rootEntity.setStatus(HttpStatus.OK.value());
            rootEntity.setErrorMessage(null);
            rootEntity.setPayload(payload);

            return rootEntity;
        }

}
