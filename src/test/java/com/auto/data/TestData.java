package com.auto.data;

import com.auto.config.PropertyConfig;
import lombok.Data;

@Data
public class TestData
{
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getFirstViewOrder() {
        return firstViewOrder;
    }

    public String getFirstOrderTotal() {
        return firstOrderTotal;
    }

    public String getFirstOrderStatus() {
        return firstOrderStatus;
    }

    public void setFirstViewOrder(String firstViewOrder, String firstOrderTotal, String firstOrderStatus) {
        this.firstViewOrder = firstViewOrder;
        this.firstOrderTotal = firstOrderTotal;
        if (firstOrderStatus.contains(PropertyConfig.getValue("orders.status.dispatched"))) {
            this.firstOrderStatus = PropertyConfig.getValue("orders.status.dispatched");
        } else {
            this.firstOrderStatus = firstOrderStatus;
        }
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    private String site;
    private String firstViewOrder;
    private String firstOrderTotal;
    private String firstOrderStatus;
    private long offset;
}