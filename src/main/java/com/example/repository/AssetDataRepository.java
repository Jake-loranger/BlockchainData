package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.AssetData;

public interface AssetDataRepository extends JpaRepository<AssetData, Long> {

}
