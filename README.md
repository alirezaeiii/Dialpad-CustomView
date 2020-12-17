# CharityLayout
Custom ViewGroup that lays out child views with equal distance.

## About
Same design could be handled by nesting LinearLayouts. 
However, CharityLayout can considerably improve that hierarchy into something more efficient.
Part of idea is taken from [CalculatorPadLayout](https://android.googlesource.com/platform/packages/apps/Calculator/+/marshmallow-mr3-release/src/com/android/calculator2/CalculatorPadLayout.java) and [BoxGridLayout](https://github.com/devunwired/custom-view-examples/blob/master/app/src/main/java/com/example/customview/widget/BoxGridLayout.java) open source projects. 
Other custom views can be built simply by using this Custom ViewGroup such as Dialpad.

### Installation

Add the following to your `build.gradle`'s dependencies section:
```
implementation 'io.github.ali-rezaei:padLayout:1.1.1'
```
