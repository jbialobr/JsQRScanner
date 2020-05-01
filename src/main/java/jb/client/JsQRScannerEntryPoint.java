package jb.client;

import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class JsQRScannerEntryPoint implements EntryPoint
{
    /**
     * This is the entry point method.
     */
    public void onModuleLoad()
    {
        ExporterUtil.exportAll();
        onReady();
    }
    
    private native void onReady() /*-{
      if ($wnd.JsQRScannerReady) $wnd.JsQRScannerReady();
    }-*/;
}
