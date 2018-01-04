package com.orange.toystorebackend.services;

import com.orange.toystorebackend.command.PurchaseOrderCommand;
import com.orange.toystorebackend.entities.Product;
import com.orange.toystorebackend.entities.PurchaseOrder;
import com.orange.toystorebackend.entities.User;
import com.orange.toystorebackend.repositories.ProductRepository;
import com.orange.toystorebackend.repositories.PurchaseOrderRepository;
import com.orange.toystorebackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    /* command purchase Order json:
    * ------------------------
    * {
    * userId ,
    * date ,
    * productList [{productId}]
    * }
    * */

    public PurchaseOrder addOrder(PurchaseOrderCommand purchaseOrderCommand) {
        User user = userRepository.findOne(purchaseOrderCommand.userId);
        List<Product> productList = new ArrayList<>();
        for(Integer x : purchaseOrderCommand.productList){
            productList.add(productRepository.findOne(x));
        }

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setLocalDate(LocalDate.now()+"");
        purchaseOrder.setLocalTime(LocalTime.now()+"");
        purchaseOrder.setProductList(productList);
        purchaseOrder.setUser(user);

        return purchaseOrderRepository.save(purchaseOrder);
    }


}
