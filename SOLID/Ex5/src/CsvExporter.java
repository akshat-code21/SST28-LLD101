public class CsvExporter extends Exporter {
    public CsvExporter() {
        super(new CsvFormatStrategy());
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        byte[] bytes = formatStrategy.encode(req);
        return new ExportResult("text/csv", bytes);
    }
}
