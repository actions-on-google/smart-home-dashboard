package com.google.home.graph.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Google HomeGraph API. HomeGraph Service provides the support for storing
 * and querying first-party and third-party devices, rooms and structures,
 * the relationships among them and their state in the home. It stores
 * entities and their relationships in the home.
 * </pre>
 */
public final class HomeGraphApiServiceGrpc {

  private HomeGraphApiServiceGrpc() {}

  public static final String SERVICE_NAME = "google.home.graph.v1.HomeGraphApiService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRequestSyncDevicesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> METHOD_REQUEST_SYNC_DEVICES = getRequestSyncDevicesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> getRequestSyncDevicesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> getRequestSyncDevicesMethod() {
    return getRequestSyncDevicesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> getRequestSyncDevicesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> getRequestSyncDevicesMethod;
    if ((getRequestSyncDevicesMethod = HomeGraphApiServiceGrpc.getRequestSyncDevicesMethod) == null) {
      synchronized (HomeGraphApiServiceGrpc.class) {
        if ((getRequestSyncDevicesMethod = HomeGraphApiServiceGrpc.getRequestSyncDevicesMethod) == null) {
          HomeGraphApiServiceGrpc.getRequestSyncDevicesMethod = getRequestSyncDevicesMethod = 
              io.grpc.MethodDescriptor.<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.home.graph.v1.HomeGraphApiService", "RequestSyncDevices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HomeGraphApiServiceMethodDescriptorSupplier("RequestSyncDevices"))
                  .build();
          }
        }
     }
     return getRequestSyncDevicesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReportStateAndNotificationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> METHOD_REPORT_STATE_AND_NOTIFICATION = getReportStateAndNotificationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> getReportStateAndNotificationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> getReportStateAndNotificationMethod() {
    return getReportStateAndNotificationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> getReportStateAndNotificationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> getReportStateAndNotificationMethod;
    if ((getReportStateAndNotificationMethod = HomeGraphApiServiceGrpc.getReportStateAndNotificationMethod) == null) {
      synchronized (HomeGraphApiServiceGrpc.class) {
        if ((getReportStateAndNotificationMethod = HomeGraphApiServiceGrpc.getReportStateAndNotificationMethod) == null) {
          HomeGraphApiServiceGrpc.getReportStateAndNotificationMethod = getReportStateAndNotificationMethod = 
              io.grpc.MethodDescriptor.<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.home.graph.v1.HomeGraphApiService", "ReportStateAndNotification"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HomeGraphApiServiceMethodDescriptorSupplier("ReportStateAndNotification"))
                  .build();
          }
        }
     }
     return getReportStateAndNotificationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteAgentUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest,
      com.google.protobuf.Empty> METHOD_DELETE_AGENT_USER = getDeleteAgentUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest,
      com.google.protobuf.Empty> getDeleteAgentUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest,
      com.google.protobuf.Empty> getDeleteAgentUserMethod() {
    return getDeleteAgentUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest,
      com.google.protobuf.Empty> getDeleteAgentUserMethodHelper() {
    io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest, com.google.protobuf.Empty> getDeleteAgentUserMethod;
    if ((getDeleteAgentUserMethod = HomeGraphApiServiceGrpc.getDeleteAgentUserMethod) == null) {
      synchronized (HomeGraphApiServiceGrpc.class) {
        if ((getDeleteAgentUserMethod = HomeGraphApiServiceGrpc.getDeleteAgentUserMethod) == null) {
          HomeGraphApiServiceGrpc.getDeleteAgentUserMethod = getDeleteAgentUserMethod = 
              io.grpc.MethodDescriptor.<com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.home.graph.v1.HomeGraphApiService", "DeleteAgentUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new HomeGraphApiServiceMethodDescriptorSupplier("DeleteAgentUser"))
                  .build();
          }
        }
     }
     return getDeleteAgentUserMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getQueryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> METHOD_QUERY = getQueryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> getQueryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> getQueryMethod() {
    return getQueryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> getQueryMethodHelper() {
    io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> getQueryMethod;
    if ((getQueryMethod = HomeGraphApiServiceGrpc.getQueryMethod) == null) {
      synchronized (HomeGraphApiServiceGrpc.class) {
        if ((getQueryMethod = HomeGraphApiServiceGrpc.getQueryMethod) == null) {
          HomeGraphApiServiceGrpc.getQueryMethod = getQueryMethod = 
              io.grpc.MethodDescriptor.<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.home.graph.v1.HomeGraphApiService", "Query"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HomeGraphApiServiceMethodDescriptorSupplier("Query"))
                  .build();
          }
        }
     }
     return getQueryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSyncMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> METHOD_SYNC = getSyncMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> getSyncMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> getSyncMethod() {
    return getSyncMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest,
      com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> getSyncMethodHelper() {
    io.grpc.MethodDescriptor<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> getSyncMethod;
    if ((getSyncMethod = HomeGraphApiServiceGrpc.getSyncMethod) == null) {
      synchronized (HomeGraphApiServiceGrpc.class) {
        if ((getSyncMethod = HomeGraphApiServiceGrpc.getSyncMethod) == null) {
          HomeGraphApiServiceGrpc.getSyncMethod = getSyncMethod = 
              io.grpc.MethodDescriptor.<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest, com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.home.graph.v1.HomeGraphApiService", "Sync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HomeGraphApiServiceMethodDescriptorSupplier("Sync"))
                  .build();
          }
        }
     }
     return getSyncMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HomeGraphApiServiceStub newStub(io.grpc.Channel channel) {
    return new HomeGraphApiServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HomeGraphApiServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HomeGraphApiServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HomeGraphApiServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HomeGraphApiServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Google HomeGraph API. HomeGraph Service provides the support for storing
   * and querying first-party and third-party devices, rooms and structures,
   * the relationships among them and their state in the home. It stores
   * entities and their relationships in the home.
   * </pre>
   */
  public static abstract class HomeGraphApiServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Requests a Sync call from Google to a 3p partner's home control agent for
     * a user.
     * Third-party user's identity is passed in as agent_user_id.
     * (see [RequestSyncDevicesRequest][google.home.graph.v1.RequestSyncDevicesRequest]) and forwarded back to the agent.
     * Agent is identified by the API key or JWT signed by the partner's service
     * account.
     * </pre>
     */
    public void requestSyncDevices(com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestSyncDevicesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Reports device state and optionally sends device notifications. Called by
     * an agent when the device state of a third-party changes or the agent wants
     * to send a notification about the device.
     * This method updates a predefined set of States for a device, which all
     * devices have (for example a light will have OnOff, Color, Brightness).
     * A new State may not be created and an INVALID_ARGUMENT code will be thrown
     * if so. It also optionally takes in a list of Notifications that may be
     * created, which are associated to this State change.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * </pre>
     */
    public void reportStateAndNotification(com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReportStateAndNotificationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Unlink an agent user from Google. As result, all data related to this user
     * will be deleted.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * Note: Special characters (except "/") in agent_user_id must be URL encoded.
     * </pre>
     */
    public void deleteAgentUser(com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAgentUserMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the device states for the devices in QueryRequest.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public void query(com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets all the devices associated with the given third-party user.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public void sync(com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSyncMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestSyncDevicesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest,
                com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse>(
                  this, METHODID_REQUEST_SYNC_DEVICES)))
          .addMethod(
            getReportStateAndNotificationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest,
                com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse>(
                  this, METHODID_REPORT_STATE_AND_NOTIFICATION)))
          .addMethod(
            getDeleteAgentUserMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_AGENT_USER)))
          .addMethod(
            getQueryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest,
                com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse>(
                  this, METHODID_QUERY)))
          .addMethod(
            getSyncMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest,
                com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse>(
                  this, METHODID_SYNC)))
          .build();
    }
  }

  /**
   * <pre>
   * Google HomeGraph API. HomeGraph Service provides the support for storing
   * and querying first-party and third-party devices, rooms and structures,
   * the relationships among them and their state in the home. It stores
   * entities and their relationships in the home.
   * </pre>
   */
  public static final class HomeGraphApiServiceStub extends io.grpc.stub.AbstractStub<HomeGraphApiServiceStub> {
    private HomeGraphApiServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HomeGraphApiServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomeGraphApiServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HomeGraphApiServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Requests a Sync call from Google to a 3p partner's home control agent for
     * a user.
     * Third-party user's identity is passed in as agent_user_id.
     * (see [RequestSyncDevicesRequest][google.home.graph.v1.RequestSyncDevicesRequest]) and forwarded back to the agent.
     * Agent is identified by the API key or JWT signed by the partner's service
     * account.
     * </pre>
     */
    public void requestSyncDevices(com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestSyncDevicesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reports device state and optionally sends device notifications. Called by
     * an agent when the device state of a third-party changes or the agent wants
     * to send a notification about the device.
     * This method updates a predefined set of States for a device, which all
     * devices have (for example a light will have OnOff, Color, Brightness).
     * A new State may not be created and an INVALID_ARGUMENT code will be thrown
     * if so. It also optionally takes in a list of Notifications that may be
     * created, which are associated to this State change.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * </pre>
     */
    public void reportStateAndNotification(com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportStateAndNotificationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unlink an agent user from Google. As result, all data related to this user
     * will be deleted.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * Note: Special characters (except "/") in agent_user_id must be URL encoded.
     * </pre>
     */
    public void deleteAgentUser(com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAgentUserMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the device states for the devices in QueryRequest.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public void query(com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets all the devices associated with the given third-party user.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public void sync(com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest request,
        io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSyncMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Google HomeGraph API. HomeGraph Service provides the support for storing
   * and querying first-party and third-party devices, rooms and structures,
   * the relationships among them and their state in the home. It stores
   * entities and their relationships in the home.
   * </pre>
   */
  public static final class HomeGraphApiServiceBlockingStub extends io.grpc.stub.AbstractStub<HomeGraphApiServiceBlockingStub> {
    private HomeGraphApiServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HomeGraphApiServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomeGraphApiServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HomeGraphApiServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Requests a Sync call from Google to a 3p partner's home control agent for
     * a user.
     * Third-party user's identity is passed in as agent_user_id.
     * (see [RequestSyncDevicesRequest][google.home.graph.v1.RequestSyncDevicesRequest]) and forwarded back to the agent.
     * Agent is identified by the API key or JWT signed by the partner's service
     * account.
     * </pre>
     */
    public com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse requestSyncDevices(com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestSyncDevicesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reports device state and optionally sends device notifications. Called by
     * an agent when the device state of a third-party changes or the agent wants
     * to send a notification about the device.
     * This method updates a predefined set of States for a device, which all
     * devices have (for example a light will have OnOff, Color, Brightness).
     * A new State may not be created and an INVALID_ARGUMENT code will be thrown
     * if so. It also optionally takes in a list of Notifications that may be
     * created, which are associated to this State change.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * </pre>
     */
    public com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse reportStateAndNotification(com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest request) {
      return blockingUnaryCall(
          getChannel(), getReportStateAndNotificationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unlink an agent user from Google. As result, all data related to this user
     * will be deleted.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * Note: Special characters (except "/") in agent_user_id must be URL encoded.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAgentUser(com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAgentUserMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the device states for the devices in QueryRequest.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse query(com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets all the devices associated with the given third-party user.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse sync(com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest request) {
      return blockingUnaryCall(
          getChannel(), getSyncMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Google HomeGraph API. HomeGraph Service provides the support for storing
   * and querying first-party and third-party devices, rooms and structures,
   * the relationships among them and their state in the home. It stores
   * entities and their relationships in the home.
   * </pre>
   */
  public static final class HomeGraphApiServiceFutureStub extends io.grpc.stub.AbstractStub<HomeGraphApiServiceFutureStub> {
    private HomeGraphApiServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HomeGraphApiServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HomeGraphApiServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HomeGraphApiServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Requests a Sync call from Google to a 3p partner's home control agent for
     * a user.
     * Third-party user's identity is passed in as agent_user_id.
     * (see [RequestSyncDevicesRequest][google.home.graph.v1.RequestSyncDevicesRequest]) and forwarded back to the agent.
     * Agent is identified by the API key or JWT signed by the partner's service
     * account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse> requestSyncDevices(
        com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestSyncDevicesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reports device state and optionally sends device notifications. Called by
     * an agent when the device state of a third-party changes or the agent wants
     * to send a notification about the device.
     * This method updates a predefined set of States for a device, which all
     * devices have (for example a light will have OnOff, Color, Brightness).
     * A new State may not be created and an INVALID_ARGUMENT code will be thrown
     * if so. It also optionally takes in a list of Notifications that may be
     * created, which are associated to this State change.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse> reportStateAndNotification(
        com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReportStateAndNotificationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unlink an agent user from Google. As result, all data related to this user
     * will be deleted.
     * Third-party user's identity is passed in as agent_user_id.
     * Agent is identified by the JWT signed by the partner's service account.
     * Note: Special characters (except "/") in agent_user_id must be URL encoded.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAgentUser(
        com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAgentUserMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the device states for the devices in QueryRequest.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse> query(
        com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets all the devices associated with the given third-party user.
     * Third-party user's identity is passed in as agent_user_id. Agent is
     * identified by the JWT signed by the third-party partner's service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse> sync(
        com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSyncMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_SYNC_DEVICES = 0;
  private static final int METHODID_REPORT_STATE_AND_NOTIFICATION = 1;
  private static final int METHODID_DELETE_AGENT_USER = 2;
  private static final int METHODID_QUERY = 3;
  private static final int METHODID_SYNC = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HomeGraphApiServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HomeGraphApiServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_SYNC_DEVICES:
          serviceImpl.requestSyncDevices((com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.RequestSyncDevicesResponse>) responseObserver);
          break;
        case METHODID_REPORT_STATE_AND_NOTIFICATION:
          serviceImpl.reportStateAndNotification((com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.ReportStateAndNotificationResponse>) responseObserver);
          break;
        case METHODID_DELETE_AGENT_USER:
          serviceImpl.deleteAgentUser((com.google.home.graph.v1.HomeGraphApiServiceProto.DeleteAgentUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_QUERY:
          serviceImpl.query((com.google.home.graph.v1.HomeGraphApiServiceProto.QueryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.QueryResponse>) responseObserver);
          break;
        case METHODID_SYNC:
          serviceImpl.sync((com.google.home.graph.v1.HomeGraphApiServiceProto.SyncRequest) request,
              (io.grpc.stub.StreamObserver<com.google.home.graph.v1.HomeGraphApiServiceProto.SyncResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HomeGraphApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HomeGraphApiServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.home.graph.v1.HomeGraphApiServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HomeGraphApiService");
    }
  }

  private static final class HomeGraphApiServiceFileDescriptorSupplier
      extends HomeGraphApiServiceBaseDescriptorSupplier {
    HomeGraphApiServiceFileDescriptorSupplier() {}
  }

  private static final class HomeGraphApiServiceMethodDescriptorSupplier
      extends HomeGraphApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HomeGraphApiServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HomeGraphApiServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HomeGraphApiServiceFileDescriptorSupplier())
              .addMethod(getRequestSyncDevicesMethodHelper())
              .addMethod(getReportStateAndNotificationMethodHelper())
              .addMethod(getDeleteAgentUserMethodHelper())
              .addMethod(getQueryMethodHelper())
              .addMethod(getSyncMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
