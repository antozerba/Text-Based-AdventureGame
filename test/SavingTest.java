import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import software.amazon.awssdk.services.s3.S3Client;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class SavingTest {
    private S3Client mockS3Client;
    private PropertiesConfiguration mockConfig;
    private Saving saving;

    @BeforeEach
    void setUp() throws ConfigurationException {
        mockS3Client = Mockito.mock(S3Client.class);
        mockConfig = Mockito.mock(PropertiesConfiguration.class);

        when(mockConfig.getString("aws.access_key_id")).thenReturn("testAccessKeyId");
        when(mockConfig.getString("aws.secret_access_key")).thenReturn("testSecretAccessKey");
        when(mockConfig.getString("aws.s3.bucket")).thenReturn("testBucket");
        when(mockConfig.getString("aws.s3.region")).thenReturn("us-west-2");

        try (MockedStatic<PropertiesConfiguration> mockedConfig = mockStatic(PropertiesConfiguration.class)) {
            mockedConfig.when(() -> new PropertiesConfiguration("src/resources/application.properties")).thenReturn(mockConfig);

            saving = new Saving();
            saving.setClient(mockS3Client); // Inject the mock S3Client
        }
    }

    @Test
    void testUpload() throws ConfigurationException {
        // Capture the PutObjectRequest and RequestBody passed to putObject method
        /*ArgumentCaptor<PutObjectRequest> putObjectRequestCaptor = ArgumentCaptor.forClass(PutObjectRequest.class);
        ArgumentCaptor<RequestBody> requestBodyCaptor = ArgumentCaptor.forClass(RequestBody.class);

        saving.upload();

        verify(mockS3Client, times(1)).putObject(putObjectRequestCaptor.capture(), requestBodyCaptor.capture());

        PutObjectRequest capturedRequest = putObjectRequestCaptor.getValue();
        RequestBody capturedRequestBody = requestBodyCaptor.getValue();

        assertEquals("testBucket", capturedRequest.bucket());
        assertEquals("upload.xml", capturedRequest.key());

        // Verify the content of RequestBody
        assertEquals(new File("src/upload.xml"), capturedRequestBody.contentAsFile().orElse(null));*/
    }
}
