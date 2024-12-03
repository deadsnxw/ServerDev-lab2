package com.example.rest.models;

public class Record {
    private Long id;
    private Long userId;
    private Long categoryId;
    private String timestamp;
    private Double amount;

    public Record() {}

    public Record(Long id, Long userId, Long categoryId, String timestamp, Double amount) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

