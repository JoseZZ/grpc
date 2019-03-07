package com.training.java.grpc.validator.server;


import com.training.java.grpc.validator.generated.entity.greeting.GreetRequest;
import com.training.java.grpc.validator.generated.entity.greeting.GreetResponse;
import com.training.java.grpc.validator.generated.entity.greeting.Greeting;
import com.training.java.grpc.validator.generated.stub.greeting.GreetServiceGrpc.GreetServiceImplBase;
import io.grpc.stub.StreamObserver;

/**
 * @author <a href="changeme@ext.inditex.com">Jose Gonzalez</a>
 */
public class GreetServiceImpl extends GreetServiceImplBase {

    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        // Obtenemos la informacion de la peticion
        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();

        // Generamos la respuesta
        String result = "Hola " + firstName;
        GreetResponse response = GreetResponse.newBuilder().setResult(result).build();

        // Enviamos la respuesta
        responseObserver.onNext(response);
        // Finalizamos la llamada RPC
        responseObserver.onCompleted();
    }
}
