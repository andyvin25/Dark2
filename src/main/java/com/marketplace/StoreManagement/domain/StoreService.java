package com.marketplace.StoreManagement.domain;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import net.coobird.thumbnailator.Thumbnails;

import com.marketplace.Util.ImageName;
import com.marketplace.Util.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.Exception.ResourceNotFoundException;
import com.marketplace.StoreManagement.api.StoreProjection;

@Slf4j
@Service("StoreService")
public class StoreService {
    
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private GcsService gcsService;
    
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public List<StoreProjection> getAllIdAndNameStores() {
        return storeRepository.getAllStore();
    }

    public Store saveStore(Store store) {
        Objects.requireNonNull(store);
        return storeRepository.save(store);
    }

    @Cacheable(value = "stores")
    public Optional<Store> getStoreById(String storeId) {
        return storeRepository.findById(storeId);
    } 

    public Boolean hasStoreNameSame(String storeName) {
        return getAllStores().stream()
            .anyMatch(store -> store.getName().contains(storeName));
    }

    public String uploadStoreProfile(String storeId, MultipartFile file) throws IOException {
        Store store = getStoreById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("The store with this id not found"));
        if (!file.getContentType().equals("image/png") &&
                !file.getContentType().equals("image/jpeg") &&
                !file.getContentType().equals("image/jpg")
        ) {
            throw new IllegalArgumentException("Invalid file type. Only PNG or JPEG or JPG files are allowed");
        }
        if (file.getSize() > 2_000_000) {
            throw new IllegalArgumentException("File is too large. The size limit is 2 MB.");
        }

        byte[] compressedByte = compressImage(file);

        if (store.getStoreProfile().getLogoPath() != null) {
            gcsService.deleteFile(store.getId(), store.getStoreProfile().getFilename());
        }
        String storeIdImageDirectory = store.getId();
        String imageNameGenerated = ImageName.generateName();
        Profile profile = store.getStoreProfile();

        String imagePath = gcsService.uploadProfile(compressedByte, storeIdImageDirectory, imageNameGenerated);
        System.out.println("imagePath = " + imagePath);
        profile.setLogoPath(imagePath);
        profile.setFilename(imageNameGenerated);
        saveStore(store);
        return imagePath;
    }

    @Transactional(readOnly = true)
    public String getStoreLogo(String storeId) {
        Store store = getStoreById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("The store with this id not found"));
//        if (store.getStoreProfile() == null) {
//            throw new ResourceNotFoundException("store profile must be created first is not found");
//        }
        if (store.getStoreProfile().getLogoPath() == null) {
            return "There is no profile to retrieve";
        }
        String storeLogoPath = store.getStoreProfile().getLogoPath();
//        Path filePath = Paths.get(storeLogoPath);
//        if (!Files.exists(filePath)) {
//            throw new ResourceNotFoundException("Path is not found");
//        }
        return storeLogoPath;
    }

    @Transactional
    public void deleteStoreLogo(String storeId) {
        Store store = getStoreById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store with this id not found"));
        Profile profile = store.getStoreProfile();
//        if (profile.getLogoPath() == null) {
//            throw new ResourceNotFoundException("logo is not found");
//        }
//        Path filePath = Paths.get(profile.getLogoPath()).normalize();
//        if (!Files.exists(filePath)) {
//            throw new ResourceNotFoundException("The file is not found");
//        }
//        try {
//            Files.delete(filePath);
//            log.info("store picture profile is: {}" + profile);
//        } catch (IOException e) {
//            log.error("/api/stores/{store_id}/uploaded_images", "delete store logo error is: {}", e.getMessage());
//            throw new IllegalArgumentException("Can't read the file");
//        }
        if (profile.getFilename() == null) {
            throw new ResourceNotFoundException("You haven't upload logo to your profile yet");
        }
        gcsService.deleteFile(store.getId(), profile.getFilename()); // storeId first
        profile.setFilename(null);
        profile.setLogoPath(null);
//        log.info("store picture profile is: {}" + profile, "second time invoke");
        saveStore(store);
    }

    private byte[] compressImage(MultipartFile file) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Thumbnails.of(file.getInputStream())
                .scale(1.0)
                .outputQuality(0.3)
                .outputFormat("jpg")   // just define format here, unrelated to GCS filename
                .toOutputStream(outputStream);

        return outputStream.toByteArray();
    }

}
