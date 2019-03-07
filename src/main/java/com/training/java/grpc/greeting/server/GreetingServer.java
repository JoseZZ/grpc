package com.training.java.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Arrancamos el servidor");
        // Creamos el servidor
        // Añadimos nuestro servicio
        Server server = ServerBuilder.forPort(50051)
            .addService(new GreetServiceImpl())
            .build();
        // Arrancarmos el servidor
        server.start();

        // Creamos un hock para apagar
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            System.out.println("Peticion de apagado recibida");
            server.shutdown();
            System.out.println("Servidor apagado correctamente");
        }));

        server.awaitTermination();
    }

}
