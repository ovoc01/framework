package web.servlet;

import web.urlmapping.Url;

public abstract class ServletCrud {
    @Url(url = "/")
    public abstract void select();
    @Url(url = "/")
    public abstract void insert();
    @Url(url = "/")
    public abstract void update();
    @Url(url = "/")
    public abstract void delete();
}
