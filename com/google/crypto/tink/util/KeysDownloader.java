package com.google.crypto.tink.util;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.Instant;

public class KeysDownloader {
    /* access modifiers changed from: private */
    public static final Executor DEFAULT_BACKGROUND_EXECUTOR = Executors.newCachedThreadPool();
    /* access modifiers changed from: private */
    public static final NetHttpTransport DEFAULT_HTTP_TRANSPORT = new NetHttpTransport.Builder().build();
    private static final Pattern MAX_AGE_PATTERN = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Executor backgroundExecutor;
    private long cacheExpirationDurationInMillis;
    private String cachedData;
    private long cachedTimeInMillis;
    /* access modifiers changed from: private */
    public final Object fetchDataLock = new Object();
    private final HttpTransport httpTransport;
    /* access modifiers changed from: private */
    public final Object instanceStateLock = new Object();
    /* access modifiers changed from: private */
    public Runnable pendingRefreshRunnable;
    private final String url;

    public KeysDownloader(Executor executor, HttpTransport httpTransport2, String str) {
        validate(str);
        this.backgroundExecutor = executor;
        this.httpTransport = httpTransport2;
        this.url = str;
        this.cachedTimeInMillis = Long.MIN_VALUE;
        this.cacheExpirationDurationInMillis = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r1 = r3.fetchDataLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = r3.instanceStateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        if (hasNonExpiredDataCached() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0023, code lost:
        r2 = r3.cachedData;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0027, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0 = fetchAndCacheData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x002d, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x002e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String download() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.instanceStateLock
            monitor-enter(r0)
            boolean r1 = r3.hasNonExpiredDataCached()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0016
            boolean r1 = r3.shouldProactivelyRefreshDataInBackground()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0012
            r3.refreshInBackground()     // Catch:{ all -> 0x0035 }
        L_0x0012:
            java.lang.String r1 = r3.cachedData     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r1
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r3.fetchDataLock
            monitor-enter(r1)
            java.lang.Object r0 = r3.instanceStateLock     // Catch:{ all -> 0x0032 }
            monitor-enter(r0)     // Catch:{ all -> 0x0032 }
            boolean r2 = r3.hasNonExpiredDataCached()     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x0028
            java.lang.String r2 = r3.cachedData     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r3.fetchAndCacheData()     // Catch:{ all -> 0x0032 }
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x002f:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r2     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            throw r0
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.util.KeysDownloader.download():java.lang.String");
    }

    public HttpTransport getHttpTransport() {
        return this.httpTransport;
    }

    public String getUrl() {
        return this.url;
    }

    private boolean hasNonExpiredDataCached() {
        long currentTimeInMillis = getCurrentTimeInMillis();
        long j = this.cachedTimeInMillis;
        boolean z = j > currentTimeInMillis;
        if ((j + this.cacheExpirationDurationInMillis <= currentTimeInMillis) || z) {
            return false;
        }
        return true;
    }

    private boolean shouldProactivelyRefreshDataInBackground() {
        return this.cachedTimeInMillis + (this.cacheExpirationDurationInMillis / 2) <= getCurrentTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public long getCurrentTimeInMillis() {
        return Instant.now().getMillis();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public String fetchAndCacheData() throws IOException {
        long currentTimeInMillis = getCurrentTimeInMillis();
        HttpResponse execute = this.httpTransport.createRequestFactory().buildGetRequest(new GenericUrl(this.url)).execute();
        if (execute.getStatusCode() == 200) {
            InputStream content = execute.getContent();
            try {
                String readerToString = readerToString(new InputStreamReader(content, UTF_8));
                content.close();
                synchronized (this.instanceStateLock) {
                    this.cachedTimeInMillis = currentTimeInMillis;
                    this.cacheExpirationDurationInMillis = getExpirationDurationInSeconds(execute.getHeaders()) * 1000;
                    this.cachedData = readerToString;
                }
                return readerToString;
            } catch (Throwable th) {
                content.close();
                throw th;
            }
        } else {
            throw new IOException("Unexpected status code = " + execute.getStatusCode());
        }
    }

    private static String readerToString(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read == -1) {
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    /* access modifiers changed from: package-private */
    public long getExpirationDurationInSeconds(HttpHeaders httpHeaders) {
        long j;
        if (httpHeaders.getCacheControl() != null) {
            String[] split = httpHeaders.getCacheControl().split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Matcher matcher = MAX_AGE_PATTERN.matcher(split[i]);
                if (matcher.matches()) {
                    j = Long.valueOf(matcher.group(1)).longValue();
                    break;
                }
                i++;
            }
        }
        j = 0;
        if (httpHeaders.getAge() != null) {
            j -= httpHeaders.getAge().longValue();
        }
        return Math.max(0, j);
    }

    public void refreshInBackground() {
        Runnable newRefreshRunnable = newRefreshRunnable();
        synchronized (this.instanceStateLock) {
            if (this.pendingRefreshRunnable == null) {
                this.pendingRefreshRunnable = newRefreshRunnable;
                try {
                    this.backgroundExecutor.execute(newRefreshRunnable);
                } catch (Throwable th) {
                    synchronized (this.instanceStateLock) {
                        if (this.pendingRefreshRunnable == newRefreshRunnable) {
                            this.pendingRefreshRunnable = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    private Runnable newRefreshRunnable() {
        return new Runnable() {
            /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                	at java.base/java.util.Objects.checkIndex(Objects.java:372)
                	at java.base/java.util.ArrayList.get(ArrayList.java:458)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
                	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                */
            public void run() {
                /*
                    r5 = this;
                    com.google.crypto.tink.util.KeysDownloader r0 = com.google.crypto.tink.util.KeysDownloader.this
                    java.lang.Object r0 = r0.fetchDataLock
                    monitor-enter(r0)
                    r1 = 0
                    com.google.crypto.tink.util.KeysDownloader r2 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ IOException -> 0x0040, all -> 0x0026 }
                    java.lang.String unused = r2.fetchAndCacheData()     // Catch:{ IOException -> 0x0040, all -> 0x0026 }
                    com.google.crypto.tink.util.KeysDownloader r2 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x005a }
                    java.lang.Object r2 = r2.instanceStateLock     // Catch:{ all -> 0x005a }
                    monitor-enter(r2)     // Catch:{ all -> 0x005a }
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x0023 }
                    java.lang.Runnable r3 = r3.pendingRefreshRunnable     // Catch:{ all -> 0x0023 }
                    if (r3 != r5) goto L_0x0021
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x0023 }
                    java.lang.Runnable unused = r3.pendingRefreshRunnable = r1     // Catch:{ all -> 0x0023 }
                L_0x0021:
                    monitor-exit(r2)     // Catch:{ all -> 0x0023 }
                    goto L_0x0055
                L_0x0023:
                    r1 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x005a }
                L_0x0026:
                    r2 = move-exception
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x005a }
                    java.lang.Object r3 = r3.instanceStateLock     // Catch:{ all -> 0x005a }
                    monitor-enter(r3)     // Catch:{ all -> 0x005a }
                    com.google.crypto.tink.util.KeysDownloader r4 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x003d }
                    java.lang.Runnable r4 = r4.pendingRefreshRunnable     // Catch:{ all -> 0x003d }
                    if (r4 != r5) goto L_0x003b
                    com.google.crypto.tink.util.KeysDownloader r4 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x003d }
                    java.lang.Runnable unused = r4.pendingRefreshRunnable = r1     // Catch:{ all -> 0x003d }
                L_0x003b:
                    monitor-exit(r3)     // Catch:{ all -> 0x003d }
                    throw r2     // Catch:{ all -> 0x005a }
                L_0x003d:
                    r1 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x003d }
                    throw r1     // Catch:{ all -> 0x005a }
                L_0x0040:
                    com.google.crypto.tink.util.KeysDownloader r2 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x005a }
                    java.lang.Object r2 = r2.instanceStateLock     // Catch:{ all -> 0x005a }
                    monitor-enter(r2)     // Catch:{ all -> 0x005a }
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x0057 }
                    java.lang.Runnable r3 = r3.pendingRefreshRunnable     // Catch:{ all -> 0x0057 }
                    if (r3 != r5) goto L_0x0054
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch:{ all -> 0x0057 }
                    java.lang.Runnable unused = r3.pendingRefreshRunnable = r1     // Catch:{ all -> 0x0057 }
                L_0x0054:
                    monitor-exit(r2)     // Catch:{ all -> 0x0057 }
                L_0x0055:
                    monitor-exit(r0)     // Catch:{ all -> 0x005a }
                    return
                L_0x0057:
                    r1 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0057 }
                    throw r1     // Catch:{ all -> 0x005a }
                L_0x005a:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x005a }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.util.KeysDownloader.C24371.run():void");
            }
        };
    }

    private static void validate(String str) {
        try {
            if (!new URL(str).getProtocol().toLowerCase(Locale.US).equals("https")) {
                throw new IllegalArgumentException("url must point to a HTTPS server");
            }
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static class Builder {
        private Executor executor = KeysDownloader.DEFAULT_BACKGROUND_EXECUTOR;
        private HttpTransport httpTransport = KeysDownloader.DEFAULT_HTTP_TRANSPORT;
        private String url;

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setExecutor(Executor executor2) {
            this.executor = executor2;
            return this;
        }

        public Builder setHttpTransport(HttpTransport httpTransport2) {
            this.httpTransport = httpTransport2;
            return this;
        }

        public KeysDownloader build() {
            if (this.url != null) {
                return new KeysDownloader(this.executor, this.httpTransport, this.url);
            }
            throw new IllegalArgumentException("must provide a url with {#setUrl}");
        }
    }
}
