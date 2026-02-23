public class PdfExporter extends Exporter {
    private static final int MAX_BODY_LENGTH = 20;

    public PdfExporter() {
        super(new PdfFormatStrategy());
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        if (req.body != null && req.body.length() > MAX_BODY_LENGTH) {
            return new ExportResult("PDF cannot handle content > 20 chars");
        }
        byte[] bytes = formatStrategy.encode(req);
        return new ExportResult("application/pdf", bytes);
    }
}
