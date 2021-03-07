package es.codeurjc.mca.practica_1_cloud_ordinaria_2021.image;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("storageService")
@Profile("production")
public class ProductionImageService implements ImageService {

    private String bucket;
    private String endpoint;
    private String region;

    private Logger log = LoggerFactory.getLogger(ProductionImageService.class);

    public static AmazonS3 s3;


    public ProductionImageService(@Value("${amazon.s3.bucket-name}") String bucket,@Value("${amazon.s3.endpoint}") String endpoint, @Value("${amazon.s3.region}") String region) {
        this.bucket = bucket;
        this.endpoint = endpoint;
        this.region = region;

        s3 = AmazonS3ClientBuilder.standard().withRegion(region).build();
    }

    @Override
    public String createImage(MultipartFile multiPartFile) {
        try{

            if(!s3.doesBucketExistV2(bucket)) {
                s3.createBucket(bucket);
            }

            String fileName = multiPartFile.getOriginalFilename();
            File file = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
            multiPartFile.transferTo(file);

            PutObjectRequest por = new PutObjectRequest(bucket, fileName, file);
            //if (isPublic) por.setCannedAcl(CannedAccessControlList.PublicRead);
            s3.putObject(por);
            return fileName;
        }catch (IllegalStateException | IOException exception){
            log.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public void deleteImage(String image) {
        s3.deleteObject(bucket, image);
    }



}
