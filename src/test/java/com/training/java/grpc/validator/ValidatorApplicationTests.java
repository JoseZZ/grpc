package com.training.java.grpc.validator;

import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import com.training.java.grpc.validator.artifacts.entity.Validation;
import com.training.java.grpc.validator.artifacts.entity.ValidationRequest;
import com.training.java.grpc.validator.artifacts.entity.ValidationResponse;
import com.training.java.grpc.validator.artifacts.stub.ValidationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorApplicationTests {

    ManagedChannel channel;
    ValidationServiceGrpc.ValidationServiceBlockingStub validationClient;

    @Before
    public void setup(){
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build();
        // Creamos el stub
        validationClient = ValidationServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void whenPostalCodeBelongsToMonacoAndAlsoProvince_thenResponseIsOKAndProposalIsNull() {
        // Generamos nuestra peticion
        Validation validation = Validation.newBuilder()
            .setPostalCode("98000")
            .setProvince("Monaco")
            .build();

        ValidationRequest validationRequest = ValidationRequest.newBuilder()
            .setRequest(validation)
            .build();

        ValidationResponse validationResponse = validationClient.validate(validationRequest);

        assertNotNull(validationResponse);
        assertEquals(100, validationResponse.getResult());
        assertThat(validationResponse.getPropuesta(), isEmptyString());
        assertEquals("", validationResponse.getPropuesta());
    }

    @Test
    public void whenPostalCodeNotBelongsToMonacoAndProvinceIsFromMonaco_thenResponseIsZeroAndProposalIsNotPostalCode(){
        // Generamos nuestra peticion
        Validation validation = Validation.newBuilder()
            .setPostalCode("91000")
            .setProvince("Monaco")
            .build();

        ValidationRequest validationRequest = ValidationRequest.newBuilder()
            .setRequest(validation)
            .build();

        ValidationResponse validationResponse = validationClient.validate(validationRequest);

        assertNotNull(validationResponse);
        assertEquals(0, validationResponse.getResult());
        assertEquals("98000", validationResponse.getPropuesta());
    }

    @Test
    public void whenPostalCodeBelongsToMonacoAndProvinceIsNotFromMonaco_thenResponseIsZeroAndProposalIsNotProvince(){
        // Generamos nuestra peticion
        Validation validation = Validation.newBuilder()
            .setPostalCode("98000")
            .setProvince("Teruel")
            .build();

        ValidationRequest validationRequest = ValidationRequest.newBuilder()
            .setRequest(validation)
            .build();

        ValidationResponse validationResponse = validationClient.validate(validationRequest);

        assertNotNull(validationResponse);
        assertEquals(0, validationResponse.getResult());
        assertEquals("Monaco", validationResponse.getPropuesta());
    }

}
