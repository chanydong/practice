package com.chany.roomdemo;

import java.lang.System;

@androidx.room.Entity(tableName = "products")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/chany/roomdemo/Product;", "", "()V", "productName", "", "quantity", "", "(Ljava/lang/String;I)V", "id", "getId", "()I", "setId", "(I)V", "getProductName", "()Ljava/lang/String;", "setProductName", "(Ljava/lang/String;)V", "getQuantity", "setQuantity", "roomdemo_debug"})
public final class Product {
    @androidx.room.ColumnInfo(name = "productId")
    @androidx.annotation.NonNull
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "productName")
    private java.lang.String productName = "";
    private int quantity = 0;
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProductName() {
        return null;
    }
    
    public final void setProductName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final void setQuantity(int p0) {
    }
    
    public Product() {
        super();
    }
    
    public Product(@org.jetbrains.annotations.NotNull
    java.lang.String productName, int quantity) {
        super();
    }
}