# JsQRScanner

JavaScript QR Code scanner for HTML5 supporting browsers.
This library is based on the java implementation of the [zxing QR reader](https://github.com/zxing/zxing).
The library is automaticaly compiled by GWT from the original source with [few modifications](https://github.com/jbialobr/gwt-qrscanner) made to work with the html canvas element.
The export of the public api is made with the [gwt-exporter](https://github.com/manolo/gwt-exporter).

# Live demo

https://jbialobr.github.io/JsQRScanner/

[Treasure Hunt Game Creator using QR codes to encode clues](https://treasurehuntqr.appspot.com/treasurehunts/play/5657382461898752?at=106253815718623556511956012583&au=5629499534213120)

# How to use

1) Place all the files from the [js](https://github.com/jbialobr/JsQRScanner/blob/master/war/js/) directory on your server.

2) Add the [js script](https://github.com/jbialobr/JsQRScanner/blob/master/war/js/jsqrscanner.nocache.js) into your page.
```html
<script type="text/javascript" src="/js/jsqrscanner.nocache.js"></script>
```
3) Create a scanner control and append it to the DOM.
```js
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
        //reduce the size of analyzed images to increase performance on mobile devices
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

# Scanner API

**.appendTo( htmlElement )**

Appends the scanner to the given **htmlElement**

**.removeFrom( htmlElement )**

Removes the scanner from the given **htmlElement**
Does nothing If the scanner is not a child of **htmlElement**

**.stopScanning()**

Stops the scanner.

**.resumeScanning()**

Resumes the previously stopped scanner.

**.setScanInterval( scanIntervalMilliseconds )**

Sets the interval at which the scanner attempts to decode a qr code.

**.getScanInterval()**

Returns the interval at which the scanner attempts to decode a qr code.
The interval is returned in milliseconds.

**.setSnapImageMaxSize( snapImageMaxSizeInPixels )**

Sets the maximum size of images captured from the webcam.
The limit is applied to both width and height. The ratio of the image is preserved
while resizing. Smaller sizes, like 300px can be set to increase performance on
mobile devices.

**.getSnapImageMaxSize()**

Returns the SnapImageMaxSize in pixels.

**.isActive()**

Returns false if scanner was stoped, true otherwise.

**.isScanning()**

Returns true if scanner is actively scanning.
That is the scanner is active and is attached to the DOM.
