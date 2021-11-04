package com.example.savestate.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\'J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\'J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/savestate/database/PhoneDao;", "", "delete", "", "phoneItem", "Lcom/example/savestate/database/PhoneItem;", "(Lcom/example/savestate/database/PhoneItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "", "insert", "phoneList", "", "loadAllBook", "app_debug"})
public abstract interface PhoneDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.savestate.database.PhoneItem> phoneList);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM phone_table")
    public abstract java.util.List<com.example.savestate.database.PhoneItem> loadAllBook();
    
    @androidx.room.Query(value = "DELETE FROM phone_table")
    public abstract int deleteAll();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.savestate.database.PhoneItem phoneItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}