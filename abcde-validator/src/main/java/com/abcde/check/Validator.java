package com.abcde.check;

import java.util.ArrayList;
import java.util.List;

public abstract class Validator<T> {

    private List<String> errMsgs = new ArrayList<>();

    private T data;

    protected Validator(T data) {
        this.data = data;
    }

    protected abstract boolean doCheck();

    public boolean check () {
        if (null == data) {
            getErrMsgs().add("参数为空！");
            return false;
        }

        return doCheck();
    }

    public List<String> getErrMsgs(){
        return errMsgs;
    }
}
