package com._like.Domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseManager {

    protected Long id;
    protected String name;
    protected String username;
    protected Integer age;
    protected String password;
    protected String picture;
    protected Boolean gender;
    protected String Resident_ID_Number;
}
