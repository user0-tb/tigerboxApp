package p011fi.iki.elonen;

import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import okhttp3.internal.http.HttpStatusCodesKt;
import p009j$.util.DesugarTimeZone;

/* renamed from: fi.iki.elonen.NanoHTTPD */
public abstract class NanoHTTPD {
    /* access modifiers changed from: private */
    public static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = Pattern.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
    private static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    /* access modifiers changed from: private */
    public static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile(CONTENT_DISPOSITION_REGEX, 2);
    private static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    /* access modifiers changed from: private */
    public static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile(CONTENT_TYPE_REGEX, 2);
    private static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";
    /* access modifiers changed from: private */
    public static final Logger LOG = Logger.getLogger(NanoHTTPD.class.getName());
    public static final String MIME_HTML = "text/html";
    public static final String MIME_PLAINTEXT = "text/plain";
    protected static Map<String, String> MIME_TYPES = null;
    private static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
    public static final int SOCKET_READ_TIMEOUT = 5000;
    protected AsyncRunner asyncRunner;
    /* access modifiers changed from: private */
    public final String hostname;
    /* access modifiers changed from: private */
    public final int myPort;
    /* access modifiers changed from: private */
    public volatile ServerSocket myServerSocket;
    private Thread myThread;
    private ServerSocketFactory serverSocketFactory;
    /* access modifiers changed from: private */
    public TempFileManagerFactory tempFileManagerFactory;

    /* renamed from: fi.iki.elonen.NanoHTTPD$AsyncRunner */
    public interface AsyncRunner {
        void closeAll();

        void closed(ClientHandler clientHandler);

        void exec(ClientHandler clientHandler);
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$IHTTPSession */
    public interface IHTTPSession {
        void execute() throws IOException;

        CookieHandler getCookies();

        Map<String, String> getHeaders();

        InputStream getInputStream();

        Method getMethod();

        Map<String, List<String>> getParameters();

        @Deprecated
        Map<String, String> getParms();

        String getQueryParameterString();

        String getRemoteHostName();

        String getRemoteIpAddress();

        String getUri();

        void parseBody(Map<String, String> map) throws IOException, ResponseException;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ServerSocketFactory */
    public interface ServerSocketFactory {
        ServerSocket create() throws IOException;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$TempFile */
    public interface TempFile {
        void delete() throws Exception;

        String getName();

        OutputStream open() throws Exception;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$TempFileManager */
    public interface TempFileManager {
        void clear();

        TempFile createTempFile(String str) throws Exception;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$TempFileManagerFactory */
    public interface TempFileManagerFactory {
        TempFileManager create();
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ClientHandler */
    public class ClientHandler implements Runnable {
        private final Socket acceptSocket;
        private final InputStream inputStream;

        public ClientHandler(InputStream inputStream2, Socket socket) {
            this.inputStream = inputStream2;
            this.acceptSocket = socket;
        }

        public void close() {
            NanoHTTPD.safeClose(this.inputStream);
            NanoHTTPD.safeClose(this.acceptSocket);
        }

        public void run() {
            OutputStream outputStream = null;
            try {
                outputStream = this.acceptSocket.getOutputStream();
                HTTPSession hTTPSession = new HTTPSession(NanoHTTPD.this.tempFileManagerFactory.create(), this.inputStream, outputStream, this.acceptSocket.getInetAddress());
                while (!this.acceptSocket.isClosed()) {
                    hTTPSession.execute();
                }
            } catch (Exception e) {
                if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                    NanoHTTPD.LOG.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e);
                }
            } catch (Throwable th) {
                NanoHTTPD.safeClose((Object) null);
                NanoHTTPD.safeClose(this.inputStream);
                NanoHTTPD.safeClose(this.acceptSocket);
                NanoHTTPD.this.asyncRunner.closed(this);
                throw th;
            }
            NanoHTTPD.safeClose(outputStream);
            NanoHTTPD.safeClose(this.inputStream);
            NanoHTTPD.safeClose(this.acceptSocket);
            NanoHTTPD.this.asyncRunner.closed(this);
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$Cookie */
    public static class Cookie {

        /* renamed from: e */
        private final String f541e;

        /* renamed from: n */
        private final String f542n;

        /* renamed from: v */
        private final String f543v;

        public static String getHTTPTime(int i) {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
            instance.add(5, i);
            return simpleDateFormat.format(instance.getTime());
        }

        public Cookie(String str, String str2) {
            this(str, str2, 30);
        }

        public Cookie(String str, String str2, int i) {
            this.f542n = str;
            this.f543v = str2;
            this.f541e = getHTTPTime(i);
        }

        public Cookie(String str, String str2, String str3) {
            this.f542n = str;
            this.f543v = str2;
            this.f541e = str3;
        }

        public String getHTTPHeader() {
            return String.format("%s=%s; expires=%s", new Object[]{this.f542n, this.f543v, this.f541e});
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$CookieHandler */
    public class CookieHandler implements Iterable<String> {
        private final HashMap<String, String> cookies = new HashMap<>();
        private final ArrayList<Cookie> queue = new ArrayList<>();

        public CookieHandler(Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String trim : str.split(";")) {
                    String[] split = trim.trim().split("=");
                    if (split.length == 2) {
                        this.cookies.put(split[0], split[1]);
                    }
                }
            }
        }

        public void delete(String str) {
            set(str, "-delete-", -30);
        }

        public Iterator<String> iterator() {
            return this.cookies.keySet().iterator();
        }

        public String read(String str) {
            return this.cookies.get(str);
        }

        public void set(Cookie cookie) {
            this.queue.add(cookie);
        }

        public void set(String str, String str2, int i) {
            this.queue.add(new Cookie(str, str2, Cookie.getHTTPTime(i)));
        }

