package com.orange.toystorebackend.command;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderCommand {

    /* command purchase Order json:
    * {
    * userId ,
    * date ,
    * productList [{productId}]
    * }
    * */

    public Integer userId;
    public String date;
    public List<Integer> productList = new ArrayList<>();

}
