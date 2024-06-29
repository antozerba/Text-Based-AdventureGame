import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.File;
import java.nio.file.Paths;

public class Saving {
    private PropertiesConfiguration config = new PropertiesConfiguration("src/resources/application.properties");
    private String accessKeyId = config.getString("aws.access_key_id");
    private String secretAccessKey = config.getString("aws.secret_access_key");
    private String bucket = config.getString("aws.s3.bucket");
    private String regionName = config.getString("aws.s3.region");
    private String fileName = "upload.xml";
    private String filePath = "src/" + fileName;

    // Configure the AWS region
    private Region region = Region.of(regionName);

    // Create AWS credentials
    private AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

    // Create an S3 client
    private S3Client client = S3Client.builder()
            .region(region)
            .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
            .build();
    public Saving() throws ConfigurationException {}
    public void upload() throws ConfigurationException {
        // Create a put object request
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucket)
                .key(fileName)
                .build();

        // Upload the file to the specified S3 bucket
        client.putObject(request, RequestBody.fromFile(new File(filePath)));

        System.out.println("File uploaded successfully.");
        System.exit(0);
    }
    public void download(){
        String downloadFilePath = "src/download.xml";
        try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucket)
                    .key(fileName)
                    .build();

            // Scarica il file dall'S3 bucket
            GetObjectResponse response = client.getObject(getObjectRequest, Paths.get(downloadFilePath));

            System.out.println("File scaricato con successo: " + response);
        } catch (S3Exception e) {
            System.err.println("Errore durante il download del file: " + e.awsErrorDetails().errorMessage());
            System.out.println("ERROR");
        } finally {
            client.close();
        }

    }
}
