package web.methodinvoker;

import web.controller.HttpHandlerGeneric;
import web.urlmapping.Url;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MethodHandler {

    private Map<String,Method> stringMethodMap;
    HttpHandlerGeneric httpHandlerGeneric;
    public MethodHandler(HttpHandlerGeneric httpHandlerGeneric){
        this.httpHandlerGeneric = httpHandlerGeneric;
        stringMethodMap = new HashMap<>();
        retrieveAllUrlMappedMethod();
    }

    public Map<String, Method> getStringMethodMap() {
        return stringMethodMap;
    }



    public void retrieveAllUrlMappedMethod(){
        Method [] listMethod = httpHandlerGeneric.getClass().getDeclaredMethods();
        int methodsAllLength = listMethod.length; ;
        for (int i = 0; i < methodsAllLength; i++) {
            //System.out.println(listMethod[i].isAnnotationPresent(Url.class));
            if(listMethod[i].isAnnotationPresent(Url.class)){
                System.out.println("tato");
                urlMappedMethod(listMethod[i]);
            }
        }
    }


    private void urlMappedMethod(Method method){
        Url url = method.getAnnotation(Url.class);
        if(url.url()!=null) stringMethodMap.put(url.url(),method);
        else stringMethodMap.put(method.getName(),method);
    }
}
