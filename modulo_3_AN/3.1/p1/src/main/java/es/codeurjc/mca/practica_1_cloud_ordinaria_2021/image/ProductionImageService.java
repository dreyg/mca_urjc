package es.codeurjc.mca.practica_1_cloud_ordinaria_2021.image;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("storageService")
@Profile("production")
public class ProductionImageService implements ImageService {

    public static AmazonS3 s3;


    @Value("${amazon.s3.bucket}")
    private String bucket;
    @Value("${amazon.s3.endpoint}")
    private String endpoint;
    @Value("${amazon.s3.region}")
    private String region;

    public ProductionImageService() {
        s3 = AmazonS3ClientBuilder.standard().withRegion(region).build();
    }


    @Override
    public String createImage(MultipartFile multiPartFile) throws IllegalStateException, IOException {
        String fileName = multiPartFile.getOriginalFilename();
        File file = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multiPartFile.transferTo(file);

        PutObjectRequest por = new PutObjectRequest(bucket, fileName, file);
        //if (isPublic) por.setCannedAcl(CannedAccessControlList.PublicRead);
        s3.putObject(por);
        return null;
    }

    @Override
    public void deleteImage(String image) {
        s3.deleteObject(bucket, image);
    }


    
}
