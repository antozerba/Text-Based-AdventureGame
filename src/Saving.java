import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;

public class Saving {
    public Saving() throws ConfigurationException {
        save();
    }
    public void save() throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("src/application.properties");
        String accessKeyId = config.getString("aws.access_key_id");
        String secretAccessKey = config.getString("aws.secret_access_key");
        String bucket = config.getString("aws.s3.bucket");
        String regionName = config.getString("aws.s3.region");
        String fileName = "Ciao.txt";
        String filePath = "src/" + fileName;

        // Configure the AWS region
        Region region = Region.of(regionName);

        // Create AWS credentials
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        // Create an S3 client
        S3Client client = S3Client.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        // Create a put object request
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucket)
                .key(fileName)
                .build();

        // Upload the file to the specified S3 bucket
        client.putObject(request, RequestBody.fromFile(new File(filePath)));

        System.out.println("File uploaded successfully.");
    }
}
