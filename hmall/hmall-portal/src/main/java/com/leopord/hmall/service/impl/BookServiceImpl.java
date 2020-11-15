package com.leopord.hmall.service.impl;

import com.alibaba.fastjson.JSON;
import com.leopord.hmall.entity.Product;
import com.leopord.hmall.service.BookService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public Product getProductById(Integer id) {
        JaxWsDynamicClientFactory dcflient= JaxWsDynamicClientFactory.newInstance();

        Client client=dcflient.createClient("http://localhost:8080/ws/product?wsdl");

        Product product = null;
        try{
            Object[] objects=client.invoke("getProductById",id);
            String result = JSON.toJSONString(objects[0]);
            product = JSON.parseObject(result, Product.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        if (product == null) {
            product = new Product();
            product.setId(-1);
        }
        System.out.println(JSON.toJSONString(product));
        return product;
    }
}
