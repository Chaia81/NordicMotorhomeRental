package com.example.demo.repositories;

import com.example.demo.models.MotorhomeDTO;

import java.util.List;

public interface IMotorhomeRepository {

    // CRUD operations

    public void create(MotorhomeDTO motorhome);

    public MotorhomeDTO read(int motorhomeId);

    public List<MotorhomeDTO> readAll();

    public void edit(MotorhomeDTO motorhome);

    public void delete(int motorhomeId);
}
