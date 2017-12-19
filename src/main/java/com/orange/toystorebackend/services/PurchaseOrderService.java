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

        List<Product> productList = (List<Product>)productRepository.findAll(
                purchaseOrderCommand.productList
        );

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setDate(purchaseOrderCommand.date);
        purchaseOrder.setProductList(productList);
        purchaseOrder.setUser(user);

        return purchaseOrderRepository.save(purchaseOrder);
    }


}
