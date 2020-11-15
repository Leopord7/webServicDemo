package com.leopord.hmall.config;

import com.leopord.hmall.service.ProductService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Resource
    private ProductService productService;

    @Bean("cxfServletRegistration")
    public ServletRegistrationBean dispatcherServlet(){

        return new ServletRegistrationBean(new CXFServlet(),"/ws/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), productService);
        endpoint.publish("/product");
        return endpoint;
    }
}
