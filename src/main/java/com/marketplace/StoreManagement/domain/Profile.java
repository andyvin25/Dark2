package com.marketplace.StoreManagement.domain;

import com.marketplace.Util.Auditable;

import com.marketplace.Util.GeneratedId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`Profiles`")
@Getter @Setter @NoArgsConstructor
public class Profile extends Auditable {

    @Id
    @GeneratedId
    private String id;

//    @Column(name = "bucket_name", length = 300)
//    private String bucketName;
//
    @Column(name = "filename", length = 300)
    private String filename;

    @Column(name = "logo_path", length = 300)
    private String logoPath;

    @OneToOne(mappedBy = "storeProfile")
    private Store store;

    public Profile(Store store) {
        this.setStore(store);
    }

    public Profile(String logoPath, Store store
//            , String bucketName,
            ,String filename
    ) {
        this.setLogoPath(logoPath);
        this.setStore(store);
//        this.setBucketName(bucketName);
        this.setFilename(filename);
    }

}
