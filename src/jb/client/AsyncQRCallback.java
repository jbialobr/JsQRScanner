package jb.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

@Export
@ExportPackage("")
@ExportClosure
public interface AsyncQRCallback extends Exportable
{
    public void execute(String decodedText);
}
