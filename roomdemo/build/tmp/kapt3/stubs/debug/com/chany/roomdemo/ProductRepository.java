package com.chany.roomdemo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/chany/roomdemo/ProductRepository;", "", "productDao", "Lcom/chany/roomdemo/ProductDao;", "(Lcom/chany/roomdemo/ProductDao;)V", "allProducts", "Landroidx/lifecycle/LiveData;", "", "Lcom/chany/roomdemo/Product;", "getAllProducts", "()Landroidx/lifecycle/LiveData;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "searchResult", "Landroidx/lifecycle/MutableLiveData;", "getSearchResult", "()Landroidx/lifecycle/MutableLiveData;", "asyncFind", "Lkotlinx/coroutines/Deferred;", "name", "", "deleteProduct", "", "findProduct", "insertProduct", "newProduct", "roomdemo_debug"})
public final class ProductRepository {
    private final com.chany.roomdemo.ProductDao productDao = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.chany.roomdemo.Product>> allProducts = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.chany.roomdemo.Product>> searchResult = null;
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    public ProductRepository(@org.jetbrains.annotations.NotNull
    com.chany.roomdemo.ProductDao productDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.chany.roomdemo.Product>> getAllProducts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.chany.roomdemo.Product>> getSearchResult() {
        return null;
    }
    
    public final void insertProduct(@org.jetbrains.annotations.NotNull
    com.chany.roomdemo.Product newProduct) {
    }
    
    public final void deleteProduct(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void findProduct(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    private final kotlinx.coroutines.Deferred<java.util.List<com.chany.roomdemo.Product>> asyncFind(java.lang.String name) {
        return null;
    }
}