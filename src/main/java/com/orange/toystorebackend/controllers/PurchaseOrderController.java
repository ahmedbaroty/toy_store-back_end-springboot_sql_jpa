package com.orange.toystorebackend.controllers;

import com.orange.toystorebackend.command.PurchaseOrderCommand;
import com.orange.toystorebackend.entities.PurchaseOrder;
import com.orange.toystorebackend.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @RequestMapping(method = RequestMethod.POST , value = "api/order")
    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrderCommand purchaseOrderCommand){
        return purchaseOrderService.addOrder(purchaseOrderCommand);
    }
}
