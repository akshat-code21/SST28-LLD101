public abstract class Exporter {
    protected final FormatStrategy formatStrategy;

    protected Exporter(FormatStrategy strategy) {
        this.formatStrategy = strategy;
    }

    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            return new ExportResult("Request cannot be null");
        }
        return doExport(req);
    }

    protected abstract ExportResult doExport(ExportRequest req);
}
