package com.chany.roomdemo;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\'\u00a8\u0006\r"}, d2 = {"Lcom/chany/roomdemo/ProductDao;", "", "deleteProduct", "", "name", "", "findProduct", "", "Lcom/chany/roomdemo/Product;", "getAllProducts", "Landroidx/lifecycle/LiveData;", "insertProduct", "product", "roomdemo_debug"})
public abstract interface ProductDao {
    
    @androidx.room.Insert
    public abstract void insertProduct(@org.jetbrains.annotations.NotNull
    com.chany.roomdemo.Product product);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM products WHERE productName = :name")
    public abstract java.util.List<com.chany.roomdemo.Product> findProduct(@org.jetbrains.annotations.NotNull
    java.lang.String name);
    
    @androidx.room.Query(value = "DELETE FROM products WHERE productName = :name")
    public abstract void deleteProduct(@org.jetbrains.annotations.NotNull
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM products")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.chany.roomdemo.Product>> getAllProducts();
}