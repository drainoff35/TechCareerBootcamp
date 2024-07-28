package com.example.CarRentalProject.Services.Abstract;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BaseService<T,ID> {
   public List<T> GetAll();
   public Optional<T> GetById(ID id);
   public T Create(T t);
   public T Update(ID id,T t);
   public void Delete(ID id);
}
