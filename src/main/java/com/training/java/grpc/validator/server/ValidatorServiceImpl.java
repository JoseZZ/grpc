package com.training.java.grpc.validator.server;


import com.training.java.grpc.validator.artifacts.entity.Validation;
import com.training.java.grpc.validator.artifacts.entity.ValidationRequest;
import com.training.java.grpc.validator.artifacts.entity.ValidationResponse;
import com.training.java.grpc.validator.artifacts.stub.ValidationServiceGrpc.ValidationServiceImplBase;
import io.grpc.stub.StreamObserver;

/**
 * @author <a href="changeme@ext.inditex.com">Jose Gonzalez</a>
 */
public class ValidatorServiceImpl extends ValidationServiceImplBase {

    public static final String MONACO_POSTAL_CODE = "98000";
    public static final String MONACO_PROVINCE = "Monaco";

    @Override
    public void validate(ValidationRequest request, StreamObserver<ValidationResponse> responseObserver) {
        // Obtenemos la informacion de la peticion
        Validation validation = request.getRequest();
        String postalCode = validation.getPostalCode();
        String province = validation.getProvince();

        // Generamos la respuesta
        ValidationResponse response;
        if(postalCode.equals(MONACO_POSTAL_CODE) && province.equals(MONACO_PROVINCE)){
            response = ValidationResponse.newBuilder().setResult(100).setPropuesta("").build();
        } else if (!postalCode.equals(MONACO_POSTAL_CODE) && province.equals(MONACO_PROVINCE)){
            response = ValidationResponse.newBuilder().setResult(0).setPropuesta("98000").build();
        } else {
            response = ValidationResponse.newBuilder().setResult(0).setPropuesta("Monaco").build();
        }
        // Enviamos la respuesta
        responseObserver.onNext(response);
        // Finalizamos la llamada RPC
        responseObserver.onCompleted();
    }
}
