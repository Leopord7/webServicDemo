package com.leopord.hmall.service.impl;

import com.leopord.hmall.dao.ProductMapper;
import com.leopord.hmall.entity.Product;
import com.leopord.hmall.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;

@WebService(
        targetNamespace = "http://service.hmall.leopord.com",
        name = "productPortType",
        serviceName = "productService",
        portName = "productPortName",
        endpointInterface = "com.leopord.hmall.service.ProductService")
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product searchProduct(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }
}
