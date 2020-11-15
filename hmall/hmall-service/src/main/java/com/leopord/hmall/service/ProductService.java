package com.leopord.hmall.service;

import com.leopord.hmall.entity.Product;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.hmall.leopord.com" ,name = "productPortType")
public interface ProductService {

    @WebMethod(operationName = "getProductById")
    Product searchProduct(@WebParam(name = "id") Integer id);
}
