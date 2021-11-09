ViewBinding-ktx
=====

`ViewBinding-ktx` make easy to use ViewBinding.

[DataBinding-ktx](https://github.com/wada811/DataBinding-ktx) is here.

## Overview

- `ViewBinding-ktx` provides `withBinding` method accessing the `binding` variable by lambda.
- `ViewBinding-ktx` provides `viewBinding` method accessing the `binding` variable by delegated property.

## Usage

### Lambda

```kotlin
withBinding<ViewBindingActivityBinding> { binding ->

}
```

### Delegated Property

```kotlin
private val binding: ViewBindingActivityBinding by viewBinding() // reflection
private val binding by viewBinding { ViewBindingActivityBinding.bind(it) } // no reflection
```

Note:
In Fragment, When fragment's view is destroyed, an IllegalStateException is thrown on accessing the binding property.  
If you access the binding property when fragment's view may be destroyed, you must use the Lambda way above.

## Gradle

[![](https://jitpack.io/v/wada811/ViewBinding-ktx.svg)](https://jitpack.io/#wada811/ViewBinding-ktx)

```groovy
android {
    buildFeatures {
        viewBinding true
    }
}

repositories {
    maven { url "https://www.jitpack.io" }
}

dependencies {
    implementation 'com.github.wada811:ViewBinding-ktx:x.y.z'
}
```

## License

Copyright (C) 2020 wada811

Licensed under the Apache License, Version 2.0
