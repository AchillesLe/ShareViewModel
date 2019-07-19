package com.dev.shareviewmodel.model.RESPONSE;

import com.dev.shareviewmodel.model.User;

import java.util.List;

public class listUser {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<User> getData() {
        return data;
    }
}
