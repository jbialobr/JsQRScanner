package jb.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.zxing.Result;
import com.google.zxing.web.ScannerWidget;

@Export
@ExportPackage("")
public class JsQRScanner
implements Exportable 
{   
    
    
    
    public JsQRScanner(AsyncQRCallback onSuccess)
    {
        ScannerCallback scannerCallback = new ScannerCallback(onSuccess);
        ScannerWidget scanner = new ScannerWidget(scannerCallback);
    }
    
    
    
//    public void appendTo(JavaScriptObject htmlElement)
//    {
//        addTo(htmlElement, getElement());
//        onAttach();
//    }
//    
//    public void removeFrom(JavaScriptObject htmlElement)
//    {
//        removeFrom(htmlElement, getElement());
//        onDetach();        
//    }
//
//    private static native double addTo(JavaScriptObject htmlElement, JavaScriptObject scannerElement) /*-{
//        htmlElement.appendChild(scannerElement);
//    }-*/;
//
//    private static native double removeFrom(JavaScriptObject htmlElement, JavaScriptObject scannerElement) /*-{
//        htmlElement.removeChild(scannerElement);
//    }-*/;
//
//    @Override
//    public void stopScanning()
//    {
//        super.stopScanning();
//    }
//
//    @Override
//    public void resumeScanning()
//    {
//        super.resumeScanning();
//    }
//
//    @Override
//    public int getScanInterval()
//    {
//        return super.getScanInterval();
//    }
//
//    @Override
//    public void setScanInterval(int scanInterval)
//    {
//        super.setScanInterval(scanInterval);
//    }
//
//    @Override
//    public int getSnapImageMaxSize()
//    {
//        return super.getSnapImageMaxSize();
//    }
//
//    @Override
//    public void setSnapImageMaxSize(int snapImageMaxSize)
//    {
//        super.setSnapImageMaxSize(snapImageMaxSize);
//    }
//
//    @Override
//    public boolean isActive()
//    {
//        return super.isActive();
//    }
//

    public boolean isScanning()
    {
        return false;// scanner.isScanning();
    }
    
    
}

class ScannerCallback implements AsyncCallback<Result>
{
    private AsyncQRCallback qrCallback;
    
    public ScannerCallback(AsyncQRCallback qrCallback)
    {
        super();
        this.qrCallback = qrCallback;
    }

    @Override
    public void onFailure(Throwable caught)
    {
    }

    @Override
    public void onSuccess(Result result)
    {
        qrCallback.execute(result.getText());
    }
}