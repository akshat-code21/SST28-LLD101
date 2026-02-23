public class JsonExporter extends Exporter {
    public JsonExporter() {
        super(new JsonFormatStrategy());
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        byte[] bytes = formatStrategy.encode(req);
        return new ExportResult("application/json", bytes);
    }
}
