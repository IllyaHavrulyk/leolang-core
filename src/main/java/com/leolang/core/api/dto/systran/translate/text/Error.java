package com.leolang.core.api.dto.systran.translate.text;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private String message;
    private HttpStatus statusCode;
    private String info;
}
