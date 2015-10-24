# react-native-callintent

A React Native call intent for Android.

### Installation

```bash
npm install --save react-native-callintent
```

### Add it to your android project

* In `android/setting.gradle`

```gradle
...
include ':RNCallIntent', ':app'
project(':RNCallIntent').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-callintent')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':RNCallIntent')
}
```

* In app/src/main/AndroidManifest.xml add permission to use call

```xml
<uses-permission android:name="android.permission.CALL_PHONE" />
```

* register module (in MainActivity.java)

```java
import com.syarul.callintent.RNCallIntentPackage;;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new RNCallIntentPackage())              // <------ add here
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Example
```javascript
var CallIntent = require('react-native-callintent');

CallIntent.open('+60123049995');
```
## License

MIT
