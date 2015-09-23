package com.hy.designpatern.struct.responsibilitychain._03struts;

import java.io.Serializable;
//拦截器mapping，对应于xml中的名字
public class InterceptorMapping implements Serializable {

    private static final long serialVersionUID = 130216399397955317L;
    private String name;
    private Interceptor interceptor;

    public InterceptorMapping(String name, Interceptor interceptor) {
        this.name = name;
        this.interceptor = interceptor;
    }

    public String getName() {
        return name;
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final InterceptorMapping that = (InterceptorMapping) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        return result;
    }
}