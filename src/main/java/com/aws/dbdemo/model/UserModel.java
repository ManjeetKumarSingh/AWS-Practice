package com.aws.dbdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@ToString
@SuperBuilder
public class UserModel {
    private String name ;
    private String email;
}
