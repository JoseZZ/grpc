package com.training.java.grpc.validator.artifacts.stub;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: validator.proto")
public final class ValidationServiceGrpc {

  private ValidationServiceGrpc() {}

  public static final String SERVICE_NAME = "validator.ValidationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.training.java.grpc.validator.artifacts.entity.ValidationRequest,
      com.training.java.grpc.validator.artifacts.entity.ValidationResponse> getValidateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Validate",
      requestType = com.training.java.grpc.validator.artifacts.entity.ValidationRequest.class,
      responseType = com.training.java.grpc.validator.artifacts.entity.ValidationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.training.java.grpc.validator.artifacts.entity.ValidationRequest,
      com.training.java.grpc.validator.artifacts.entity.ValidationResponse> getValidateMethod() {
    io.grpc.MethodDescriptor<com.training.java.grpc.validator.artifacts.entity.ValidationRequest, com.training.java.grpc.validator.artifacts.entity.ValidationResponse> getValidateMethod;
    if ((getValidateMethod = ValidationServiceGrpc.getValidateMethod) == null) {
      synchronized (ValidationServiceGrpc.class) {
        if ((getValidateMethod = ValidationServiceGrpc.getValidateMethod) == null) {
          ValidationServiceGrpc.getValidateMethod = getValidateMethod = 
              io.grpc.MethodDescriptor.<com.training.java.grpc.validator.artifacts.entity.ValidationRequest, com.training.java.grpc.validator.artifacts.entity.ValidationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "validator.ValidationService", "Validate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.training.java.grpc.validator.artifacts.entity.ValidationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.training.java.grpc.validator.artifacts.entity.ValidationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ValidationServiceMethodDescriptorSupplier("Validate"))
                  .build();
          }
        }
     }
     return getValidateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ValidationServiceStub newStub(io.grpc.Channel channel) {
    return new ValidationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ValidationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ValidationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ValidationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ValidationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ValidationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Operacion unaria
     * </pre>
     */
    public void validate(com.training.java.grpc.validator.artifacts.entity.ValidationRequest request,
        io.grpc.stub.StreamObserver<com.training.java.grpc.validator.artifacts.entity.ValidationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getValidateMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getValidateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.training.java.grpc.validator.artifacts.entity.ValidationRequest,
                com.training.java.grpc.validator.artifacts.entity.ValidationResponse>(
                  this, METHODID_VALIDATE)))
          .build();
    }
  }

  /**
   */
  public static final class ValidationServiceStub extends io.grpc.stub.AbstractStub<ValidationServiceStub> {
    private ValidationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ValidationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ValidationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ValidationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Operacion unaria
     * </pre>
     */
    public void validate(com.training.java.grpc.validator.artifacts.entity.ValidationRequest request,
        io.grpc.stub.StreamObserver<com.training.java.grpc.validator.artifacts.entity.ValidationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ValidationServiceBlockingStub extends io.grpc.stub.AbstractStub<ValidationServiceBlockingStub> {
    private ValidationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ValidationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ValidationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ValidationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Operacion unaria
     * </pre>
     */
    public com.training.java.grpc.validator.artifacts.entity.ValidationResponse validate(com.training.java.grpc.validator.artifacts.entity.ValidationRequest request) {
      return blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ValidationServiceFutureStub extends io.grpc.stub.AbstractStub<ValidationServiceFutureStub> {
    private ValidationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ValidationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ValidationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ValidationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Operacion unaria
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.training.java.grpc.validator.artifacts.entity.ValidationResponse> validate(
        com.training.java.grpc.validator.artifacts.entity.ValidationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VALIDATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ValidationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ValidationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VALIDATE:
          serviceImpl.validate((com.training.java.grpc.validator.artifacts.entity.ValidationRequest) request,
              (io.grpc.stub.StreamObserver<com.training.java.grpc.validator.artifacts.entity.ValidationResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ValidationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ValidationServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.training.java.grpc.validator.artifacts.entity.Validator.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ValidationService");
    }
  }

  private static final class ValidationServiceFileDescriptorSupplier
      extends ValidationServiceBaseDescriptorSupplier {
    ValidationServiceFileDescriptorSupplier() {}
  }

  private static final class ValidationServiceMethodDescriptorSupplier
      extends ValidationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ValidationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ValidationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ValidationServiceFileDescriptorSupplier())
              .addMethod(getValidateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
