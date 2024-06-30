/**
 * Classe addetta al salvataggio e al caricamento della partita di gioco nel bucket s3 di AWS tramite credenziale private gestite nel
 * file application.properties
 */

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
import java.nio.file.Path;
import java.nio.file.Paths;

public class Saving {
    private PropertiesConfiguration config = new PropertiesConfiguration("src/resources/application.properties");
    private String accessKeyId = config.getString("aws.access_key_id");
    private String secretAccessKey = config.getString("aws.secret_access_key");
    private String bucket = config.getString("aws.s3.bucket");
    private String regionName = config.getString("aws.s3.region");
    private String fileName = "upload.xml";
    private String filePath = "src/" + fileName;
    private Region region = Region.of(regionName);
    private AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

    /**
     *Creo il cliente S3
     */
    private S3Client client = S3Client.builder()
            .region(region)
            .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
            .build();

    /**
     * Costruttore
     * @throws ConfigurationException
     */
    public Saving() throws ConfigurationException {}

    /**
     * MMetodo per caricare il file dei dati di gicoco nel bucket S3
     * @throws ConfigurationException
     */
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

    /**
     * Metodo per saricare i dati della partita precedente dal bucket S3
     */
    public void download(){
        String downloadFilePath = "src/download.xml";
        try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucket)
                    .key(fileName)
                    .build();

            // Scarica il file dall'S3 bucket
            Path path = Paths.get(downloadFilePath);
            GetObjectResponse response = client.getObject(getObjectRequest, path);

            System.out.println("File scaricato con successo: " + response);
        } catch (S3Exception e) {
            System.err.println("Errore durante il download del file: " + e.awsErrorDetails().errorMessage());
            System.out.println("ERROR");
        } finally {
            client.close();
        }
    }

    /**
     * Setter del client
     * @param client
     */
    public void setClient(S3Client client) {
        this.client = client;
    }
    protected PropertiesConfiguration getConfig() {
        return config;
    }

    public void setConfig(PropertiesConfiguration config) {
        this.config = config;
    }

    protected S3Client createS3Client() {
        return client;
    }
}
