# JsQRScanner

JavaScript QR Code scanner for HTML5 supporting browsers.
This library is based on the java implementation of the [zxing QR reader](https://github.com/zxing/zxing).
The library is automaticaly compiled by GWT from the original source with [few modifications](https://github.com/jbialobr/gwt-qrscanner) made to work with the html canvas element.
The export of the public api is made with the [gwt-exporter](https://github.com/manolo/gwt-exporter).

# Live demo

https://jsqrscanner.appspot.com

# How to use

1) Place all the files from the [js](https://github.com/jbialobr/JsQRScanner/blob/master/war/js/) directory on your server.

2) Add the [js script](https://github.com/jbialobr/JsQRScanner/blob/master/war/js/jsqrscanner.nocache.js) into your page.
```
<script type="text/javascript" src="/js/jsqrscanner.nocache.js"></script>
```
3) Create a scanner control and append it to the DOM.
```
  <script type="text/javascript">
    function onQRCodeScanned(scannedText)
    {
    	var scannedTextMemo = document.getElementById("scannedTextMemo");
    	if(scannedTextMemo)
    	{
    		scannedTextMemo.value = scannedText;
    	}
    }
  
    //this function will be called when JsQRScanner is ready to use
    function JsQRScannerReady()
    {
        //create a new scanner passing to it a callback function that will be invoked when
        //the scanner succesfully scan a QR code
        var jbScanner = new JsQRScanner(onQRCodeScanned);
        //reduce the size of analyzed image to increase performance on mobile devices
        jbScanner.setSnapImageMaxSize(300);
    	var scannerParentElement = document.getElementById("scanner");
    	if(scannerParentElement)
    	{
    	    //append the jbScanner to an existing DOM element
    		jbScanner.appendTo(scannerParentElement);
    	}        
    }
  </script> 
```
