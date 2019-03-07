package com.training.java.grpc.greeting.client;


import com.training.java.grpc.greeting.generated.entity.greeting.GreetRequest;
import com.training.java.grpc.greeting.generated.entity.greeting.GreetResponse;
import com.training.java.grpc.greeting.generated.entity.greeting.Greeting;
import com.training.java.grpc.greeting.generated.stub.greeting.GreetServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Este es el cliente");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build();

        // Generamos nuestra peticion
        Greeting greeting = Greeting.newBuilder()
            .setFirstName("Juan")
            .setLastName("Nadie")
            .build();

        GreetRequest greetRequest = GreetRequest.newBuilder()
            .setGreeting(greeting)
            .build();

        // Creamos el stub
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);
        GreetResponse greetResponse = greetClient.greet(greetRequest);

        System.out.println(greetResponse.getResult());
    }
}
