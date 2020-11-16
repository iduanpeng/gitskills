package com.iduanpeng.base.generic;

public class GenericTest {

    public <T> T getObject(Class<T> t) throws Exception{
        T c = t.newInstance();
        return c;
    }

}
