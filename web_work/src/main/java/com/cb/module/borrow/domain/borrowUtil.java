package com.cb.module.borrow.domain;

public class borrowUtil {

    private static final long serialVersionUID = 1L;

    private String itemsId;

    private String borrowNumbers;

    public String getBorrowNumbers() {
        return borrowNumbers;
    }

    public void setBorrowNumbers(String borrowNumbers) {
        this.borrowNumbers = borrowNumbers;
    }

    public String getItemsId() {
        return itemsId;
    }

    public void setItemsId(String itemsId) {
        this.itemsId = itemsId;
    }
}
