package com.example.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.AssetData;
import com.example.repository.AssetDataRepository;

import io.swagger.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/assetData")
public class AssetDataController {

    private final AssetDataRepository assetDataRepository;

    public AssetDataController(AssetDataRepository assetDataRepository) {
        this.assetDataRepository = assetDataRepository;
    }

    @GetMapping 
    public List<AssetData> getAssetData() {
        return assetDataRepository.findAll();
    }

    @GetMapping("/{id}")
    public AssetData getAssetDataByID(@PathVariable Long id) {
        return assetDataRepository.findById(id).orElseThrow();
    }

    @PostMapping 
    public ResponseEntity createAssetData(@RequestBody AssetData assetData) throws URISyntaxException {
        AssetData savedAssetData = assetDataRepository.save(assetData);
        return ResponseEntity.created(new URI("/assetData/" + savedAssetData.getId())).body(savedAssetData);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAssetData(@PathVariable Long id, @RequestBody AssetData assetData) {
        AssetData currentAssetData = assetDataRepository.findById(id).orElseThrow();
        currentAssetData.setAssetID(assetData.getAssetID());
        currentAssetData.setAssetName(assetData.getAssetName());
        currentAssetData.setDayVolumeUSD(assetData.getDayVolumeUSD());
        currentAssetData.setHourVolumeUSD(assetData.getHourVolumeUSD());
        currentAssetData.setMonthVolumeUSD(assetData.getMonthVolumeUSD());
        currentAssetData.setPriceUSD(assetData.getPriceUSD());

        currentAssetData = assetDataRepository.save(assetData);

        return ResponseEntity.ok(currentAssetData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        assetDataRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}   
