package com.training.java.grpc.validator.server.v2;

import com.training.java.grpc.validator.server.ValidatorServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servidor basado en el proyecto de java de grpc
 */
public class ValidatorServerV2 {

    private static final Logger logger = LoggerFactory.getLogger(ValidatorServerV2.class);

    private final int port;
    private final Server server;

    public ValidatorServerV2(int port) {
        this(port, ServerBuilder.forPort(port));
    }

    public ValidatorServerV2(int port, ServerBuilder<?> serverBuilder) {
        this.port = port;
        this.server = serverBuilder.addService(new ValidatorServiceImpl()).build();
    }

    /** Main method. */
    public static void main(String[] args) throws Exception {
        ValidatorServerV2 server = new ValidatorServerV2(50051);
        server.start();
        server.blockUntilShutdown();
    }

    /** Start serving requests. */
    public void start() throws IOException{
        server.start();
        logger.info("Servidor arrancado, escuchando en el puerto " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("Peticion de apagado recibida");
                if(server != null) {
                    server.shutdown();
                }
                System.out.println("Servidor apagado correctamente");
            }
        });
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

}
