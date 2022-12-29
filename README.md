ViewBinding-ktx
=====

`ViewBinding-ktx` make easy to use ViewBinding.

[DataBinding-ktx](https://github.com/wada811/DataBinding-ktx) is here.

## Overview

- `ViewBinding-ktx` provides `withBinding` method accessing the `binding` variable by lambda.
- [Deprecated] `ViewBinding-ktx` provides `viewBinding` method accessing the `binding` variable by delegated property.

## Usage

### Lambda

```kotlin
// no reflection
withBinding(ViewBindingActivityBinding::bind) { binding ->

}
// reflection
withBinding<ViewBindingActivityBinding> { binding ->

}
```

### Delegated Property

```kotlin
private val binding by viewBinding(ViewBindingActivityBinding::bind) // no reflection
private val binding: ViewBindingActivityBinding by viewBinding() // reflection
```

Note:
In Fragment, When fragment's view is destroyed, an IllegalStateException is thrown on accessing the binding property.  
If you access the binding property when fragment's view may be destroyed, you must use the Lambda way above.

## Gradle

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.wada811.viewbindingktx/viewbindingktx/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.wada811.viewbindingktx/viewbindingktx)

```groovy
android {
    buildFeatures {
        viewBinding true
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.wada811.viewbindingktx:viewbindingktx:x.y.z'
}
```

## Migrations

### 3.0.0

#### dependencies

```diff
-    implementation 'com.github.wada811:ViewBinding-ktx:x.y.z'
+    implementation 'com.wada811.viewbindingktx:viewbindingktx:x.y.z'
```

#### package

```diff
-import com.wada811.viewbinding
+import com.wada811.viewbindingktx
```

## License

Copyright (C) 2020 wada811

Licensed under the Apache License, Version 2.0