        public void unloadQueue(Response response) {
            Iterator<Cookie> it = this.queue.iterator();
            while (it.hasNext()) {
                response.addHeader(HttpHeaders.SET_COOKIE, it.next().getHTTPHeader());
            }
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultAsyncRunner */
    public static class DefaultAsyncRunner implements AsyncRunner {
        private long requestCount;
        private final List<ClientHandler> running = Collections.synchronizedList(new ArrayList());

        public List<ClientHandler> getRunning() {
            return this.running;
        }

        public void closeAll() {
            Iterator it = new ArrayList(this.running).iterator();
            while (it.hasNext()) {
                ((ClientHandler) it.next()).close();
            }
        }

        public void closed(ClientHandler clientHandler) {
            this.running.remove(clientHandler);
        }

        public void exec(ClientHandler clientHandler) {
            this.requestCount++;
            Thread thread = new Thread(clientHandler);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.requestCount + ")");
            this.running.add(clientHandler);
            thread.start();
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultTempFile */
    public static class DefaultTempFile implements TempFile {
        private final File file;
        private final OutputStream fstream;

        public DefaultTempFile(File file2) throws IOException {
            File createTempFile = File.createTempFile("NanoHTTPD-", "", file2);
            this.file = createTempFile;
            this.fstream = new FileOutputStream(createTempFile);
        }

        public void delete() throws Exception {
            NanoHTTPD.safeClose(this.fstream);
            if (!this.file.delete()) {
                throw new Exception("could not delete temporary file: " + this.file.getAbsolutePath());
            }
        }

        public String getName() {
            return this.file.getAbsolutePath();
        }

        public OutputStream open() throws Exception {
            return this.fstream;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultTempFileManager */
    public static class DefaultTempFileManager implements TempFileManager {
        private final List<TempFile> tempFiles;
        private final File tmpdir;

        public DefaultTempFileManager() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.tmpdir = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.tempFiles = new ArrayList();
        }

        public void clear() {
            for (TempFile delete : this.tempFiles) {
                try {
                    delete.delete();
                } catch (Exception e) {
                    NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", e);
                }
            }
            this.tempFiles.clear();
        }

        public TempFile createTempFile(String str) throws Exception {
            DefaultTempFile defaultTempFile = new DefaultTempFile(this.tmpdir);
            this.tempFiles.add(defaultTempFile);
            return defaultTempFile;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultTempFileManagerFactory */
    private class DefaultTempFileManagerFactory implements TempFileManagerFactory {
        private DefaultTempFileManagerFactory() {
        }

        public TempFileManager create() {
            return new DefaultTempFileManager();
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultServerSocketFactory */
    public static class DefaultServerSocketFactory implements ServerSocketFactory {
        public ServerSocket create() throws IOException {
            return new ServerSocket();
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$SecureServerSocketFactory */
    public static class SecureServerSocketFactory implements ServerSocketFactory {
        private String[] sslProtocols;
        private SSLServerSocketFactory sslServerSocketFactory;

        public SecureServerSocketFactory(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
            this.sslServerSocketFactory = sSLServerSocketFactory;
            this.sslProtocols = strArr;
        }

        public ServerSocket create() throws IOException {
            SSLServerSocket sSLServerSocket = (SSLServerSocket) this.sslServerSocketFactory.createServerSocket();
            String[] strArr = this.sslProtocols;
            if (strArr != null) {
                sSLServerSocket.setEnabledProtocols(strArr);
            } else {
                sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
            }
            sSLServerSocket.setUseClientMode(false);
            sSLServerSocket.setWantClientAuth(false);
            sSLServerSocket.setNeedClientAuth(false);
            return sSLServerSocket;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ContentType */
    protected static class ContentType {
        private static final String ASCII_ENCODING = "US-ASCII";
        private static final Pattern BOUNDARY_PATTERN = Pattern.compile(BOUNDARY_REGEX, 2);
        private static final String BOUNDARY_REGEX = "[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";
        private static final Pattern CHARSET_PATTERN = Pattern.compile(CHARSET_REGEX, 2);
        private static final String CHARSET_REGEX = "[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";
        private static final String CONTENT_REGEX = "[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)";
        private static final Pattern MIME_PATTERN = Pattern.compile(CONTENT_REGEX, 2);
        private static final String MULTIPART_FORM_DATA_HEADER = "multipart/form-data";
        private final String boundary;
        private final String contentType;
        private final String contentTypeHeader;
        private final String encoding;

        public ContentType(String str) {
            this.contentTypeHeader = str;
            if (str != null) {
                this.contentType = getDetailFromContentHeader(str, MIME_PATTERN, "", 1);
                this.encoding = getDetailFromContentHeader(str, CHARSET_PATTERN, (String) null, 2);
            } else {
                this.contentType = "";
                this.encoding = "UTF-8";
            }
            if (MULTIPART_FORM_DATA_HEADER.equalsIgnoreCase(this.contentType)) {
                this.boundary = getDetailFromContentHeader(str, BOUNDARY_PATTERN, (String) null, 2);
            } else {
                this.boundary = null;
            }
        }

        private String getDetailFromContentHeader(String str, Pattern pattern, String str2, int i) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(i) : str2;
        }

        public String getContentTypeHeader() {
            return this.contentTypeHeader;
        }

        public String getContentType() {
            return this.contentType;
        }

        public String getEncoding() {
            String str = this.encoding;
            return str == null ? "US-ASCII" : str;
        }

        public String getBoundary() {
            return this.boundary;
        }

        public boolean isMultipart() {
            return MULTIPART_FORM_DATA_HEADER.equalsIgnoreCase(this.contentType);
        }

        public ContentType tryUTF8() {
            if (this.encoding != null) {
                return this;
            }
            return new ContentType(this.contentTypeHeader + "; charset=UTF-8");
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$HTTPSession */
    protected class HTTPSession implements IHTTPSession {
        public static final int BUFSIZE = 8192;
        public static final int MAX_HEADER_SIZE = 1024;
        private static final int MEMORY_STORE_LIMIT = 1024;
        private static final int REQUEST_BUFFER_LEN = 512;
        private CookieHandler cookies;
        private Map<String, String> headers;
        private final BufferedInputStream inputStream;
        private Method method;
        private final OutputStream outputStream;
        private Map<String, List<String>> parms;
        private String protocolVersion;
        private String queryParameterString;
        private String remoteHostname;
        private String remoteIp;
        private int rlen;
        private int splitbyte;
        private final TempFileManager tempFileManager;
        private String uri;

        public HTTPSession(TempFileManager tempFileManager2, InputStream inputStream2, OutputStream outputStream2) {
            this.tempFileManager = tempFileManager2;
            this.inputStream = new BufferedInputStream(inputStream2, 8192);
            this.outputStream = outputStream2;
        }

        public HTTPSession(TempFileManager tempFileManager2, InputStream inputStream2, OutputStream outputStream2, InetAddress inetAddress) {
            this.tempFileManager = tempFileManager2;
            this.inputStream = new BufferedInputStream(inputStream2, 8192);
            this.outputStream = outputStream2;
            this.remoteIp = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            this.remoteHostname = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "localhost" : inetAddress.getHostName().toString();
            this.headers = new HashMap();
        }

        private void decodeHeader(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) throws ResponseException {
            String str;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    if (stringTokenizer.hasMoreTokens()) {
                        map.put("method", stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            int indexOf = nextToken.indexOf(63);
                            if (indexOf >= 0) {
                                decodeParms(nextToken.substring(indexOf + 1), map2);
                                str = NanoHTTPD.decodePercent(nextToken.substring(0, indexOf));
                            } else {
                                str = NanoHTTPD.decodePercent(nextToken);
                            }
                            if (stringTokenizer.hasMoreTokens()) {
                                this.protocolVersion = stringTokenizer.nextToken();
                            } else {
                                this.protocolVersion = "HTTP/1.1";
                                NanoHTTPD.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                            }
                            String readLine2 = bufferedReader.readLine();
                            while (readLine2 != null && !readLine2.trim().isEmpty()) {
                                int indexOf2 = readLine2.indexOf(58);
                                if (indexOf2 >= 0) {
                                    map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                                }
                                readLine2 = bufferedReader.readLine();
                            }
                            map.put("uri", str);
                            return;
                        }
                        throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
            } catch (IOException e) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                throw new ResponseException(status, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
            }
        }

        private void decodeMultipartFormData(ContentType contentType, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) throws ResponseException {
            String str;
            ByteBuffer byteBuffer2 = byteBuffer;
            Map<String, List<String>> map3 = map;
            Map<String, String> map4 = map2;
            try {
                int[] boundaryPositions = getBoundaryPositions(byteBuffer2, contentType.getBoundary().getBytes());
                int i = 2;
                if (boundaryPositions.length >= 2) {
                    int i2 = 1024;
                    byte[] bArr = new byte[1024];
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        int i6 = 1;
                        if (i4 < boundaryPositions.length - 1) {
                            byteBuffer2.position(boundaryPositions[i4]);
                            int remaining = byteBuffer.remaining() < i2 ? byteBuffer.remaining() : 1024;
                            byteBuffer2.get(bArr, i3, remaining);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i3, remaining), Charset.forName(contentType.getEncoding())), remaining);
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.contains(contentType.getBoundary())) {
                                String readLine2 = bufferedReader.readLine();
                                String str2 = null;
                                String str3 = null;
                                String str4 = null;
                                int i7 = 2;
                                while (readLine2 != null && readLine2.trim().length() > 0) {
                                    Matcher matcher = NanoHTTPD.CONTENT_DISPOSITION_PATTERN.matcher(readLine2);
                                    if (matcher.matches()) {
                                        Matcher matcher2 = NanoHTTPD.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(i));
                                        while (matcher2.find()) {
                                            String group = matcher2.group(i6);
                                            if ("name".equalsIgnoreCase(group)) {
                                                str = matcher2.group(2);
                                            } else {
                                                if ("filename".equalsIgnoreCase(group)) {
                                                    String group2 = matcher2.group(2);
                                                    if (!group2.isEmpty()) {
                                                        if (i5 > 0) {
                                                            str = str2 + String.valueOf(i5);
                                                            str3 = group2;
                                                            i5++;
                                                        } else {
                                                            i5++;
                                                        }
                                                    }
                                                    str3 = group2;
                                                }
                                                i6 = 1;
                                            }
                                            str2 = str;
                                            i6 = 1;
                                        }
                                    }
                                    Matcher matcher3 = NanoHTTPD.CONTENT_TYPE_PATTERN.matcher(readLine2);
                                    if (matcher3.matches()) {
                                        str4 = matcher3.group(2).trim();
                                    }
                                    readLine2 = bufferedReader.readLine();
                                    i7++;
                                    i = 2;
                                    i6 = 1;
                                }
                                int i8 = 0;
                                while (true) {
                                    int i9 = i7 - 1;
                                    if (i7 <= 0) {
                                        break;
                                    }
                                    i8 = scipOverNewLine(bArr, i8);
                                    i7 = i9;
                                }
                                if (i8 < remaining - 4) {
                                    int i10 = boundaryPositions[i4] + i8;
                                    i4++;
                                    int i11 = boundaryPositions[i4] - 4;
                                    byteBuffer2.position(i10);
                                    List list = map3.get(str2);
                                    if (list == null) {
                                        list = new ArrayList();
                                        map3.put(str2, list);
                                    }
                                    if (str4 == null) {
                                        byte[] bArr2 = new byte[(i11 - i10)];
                                        byteBuffer2.get(bArr2);
                                        list.add(new String(bArr2, contentType.getEncoding()));
                                    } else {
                                        String saveTmpFile = saveTmpFile(byteBuffer2, i10, i11 - i10, str3);
                                        if (!map4.containsKey(str2)) {
                                            map4.put(str2, saveTmpFile);
                                        } else {
                                            int i12 = 2;
                                            while (true) {
                                                if (!map4.containsKey(str2 + i12)) {
                                                    break;
                                                }
                                                i12++;
                                            }
                                            map4.put(str2 + i12, saveTmpFile);
                                        }
                                        list.add(str3);
                                    }
                                    i2 = 1024;
                                    i = 2;
                                    i3 = 0;
                                } else {
                                    throw new ResponseException(Response.Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            } catch (ResponseException e) {
                throw e;
            } catch (Exception e2) {
                throw new ResponseException(Response.Status.INTERNAL_ERROR, e2.toString());
            }
        }

        private int scipOverNewLine(byte[] bArr, int i) {
            while (bArr[i] != 10) {
                i++;
            }
            return i + 1;
        }

        private void decodeParms(String str, Map<String, List<String>> map) {
            String str2;
            String str3;
            if (str == null) {
                this.queryParameterString = "";
                return;
            }
            this.queryParameterString = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    str3 = NanoHTTPD.decodePercent(nextToken.substring(0, indexOf)).trim();
                    str2 = NanoHTTPD.decodePercent(nextToken.substring(indexOf + 1));
                } else {
                    str3 = NanoHTTPD.decodePercent(nextToken).trim();
                    str2 = "";
                }
                List list = map.get(str3);
                if (list == null) {
                    list = new ArrayList();
                    map.put(str3, list);
                }
                list.add(str2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0173, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            p011fi.iki.elonen.NanoHTTPD.newFixedLengthResponse(r0.getStatus(), p011fi.iki.elonen.NanoHTTPD.MIME_PLAINTEXT, r0.getMessage()).send(r10.outputStream);
            p011fi.iki.elonen.NanoHTTPD.access$000(r10.outputStream);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x01e2, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01e3, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e4, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x01e5, code lost:
            throw r0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0173 A[ExcHandler: ResponseException (r0v14 'e' fi.iki.elonen.NanoHTTPD$ResponseException A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01e2 A[Catch:{ SSLException -> 0x016f, IOException -> 0x015f, SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, ResponseException -> 0x0173, SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173, all -> 0x0171 }, ExcHandler: SocketTimeoutException (r0v2 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:1:0x0009] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01e4 A[Catch:{ SSLException -> 0x016f, IOException -> 0x015f, SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, ResponseException -> 0x0173, SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173, all -> 0x0171 }, ExcHandler: SocketException (r0v1 'e' java.net.SocketException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:1:0x0009] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() throws java.io.IOException {
            /*
                r10 = this;
                java.lang.String r0 = "method"
                java.lang.String r1 = "NanoHttpd Shutdown"
                java.lang.String r2 = "text/plain"
                r3 = 8192(0x2000, float:1.14794E-41)
                r4 = 0
                byte[] r5 = new byte[r3]     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r6 = 0
                r10.splitbyte = r6     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.rlen = r6     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.BufferedInputStream r7 = r10.inputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r7.mark(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.BufferedInputStream r7 = r10.inputStream     // Catch:{ SSLException -> 0x016f, IOException -> 0x015f, SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, ResponseException -> 0x0173 }
                int r3 = r7.read(r5, r6, r3)     // Catch:{ SSLException -> 0x016f, IOException -> 0x015f, SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, ResponseException -> 0x0173 }
                r7 = -1
                if (r3 == r7) goto L_0x014f
            L_0x001e:
                if (r3 <= 0) goto L_0x0039
                int r7 = r10.rlen     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r7 + r3
                r10.rlen = r7     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r3 = r10.findHeaderEnd(r5, r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.splitbyte = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 <= 0) goto L_0x002e
                goto L_0x0039
            L_0x002e:
                java.io.BufferedInputStream r3 = r10.inputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r10.rlen     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r8 = 8192 - r7
                int r3 = r3.read(r5, r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                goto L_0x001e
            L_0x0039:
                int r3 = r10.splitbyte     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r10.rlen     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 >= r7) goto L_0x004c
                java.io.BufferedInputStream r3 = r10.inputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.reset()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.BufferedInputStream r3 = r10.inputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r7 = r10.splitbyte     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                long r7 = (long) r7     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.skip(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x004c:
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.parms = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.headers     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 != 0) goto L_0x005f
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.headers = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                goto L_0x0062
            L_0x005f:
                r3.clear()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0062:
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                int r9 = r10.rlen     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r8.<init>(r5, r6, r9)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r7.<init>(r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.<init>(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r5.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r10.parms     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r8 = r10.headers     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.decodeHeader(r3, r5, r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = r10.remoteIp     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 == 0) goto L_0x0093
                java.util.Map<java.lang.String, java.lang.String> r7 = r10.headers     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r8 = "remote-addr"
                r7.put(r8, r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.headers     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r7 = "http-client-ip"
                java.lang.String r8 = r10.remoteIp     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r3.put(r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0093:
                java.lang.Object r3 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Method r3 = p011fi.iki.elonen.NanoHTTPD.Method.lookup(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.method = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 == 0) goto L_0x012b
                java.lang.String r0 = "uri"
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.uri = r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$CookieHandler r0 = new fi.iki.elonen.NanoHTTPD$CookieHandler     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD r3 = p011fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r5 = r10.headers     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r5)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r10.cookies = r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.util.Map<java.lang.String, java.lang.String> r0 = r10.headers     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = "connection"
                java.lang.Object r0 = r0.get(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = "HTTP/1.1"
                java.lang.String r5 = r10.protocolVersion     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                boolean r3 = r3.equals(r5)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r5 = 1
                if (r3 == 0) goto L_0x00d7
                if (r0 == 0) goto L_0x00d5
                java.lang.String r3 = "(?i).*close.*"
                boolean r0 = r0.matches(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r0 != 0) goto L_0x00d7
            L_0x00d5:
                r0 = 1
                goto L_0x00d8
            L_0x00d7:
                r0 = 0
            L_0x00d8:
                fi.iki.elonen.NanoHTTPD r3 = p011fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Response r4 = r3.serve(r10)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r4 == 0) goto L_0x0121
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.headers     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r7 = "accept-encoding"
                java.lang.Object r3 = r3.get(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$CookieHandler r7 = r10.cookies     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r7.unloadQueue(r4)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Method r7 = r10.method     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r4.setRequestMethod(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD r7 = p011fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                boolean r7 = r7.useGzipWhenAccepted(r4)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r7 == 0) goto L_0x0107
                if (r3 == 0) goto L_0x0107
                java.lang.String r7 = "gzip"
                boolean r3 = r3.contains(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r3 == 0) goto L_0x0107
                r6 = 1
            L_0x0107:
                r4.setGzipEncoding(r6)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r4.setKeepAlive(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.OutputStream r3 = r10.outputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r4.send(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r0 == 0) goto L_0x011b
                boolean r0 = r4.isCloseConnection()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                if (r0 != 0) goto L_0x011b
                goto L_0x018a
            L_0x011b:
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0121:
                fi.iki.elonen.NanoHTTPD$ResponseException r0 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = p011fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r3 = "SERVER INTERNAL ERROR: Serve() returned a null response."
                r0.<init>(r1, r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x012b:
                fi.iki.elonen.NanoHTTPD$ResponseException r1 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                fi.iki.elonen.NanoHTTPD$Response$Status r3 = p011fi.iki.elonen.NanoHTTPD.Response.Status.BAD_REQUEST     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r6.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r7 = "BAD REQUEST: Syntax error. HTTP verb "
                r6.append(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r6.append(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = " unhandled."
                r6.append(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.lang.String r0 = r6.toString()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r1.<init>(r3, r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r1     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x014f:
                java.io.BufferedInputStream r0 = r10.inputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                p011fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.OutputStream r0 = r10.outputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                p011fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x015f:
                java.io.BufferedInputStream r0 = r10.inputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                p011fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.io.OutputStream r0 = r10.outputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                p011fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x016f:
                r0 = move-exception
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, ResponseException -> 0x0173 }
            L_0x0171:
                r0 = move-exception
                goto L_0x01e6
            L_0x0173:
                r0 = move-exception
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = r0.getStatus()     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD$Response r0 = p011fi.iki.elonen.NanoHTTPD.newFixedLengthResponse(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.outputStream     // Catch:{ all -> 0x0171 }
                r0.send(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.outputStream     // Catch:{ all -> 0x0171 }
                p011fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ all -> 0x0171 }
            L_0x018a:
                p011fi.iki.elonen.NanoHTTPD.safeClose(r4)
                fi.iki.elonen.NanoHTTPD$TempFileManager r0 = r10.tempFileManager
                r0.clear()
                goto L_0x01e1
            L_0x0193:
                r0 = move-exception
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = p011fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ all -> 0x0171 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
                r3.<init>()     // Catch:{ all -> 0x0171 }
                java.lang.String r5 = "SERVER INTERNAL ERROR: IOException: "
                r3.append(r5)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                r3.append(r0)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD$Response r0 = p011fi.iki.elonen.NanoHTTPD.newFixedLengthResponse(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.outputStream     // Catch:{ all -> 0x0171 }
                r0.send(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.outputStream     // Catch:{ all -> 0x0171 }
                p011fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ all -> 0x0171 }
                goto L_0x018a
            L_0x01ba:
                r0 = move-exception
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = p011fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ all -> 0x0171 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
                r3.<init>()     // Catch:{ all -> 0x0171 }
                java.lang.String r5 = "SSL PROTOCOL FAILURE: "
                r3.append(r5)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                r3.append(r0)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0171 }
                fi.iki.elonen.NanoHTTPD$Response r0 = p011fi.iki.elonen.NanoHTTPD.newFixedLengthResponse(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.outputStream     // Catch:{ all -> 0x0171 }
                r0.send(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.outputStream     // Catch:{ all -> 0x0171 }
                p011fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ all -> 0x0171 }
                goto L_0x018a
            L_0x01e1:
                return
            L_0x01e2:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0171 }
            L_0x01e4:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0171 }
            L_0x01e6:
                p011fi.iki.elonen.NanoHTTPD.safeClose(r4)
                fi.iki.elonen.NanoHTTPD$TempFileManager r1 = r10.tempFileManager
                r1.clear()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p011fi.iki.elonen.NanoHTTPD.HTTPSession.execute():void");
        }

        private int findHeaderEnd(byte[] bArr, int i) {
            int i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i4 >= i) {
                    return 0;
                }
                if (bArr[i3] == 13 && bArr[i4] == 10 && (i2 = i3 + 3) < i && bArr[i3 + 2] == 13 && bArr[i2] == 10) {
                    return i3 + 4;
                }
                if (bArr[i3] == 10 && bArr[i4] == 10) {
                    return i3 + 2;
                }
                i3 = i4;
            }
        }

        private int[] getBoundaryPositions(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            int length = bArr.length + 4096;
            byte[] bArr2 = new byte[length];
            int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
            byteBuffer.get(bArr2, 0, remaining);
            int length2 = remaining - bArr.length;
            int i = 0;
            do {
                int i2 = 0;
                while (i2 < length2) {
                    int i3 = 0;
                    while (i3 < bArr.length && bArr2[i2 + i3] == bArr[i3]) {
                        if (i3 == bArr.length - 1) {
                            int[] iArr2 = new int[(iArr.length + 1)];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i + i2;
                            iArr = iArr2;
                        }
                        i3++;
                    }
                    i2++;
                }
                i += length2;
                System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
                length2 = length - bArr.length;
                if (byteBuffer.remaining() < length2) {
                    length2 = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length2);
            } while (length2 > 0);
            return iArr;
        }

        public CookieHandler getCookies() {
            return this.cookies;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final InputStream getInputStream() {
            return this.inputStream;
        }

        public final Method getMethod() {
            return this.method;
        }

        @Deprecated
        public final Map<String, String> getParms() {
            HashMap hashMap = new HashMap();
            for (String next : this.parms.keySet()) {
                hashMap.put(next, this.parms.get(next).get(0));
            }
            return hashMap;
        }

        public final Map<String, List<String>> getParameters() {
            return this.parms;
        }

        public String getQueryParameterString() {
            return this.queryParameterString;
        }

        private RandomAccessFile getTmpBucket() {
            try {
                return new RandomAccessFile(this.tempFileManager.createTempFile((String) null).getName(), "rw");
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public final String getUri() {
            return this.uri;
        }

        public long getBodySize() {
            if (this.headers.containsKey("content-length")) {
                return Long.parseLong(this.headers.get("content-length"));
            }
            int i = this.splitbyte;
            int i2 = this.rlen;
            if (i < i2) {
                return (long) (i2 - i);
            }
            return 0;
        }

        public void parseBody(Map<String, String> map) throws IOException, ResponseException {
            DataOutputStream dataOutputStream;
            RandomAccessFile randomAccessFile;
            ByteArrayOutputStream byteArrayOutputStream;
            ByteBuffer byteBuffer;
            Map<String, String> map2 = map;
            RandomAccessFile randomAccessFile2 = null;
            try {
                long bodySize = getBodySize();
                if (bodySize < 1024) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    randomAccessFile = null;
                } else {
                    randomAccessFile = getTmpBucket();
                    byteArrayOutputStream = null;
                    dataOutputStream = randomAccessFile;
                }
                try {
                    byte[] bArr = new byte[512];
                    while (this.rlen >= 0 && bodySize > 0) {
                        int read = this.inputStream.read(bArr, 0, (int) Math.min(bodySize, 512));
                        this.rlen = read;
                        bodySize -= (long) read;
                        if (read > 0) {
                            dataOutputStream.write(bArr, 0, read);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteBuffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    } else {
                        byteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
                        randomAccessFile.seek(0);
                    }
                    if (Method.POST.equals(this.method)) {
                        ContentType contentType = new ContentType(this.headers.get("content-type"));
                        if (!contentType.isMultipart()) {
                            byte[] bArr2 = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bArr2);
                            String trim = new String(bArr2, contentType.getEncoding()).trim();
                            if ("application/x-www-form-urlencoded".equalsIgnoreCase(contentType.getContentType())) {
                                decodeParms(trim, this.parms);
                            } else if (trim.length() != 0) {
                                map2.put("postData", trim);
                            }
                        } else if (contentType.getBoundary() != null) {
                            decodeMultipartFormData(contentType, byteBuffer, this.parms, map2);
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                        }
                    } else if (Method.PUT.equals(this.method)) {
                        map2.put("content", saveTmpFile(byteBuffer, 0, byteBuffer.limit(), (String) null));
                    }
                    NanoHTTPD.safeClose(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    NanoHTTPD.safeClose(randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                NanoHTTPD.safeClose(randomAccessFile2);
                throw th;
            }
        }

        private String saveTmpFile(ByteBuffer byteBuffer, int i, int i2, String str) {
            if (i2 <= 0) {
                return "";
            }
            FileOutputStream fileOutputStream = null;
            try {
                TempFile createTempFile = this.tempFileManager.createTempFile(str);
                ByteBuffer duplicate = byteBuffer.duplicate();
                FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile.getName());
                try {
                    FileChannel channel = fileOutputStream2.getChannel();
                    duplicate.position(i).limit(i + i2);
                    channel.write(duplicate.slice());
                    String name = createTempFile.getName();
                    NanoHTTPD.safeClose(fileOutputStream2);
                    return name;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        throw new Error(e);
                    } catch (Throwable th) {
                        th = th;
                        NanoHTTPD.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    NanoHTTPD.safeClose(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                throw new Error(e);
            }
        }

        public String getRemoteIpAddress() {
            return this.remoteIp;
        }

        public String getRemoteHostName() {
            return this.remoteHostname;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$Method */
    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        static Method lookup(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$Response */
    public static class Response implements Closeable {
        private boolean chunkedTransfer;
        private long contentLength;
        private InputStream data;
        private boolean encodeAsGzip;
        private final Map<String, String> header = new HashMap<String, String>() {
            public String put(String str, String str2) {
                Response.this.lowerCaseHeader.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        };
        private boolean keepAlive;
        /* access modifiers changed from: private */
        public final Map<String, String> lowerCaseHeader = new HashMap();
        private String mimeType;
        private Method requestMethod;
        private IStatus status;

        /* renamed from: fi.iki.elonen.NanoHTTPD$Response$IStatus */
        public interface IStatus {
            String getDescription();

            int getRequestStatus();
        }

        /* renamed from: fi.iki.elonen.NanoHTTPD$Response$Status */
        public enum Status implements IStatus {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, "OK"),
            CREATED(HttpStatusCodesKt.HTTP_CREATED, "Created"),
            ACCEPTED(HttpStatusCodesKt.HTTP_ACCEPTED, "Accepted"),
            NO_CONTENT(HttpStatusCodesKt.HTTP_NO_CONTENT, "No Content"),
            PARTIAL_CONTENT(HttpStatusCodesKt.HTTP_PARTIAL_CONTENT, "Partial Content"),
            MULTI_STATUS(HttpStatusCodesKt.HTTP_MULTI_STATUS, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(307, "Temporary Redirect"),
            BAD_REQUEST(HttpStatusCodesKt.HTTP_BAD_REQUEST, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(HttpStatusCodesKt.HTTP_NOT_FOUND, "Not Found"),
            METHOD_NOT_ALLOWED(HttpStatusCodesKt.HTTP_BAD_METHOD, "Method Not Allowed"),
            NOT_ACCEPTABLE(HttpStatusCodesKt.HTTP_NOT_ACCEPTABLE, "Not Acceptable"),
            REQUEST_TIMEOUT(HttpStatusCodesKt.HTTP_CLIENT_TIMEOUT, "Request Timeout"),
            CONFLICT(HttpStatusCodesKt.HTTP_CONFLICT, "Conflict"),
            GONE(HttpStatusCodesKt.HTTP_GONE, "Gone"),
            LENGTH_REQUIRED(HttpStatusCodesKt.HTTP_LENGTH_REQUIRED, "Length Required"),
            PRECONDITION_FAILED(HttpStatusCodesKt.HTTP_PRECONDITION_FAILED, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(HttpStatusCodesKt.HTTP_REQUEST_TOO_LONG, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(HttpStatusCodesKt.HTTP_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(HttpStatusCodesKt.HTTP_EXPECTATION_FAILED, "Expectation Failed"),
            TOO_MANY_REQUESTS(HttpStatusCodesKt.HTTP_TOO_MANY_REQUESTS, "Too Many Requests"),
            INTERNAL_ERROR(HttpStatusCodesKt.HTTP_INTERNAL_SERVER_ERROR, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            private final String description;
            private final int requestStatus;

            private Status(int i, String str) {
                this.requestStatus = i;
                this.description = str;
            }

            public static Status lookup(int i) {
                for (Status status : values()) {
                    if (status.getRequestStatus() == i) {
                        return status;
                    }
                }
                return null;
            }

            public String getDescription() {
                return "" + this.requestStatus + " " + this.description;
            }

            public int getRequestStatus() {
                return this.requestStatus;
            }
        }

        /* renamed from: fi.iki.elonen.NanoHTTPD$Response$ChunkedOutputStream */
        private static class ChunkedOutputStream extends FilterOutputStream {
            public ChunkedOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (i2 != 0) {
                    this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i2)}).getBytes());
                    this.out.write(bArr, i, i2);
                    this.out.write("\r\n".getBytes());
                }
            }

            public void finish() throws IOException {
                this.out.write("0\r\n\r\n".getBytes());
            }
        }

        protected Response(IStatus iStatus, String str, InputStream inputStream, long j) {
            this.status = iStatus;
            this.mimeType = str;
            boolean z = false;
            if (inputStream == null) {
                this.data = new ByteArrayInputStream(new byte[0]);
                this.contentLength = 0;
            } else {
                this.data = inputStream;
                this.contentLength = j;
            }
            this.chunkedTransfer = this.contentLength < 0 ? true : z;
            this.keepAlive = true;
        }

        public void close() throws IOException {
            InputStream inputStream = this.data;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public void addHeader(String str, String str2) {
            this.header.put(str, str2);
        }

        public void closeConnection(boolean z) {
            if (z) {
                this.header.put("connection", "close");
            } else {
                this.header.remove("connection");
            }
        }

        public boolean isCloseConnection() {
            return "close".equals(getHeader("connection"));
        }

        public InputStream getData() {
            return this.data;
        }

        public String getHeader(String str) {
            return this.lowerCaseHeader.get(str.toLowerCase());
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public Method getRequestMethod() {
            return this.requestMethod;
        }

        public IStatus getStatus() {
            return this.status;
        }

        public void setGzipEncoding(boolean z) {
            this.encodeAsGzip = z;
        }

        public void setKeepAlive(boolean z) {
            this.keepAlive = z;
        }

        /* access modifiers changed from: protected */
        public void send(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
            try {
                if (this.status != null) {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, new ContentType(this.mimeType).getEncoding())), false);
                    printWriter.append("HTTP/1.1 ").append(this.status.getDescription()).append(" \r\n");
                    String str = this.mimeType;
                    if (str != null) {
                        printHeader(printWriter, "Content-Type", str);
                    }
                    if (getHeader("date") == null) {
                        printHeader(printWriter, "Date", simpleDateFormat.format(new Date()));
                    }
                    for (Map.Entry next : this.header.entrySet()) {
                        printHeader(printWriter, (String) next.getKey(), (String) next.getValue());
                    }
                    if (getHeader("connection") == null) {
                        printHeader(printWriter, "Connection", this.keepAlive ? "keep-alive" : "close");
                    }
                    if (getHeader("content-length") != null) {
                        this.encodeAsGzip = false;
                    }
                    if (this.encodeAsGzip) {
                        printHeader(printWriter, "Content-Encoding", "gzip");
                        setChunkedTransfer(true);
                    }
                    long j = this.data != null ? this.contentLength : 0;
                    if (this.requestMethod != Method.HEAD && this.chunkedTransfer) {
                        printHeader(printWriter, HttpHeaders.TRANSFER_ENCODING, "chunked");
                    } else if (!this.encodeAsGzip) {
                        j = sendContentLengthHeaderIfNotAlreadyPresent(printWriter, j);
                    }
                    printWriter.append("\r\n");
                    printWriter.flush();
                    sendBodyWithCorrectTransferAndEncoding(outputStream, j);
                    outputStream.flush();
                    NanoHTTPD.safeClose(this.data);
                    return;
                }
                throw new Error("sendResponse(): Status can't be null.");
            } catch (IOException e) {
                NanoHTTPD.LOG.log(Level.SEVERE, "Could not send response to the client", e);
            }
        }

        /* access modifiers changed from: protected */
        public void printHeader(PrintWriter printWriter, String str, String str2) {
            printWriter.append(str).append(": ").append(str2).append("\r\n");
        }

        /* access modifiers changed from: protected */
        public long sendContentLengthHeaderIfNotAlreadyPresent(PrintWriter printWriter, long j) {
            String header2 = getHeader("content-length");
            if (header2 != null) {
                try {
                    j = Long.parseLong(header2);
                } catch (NumberFormatException unused) {
                    Logger access$200 = NanoHTTPD.LOG;
                    access$200.severe("content-length was no number " + header2);
                }
            }
            printWriter.print("Content-Length: " + j + "\r\n");
            return j;
        }

        private void sendBodyWithCorrectTransferAndEncoding(OutputStream outputStream, long j) throws IOException {
            if (this.requestMethod == Method.HEAD || !this.chunkedTransfer) {
                sendBodyWithCorrectEncoding(outputStream, j);
                return;
            }
            ChunkedOutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
            sendBodyWithCorrectEncoding(chunkedOutputStream, -1);
            chunkedOutputStream.finish();
        }

        private void sendBodyWithCorrectEncoding(OutputStream outputStream, long j) throws IOException {
            if (this.encodeAsGzip) {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                sendBody(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            sendBody(outputStream, j);
        }

        private void sendBody(OutputStream outputStream, long j) throws IOException {
            long j2;
            byte[] bArr = new byte[((int) 16384)];
            boolean z = j == -1;
            while (true) {
                if (j > 0 || z) {
                    if (z) {
                        j2 = 16384;
                    } else {
                        j2 = Math.min(j, 16384);
                    }
                    int read = this.data.read(bArr, 0, (int) j2);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (!z) {
                            j -= (long) read;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public void setChunkedTransfer(boolean z) {
            this.chunkedTransfer = z;
        }

        public void setData(InputStream inputStream) {
            this.data = inputStream;
        }

        public void setMimeType(String str) {
            this.mimeType = str;
        }

        public void setRequestMethod(Method method) {
            this.requestMethod = method;
        }

        public void setStatus(IStatus iStatus) {
            this.status = iStatus;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ResponseException */
    public static final class ResponseException extends Exception {
        private static final long serialVersionUID = 6569838532917408380L;
        private final Response.Status status;

        public ResponseException(Response.Status status2, String str) {
            super(str);
            this.status = status2;
        }

        public ResponseException(Response.Status status2, String str, Exception exc) {
            super(str, exc);
            this.status = status2;
        }

        public Response.Status getStatus() {
            return this.status;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ServerRunnable */
    public class ServerRunnable implements Runnable {
        /* access modifiers changed from: private */
        public IOException bindException;
        /* access modifiers changed from: private */
        public boolean hasBinded = false;
        private final int timeout;

        public ServerRunnable(int i) {
            this.timeout = i;
        }

        public void run() {
            try {
                NanoHTTPD.this.myServerSocket.bind(NanoHTTPD.this.hostname != null ? new InetSocketAddress(NanoHTTPD.this.hostname, NanoHTTPD.this.myPort) : new InetSocketAddress(NanoHTTPD.this.myPort));
                this.hasBinded = true;
                do {
                    try {
                        Socket accept = NanoHTTPD.this.myServerSocket.accept();
                        int i = this.timeout;
                        if (i > 0) {
                            accept.setSoTimeout(i);
                        }
                        NanoHTTPD.this.asyncRunner.exec(NanoHTTPD.this.createClientHandler(accept, accept.getInputStream()));
                    } catch (IOException e) {
                        NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", e);
                    }
                } while (!NanoHTTPD.this.myServerSocket.isClosed());
            } catch (IOException e2) {
                this.bindException = e2;
            }
        }
    }

    public static Map<String, String> mimeTypes() {
        if (MIME_TYPES == null) {
            HashMap hashMap = new HashMap();
            MIME_TYPES = hashMap;
            loadMimeTypes(hashMap, "META-INF/nanohttpd/default-mimetypes.properties");
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
            if (MIME_TYPES.isEmpty()) {
                LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return MIME_TYPES;
    }

    private static void loadMimeTypes(Map<String, String> map, String str) {
        InputStream inputStream;
        try {
            Enumeration<URL> resources = NanoHTTPD.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Properties properties = new Properties();
                inputStream = null;
                try {
                    inputStream = nextElement.openStream();
                    properties.load(inputStream);
                } catch (IOException e) {
                    Logger logger = LOG;
                    Level level = Level.SEVERE;
                    logger.log(level, "could not load mimetypes from " + nextElement, e);
                }
                safeClose(inputStream);
                map.putAll(properties);
            }
        } catch (IOException unused) {
            Logger logger2 = LOG;
            Level level2 = Level.INFO;
            logger2.log(level2, "no mime types available at " + str);
        } catch (Throwable th) {
            safeClose(inputStream);
            throw th;
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManager[] keyManagerArr) throws IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(keyStore);
            SSLContext instance2 = SSLContext.getInstance("TLS");
            instance2.init(keyManagerArr, instance.getTrustManagers(), (SecureRandom) null);
            return instance2.getServerSocketFactory();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManagerFactory keyManagerFactory) throws IOException {
        try {
            return makeSSLSocketFactory(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String str, char[] cArr) throws IOException {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = NanoHTTPD.class.getResourceAsStream(str);
            if (resourceAsStream != null) {
                instance.load(resourceAsStream, cArr);
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, cArr);
                return makeSSLSocketFactory(instance, instance2);
            }
            throw new IOException("Unable to load keystore from classpath: " + str);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static String getMimeTypeForFile(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = lastIndexOf >= 0 ? mimeTypes().get(str.substring(lastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    /* access modifiers changed from: private */
    public static final void safeClose(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Could not close", e);
            }
        }
    }

    public NanoHTTPD(int i) {
        this((String) null, i);
    }

    public NanoHTTPD(String str, int i) {
        this.serverSocketFactory = new DefaultServerSocketFactory();
        this.hostname = str;
        this.myPort = i;
        setTempFileManagerFactory(new DefaultTempFileManagerFactory());
        setAsyncRunner(new DefaultAsyncRunner());
    }

    public synchronized void closeAllConnections() {
        stop();
    }

    /* access modifiers changed from: protected */
    public ClientHandler createClientHandler(Socket socket, InputStream inputStream) {
        return new ClientHandler(inputStream, socket);
    }

    /* access modifiers changed from: protected */
    public ServerRunnable createServerRunnable(int i) {
        return new ServerRunnable(i);
    }

    protected static Map<String, List<String>> decodeParameters(Map<String, String> map) {
        return decodeParameters(map.get(QUERY_STRING_PARAMETER));
    }

    protected static Map<String, List<String>> decodeParameters(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                String trim = (indexOf >= 0 ? decodePercent(nextToken.substring(0, indexOf)) : decodePercent(nextToken)).trim();
                if (!hashMap.containsKey(trim)) {
                    hashMap.put(trim, new ArrayList());
                }
                String decodePercent = indexOf >= 0 ? decodePercent(nextToken.substring(indexOf + 1)) : null;
                if (decodePercent != null) {
                    ((List) hashMap.get(trim)).add(decodePercent);
                }
            }
        }
        return hashMap;
    }

    protected static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.WARNING, "Encoding not supported, ignored", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean useGzipWhenAccepted(Response response) {
        return response.getMimeType() != null && (response.getMimeType().toLowerCase().contains("text/") || response.getMimeType().toLowerCase().contains("/json"));
    }

    public final int getListeningPort() {
        if (this.myServerSocket == null) {
            return -1;
        }
        return this.myServerSocket.getLocalPort();
    }

    public final boolean isAlive() {
        return wasStarted() && !this.myServerSocket.isClosed() && this.myThread.isAlive();
    }

    public ServerSocketFactory getServerSocketFactory() {
        return this.serverSocketFactory;
    }

    public void setServerSocketFactory(ServerSocketFactory serverSocketFactory2) {
        this.serverSocketFactory = serverSocketFactory2;
    }

    public String getHostname() {
        return this.hostname;
    }

    public TempFileManagerFactory getTempFileManagerFactory() {
        return this.tempFileManagerFactory;
    }

    public void makeSecure(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.serverSocketFactory = new SecureServerSocketFactory(sSLServerSocketFactory, strArr);
    }

    public static Response newChunkedResponse(Response.IStatus iStatus, String str, InputStream inputStream) {
        return new Response(iStatus, str, inputStream, -1);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, InputStream inputStream, long j) {
        return new Response(iStatus, str, inputStream, j);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, String str2) {
        byte[] bArr;
        ContentType contentType = new ContentType(str);
        if (str2 == null) {
            return newFixedLengthResponse(iStatus, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            if (!Charset.forName(contentType.getEncoding()).newEncoder().canEncode(str2)) {
                contentType = contentType.tryUTF8();
            }
            bArr = str2.getBytes(contentType.getEncoding());
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.SEVERE, "encoding problem, responding nothing", e);
            bArr = new byte[0];
        }
        return newFixedLengthResponse(iStatus, contentType.getContentTypeHeader(), new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    public static Response newFixedLengthResponse(String str) {
        return newFixedLengthResponse(Response.Status.OK, MIME_HTML, str);
    }

    public Response serve(IHTTPSession iHTTPSession) {
        HashMap hashMap = new HashMap();
        Method method = iHTTPSession.getMethod();
        if (Method.PUT.equals(method) || Method.POST.equals(method)) {
            try {
                iHTTPSession.parseBody(hashMap);
            } catch (IOException e) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                return newFixedLengthResponse(status, MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + e.getMessage());
            } catch (ResponseException e2) {
                return newFixedLengthResponse(e2.getStatus(), MIME_PLAINTEXT, e2.getMessage());
            }
        }
        Map<String, String> parms = iHTTPSession.getParms();
        parms.put(QUERY_STRING_PARAMETER, iHTTPSession.getQueryParameterString());
        return serve(iHTTPSession.getUri(), method, iHTTPSession.getHeaders(), parms, hashMap);
    }

    @Deprecated
    public Response serve(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
    }

    public void setAsyncRunner(AsyncRunner asyncRunner2) {
        this.asyncRunner = asyncRunner2;
    }

    public void setTempFileManagerFactory(TempFileManagerFactory tempFileManagerFactory2) {
        this.tempFileManagerFactory = tempFileManagerFactory2;
    }

    public void start() throws IOException {
        start(5000);
    }

    public void start(int i) throws IOException {
        start(i, true);
    }

    public void start(int i, boolean z) throws IOException {
        this.myServerSocket = getServerSocketFactory().create();
        this.myServerSocket.setReuseAddress(true);
        ServerRunnable createServerRunnable = createServerRunnable(i);
        Thread thread = new Thread(createServerRunnable);
        this.myThread = thread;
        thread.setDaemon(z);
        this.myThread.setName("NanoHttpd Main Listener");
        this.myThread.start();
        while (!createServerRunnable.hasBinded && createServerRunnable.bindException == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (createServerRunnable.bindException != null) {
            throw createServerRunnable.bindException;
        }
    }

    public void stop() {
        try {
            safeClose(this.myServerSocket);
            this.asyncRunner.closeAll();
            Thread thread = this.myThread;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Could not stop all connections", e);
        }
    }

    public final boolean wasStarted() {
        return (this.myServerSocket == null || this.myThread == null) ? false : true;
    }
}
