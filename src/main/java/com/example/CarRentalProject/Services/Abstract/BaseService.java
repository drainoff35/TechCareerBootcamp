package com.example.CarRentalProject.Services.Abstract;

import java.util.List;

public interface BaseService<Dto,ID> {
   public List<Dto> GetAll();
   public Dto GetById(ID id);
   public Boolean Create(Dto dto);
   public Boolean Update(ID id,Dto dto);
   public Void Delete(ID id);
}

