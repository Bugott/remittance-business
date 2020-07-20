package com.intern.test01service.model;

import javax.persistence.*;

/**
 * @author Bugott
 */
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int code;

    private String message;

    public Record() {
    }

    public Record(Integer id, int code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
