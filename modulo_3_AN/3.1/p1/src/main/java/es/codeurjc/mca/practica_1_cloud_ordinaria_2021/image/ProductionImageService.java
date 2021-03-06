package es.codeurjc.mca.practica_1_cloud_ordinaria_2021.image;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
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

    //@Value("${amazon.s3.bucket-name}")
    private String bucket = "j.escribanob2020-d.reyg2020.master.codeurjc.es";
    //@Value("${amazon.s3.endpoint}")
    private String endpoint = "https://s3.amazonaws.com/j.escribanob2020-d.reyg2020.master.codeurjc.es";
    //@Value("${amazon.s3.region}")
    private String region = "eu-west-1a";

    private Logger log = LoggerFactory.getLogger(ProductionImageService.class);

    public static AmazonS3 s3;




    public ProductionImageService() {
        s3 = AmazonS3ClientBuilder.standard().withRegion(region).build();
    }


    @Override
    public String createImage(MultipartFile multiPartFile) {
        try{
            String fileName = multiPartFile.getOriginalFilename();
            File file = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
            multiPartFile.transferTo(file);

            PutObjectRequest por = new PutObjectRequest(bucket, fileName, file);
            //if (isPublic) por.setCannedAcl(CannedAccessControlList.PublicRead);
            s3.putObject(por);
            return endpoint + fileName;
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
