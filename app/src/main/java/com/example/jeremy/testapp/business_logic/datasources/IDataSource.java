package com.example.jeremy.testapp.business_logic.datasources;

import java.util.List;

public interface IDataSource<T> {
    void open();
    void close();
    void add(T t);
    List<T> getAll();
    void remove(int id);
    void removeAll();
}
