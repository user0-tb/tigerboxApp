package com.google.crypto.tink.monitoring;

public interface MonitoringClient {

    public interface Logger {
        void log(int i, long j);

        void logFailure();
    }

    Logger createLogger(MonitoringKeysetInfo monitoringKeysetInfo, String str, String str2);
}
