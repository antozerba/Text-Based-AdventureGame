import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Path;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SavingTest {
    private S3Client mockS3Client;
    private PropertiesConfiguration mockConfig;
    private Saving saving;

    @BeforeEach
    void setUp() throws ConfigurationException {
        mockS3Client = Mockito.mock(S3Client.class);
        mockConfig = Mockito.mock(PropertiesConfiguration.class);
        saving = new Saving();
        saving.setConfig(mockConfig);
        saving.setClient(mockS3Client);
    }

    @Test
    void testUpload() throws ConfigurationException {
        // Mock the config to return the necessary values
        when(mockConfig.getString("aws.access_key_id")).thenReturn("accessKeyId");
        when(mockConfig.getString("aws.secret_access_key")).thenReturn("secretAccessKey");
        when(mockConfig.getString("aws.s3.bucket")).thenReturn("bucket");
        when(mockConfig.getString("aws.s3.region")).thenReturn("region");

        // Call the upload method
        saving.upload();

        // Verify that the putObject method was called on the mock S3 client
        verify(mockS3Client).putObject(Mockito.any(PutObjectRequest.class), Mockito.any(RequestBody.class));
    }

    @Test
    void testDownload() {
        // Mock the config to return the necessary values
        when(mockConfig.getString("aws.access_key_id")).thenReturn("accessKeyId");
        when(mockConfig.getString("aws.secret_access_key")).thenReturn("secretAccessKey");
        when(mockConfig.getString("aws.s3.bucket")).thenReturn("bucket");
        when(mockConfig.getString("aws.s3.region")).thenReturn("region");

        // Call the download method
        saving.download();

        // Verify that the getObject method was called on the mock S3 client
        verify(mockS3Client).getObject(Mockito.any(GetObjectRequest.class), Mockito.any(Path.class));
    }
}