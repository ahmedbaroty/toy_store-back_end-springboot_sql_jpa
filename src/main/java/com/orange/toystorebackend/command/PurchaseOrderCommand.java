package com.orange.toystorebackend.command;

import java.util.List;

public class PurchaseOrderCommand {

    /* command purchase Order json:
    * {
    * userId ,
    * productList [{productId}]
    * }
    * */

    public Integer userId;
    public List<Integer> productList;

}

