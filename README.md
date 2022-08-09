# Dialpad-CustomView
Custom ViewGroup that lays out child views with equal distance.

## About
Same design could be handled by nesting LinearLayouts. 
However, CharityLayout can considerably improve that hierarchy into something more efficient.
Part of idea is taken from [CalculatorPadLayout](https://android.googlesource.com/platform/packages/apps/Calculator/+/marshmallow-mr3-release/src/com/android/calculator2/CalculatorPadLayout.java) and [BoxGridLayout](https://github.com/devunwired/custom-view-examples/blob/master/app/src/main/java/com/example/customview/widget/BoxGridLayout.java) open source projects. 
Other custom views can be built simply by using this Custom ViewGroup such as Dialpad.

## Screenshots
<p float="left">
  <img src="https://github.com/alirezaeiii/CharityLayout/blob/master/screenshots/screenshot1.png" width="250" />
  <img src="https://github.com/alirezaeiii/CharityLayout/blob/master/screenshots/screenshot2.png" width="250" />
  <img src="https://github.com/alirezaeiii/CharityLayout/blob/master/screenshots/screenshot3.png" width="250" />
  <img src="https://github.com/alirezaeiii/CharityLayout/blob/master/screenshots/screenshot4.gif" width="250" />
</p>

### Installation

Add the following to your `build.gradle`'s dependencies section:
```
implementation 'io.github.ali-rezaei:padLayout:1.1.1'
```

### Licence
    MIT License

    Copyright (c) 2015 Mohammadali Rezaei

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
