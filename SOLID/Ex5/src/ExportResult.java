public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final String errorMessage;

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.errorMessage = null;
    }

    public ExportResult(String contentType, byte[] bytes, String errorMessage) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.errorMessage = errorMessage;
    }

    public ExportResult(String errorMessage) {
        this.bytes = new byte[0];
        this.contentType = null;
        this.errorMessage = errorMessage;
    }

    public boolean isError() {
        return errorMessage != null;
    }
}
