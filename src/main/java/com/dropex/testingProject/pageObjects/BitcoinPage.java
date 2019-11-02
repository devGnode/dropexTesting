package com.dropex.testingProject.pageObjects;

import com.dropex.testingProject.restClient.Bitcoin;
import com.dropex.testingProject.utils.ReportUtils;
import io.restassured.response.Response;

public class BitcoinPage {

    public Response getResponceBitcoinAddrBalance(String addr){
        return Bitcoin.getBalanceAddr(addr);
    }
}
