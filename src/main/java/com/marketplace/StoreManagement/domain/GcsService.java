package com.marketplace.StoreManagement.domain;

import com.google.cloud.storage.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GcsService {
    private Storage storage;

    @Value("${gcs.bucket-name}")
    private String bucketName;

    @PostConstruct
    public void initStorage() {
        storage = StorageOptions.getDefaultInstance().getService();
    }

//    @Value("${gcs.bucket-name}")
//    private String bucketName;
//
//    @Value("${gcs.subdirectory}")
//    private String subDir;

//    public String uploadImage(MultipartFile file, String userId) throws IOException {
//        String filename = bucketConfig.bucketName() + "/" + userId + "/" + "profile" + "/" + file.getOriginalFilename();
//        Blob blob = storage.create(
//                BlobInfo.newBuilder(bucketConfig.bucketName(), filename).build(),
//                file.getBytes()
//        );
//        BlobInfo blobInfo = blob.asBlobInfo();
//
//        try (WriteChannel writer = storage.writer(blobInfo)){
//
//        }
//    }

    private String buildBlobPath(String storeId, String fileOriginalName) {
        return storeId + "/" + fileOriginalName + ".jpg";
    }

    public String uploadProfile(byte[] file, String storeId, String fileOriginalName) throws IOException {
        String blobPath = buildBlobPath(storeId, fileOriginalName);
        Blob blob = storage.create(
                BlobInfo.newBuilder(bucketName, blobPath).build(),
                file
        );
        return blob.getMediaLink();
    }

    public void deleteFile(String storeId, String fileOriginalName) {
        String blobPath = buildBlobPath(storeId, fileOriginalName);

        BlobId blobId = BlobId.of(bucketName, blobPath);
        storage.delete(blobId);
    }

}
