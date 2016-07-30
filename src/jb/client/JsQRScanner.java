package jb.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.zxing.Result;
import com.google.zxing.web.ScannerWidget;

@Export
@ExportPackage("")
public class JsQRScanner
implements Exportable 
{   
    private JSScannerWidget scanner;
    
    public JsQRScanner(AsyncQRCallback onSuccess)
    {
        scanner = new JSScannerWidget(onSuccess);
    }
     
    public void appendTo(JavaScriptObject htmlElement)
    {
        scanner.appendTo(htmlElement);
    }
    
    public void removeFrom(JavaScriptObject htmlElement)
    {
        scanner.removeFrom(htmlElement);
    }

    public void stopScanning()
    {
        scanner.stopScanning();
    }

    public void resumeScanning()
    {
        scanner.resumeScanning();
    }

    public int getScanInterval()
    {
        return scanner.getScanInterval();
    }

    public void setScanInterval(int scanInterval)
    {
        scanner.setScanInterval(scanInterval);
    }

    public int getSnapImageMaxSize()
    {
        return scanner.getSnapImageMaxSize();
    }

    public void setSnapImageMaxSize(int snapImageMaxSize)
    {
        scanner.setSnapImageMaxSize(snapImageMaxSize);
    }

    public boolean isActive()
    {
        return scanner.isActive();
    }

    public boolean isScanning()
    {
        return scanner.isScanning();
    }
}

class JSScannerWidget extends ScannerWidget
{
    public JSScannerWidget(AsyncQRCallback onSuccess)
    {
        super(new ScannerCallback(onSuccess));
    }
    
    public void appendTo(JavaScriptObject htmlElement)
    {
        addTo(htmlElement, getElement());
        onAttach();
    }
    
    public void removeFrom(JavaScriptObject htmlElement)
    {
        removeFrom(htmlElement, getElement());
        onDetach();        
    }

    private static native double addTo(JavaScriptObject htmlElement, JavaScriptObject scannerElement) /*-{
        htmlElement.appendChild(scannerElement);
    }-*/;

    private static native double removeFrom(JavaScriptObject htmlElement, JavaScriptObject scannerElement) /*-{
        htmlElement.removeChild(scannerElement);
    }-*/;
    
}

class ScannerCallback implements AsyncCallback<Result>
{
    private AsyncQRCallback qrCallback;
    
    public ScannerCallback(AsyncQRCallback qrCallback)
    {
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