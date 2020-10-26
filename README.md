ViewBinding-ktx
=====

`ViewBinding-ktx` make easy declaring ViewBinding.

[DataBinding-ktx](https://github.com/wada811/DataBinding-ktx) is here.

## Problems in ViewBinding
- Differences in the way of declaring a `binding` variable in Activity and Fragment.
    - In Activity, you can declare the `binding` variable using `by lazy`.
    - In Fragment, you can't declare the `binding` variable using `by lazy` because of recreating Fragment's view.
- Wasted memory unless you set the `binding` variable to null after onDestroyView
    - If you use Navigation component, BackStack or detach in Fragment, Fragment is still alive but Fragment's view is dead after onDestroyView.
      Because the `binding` variable has view tree, your app wasted memory.
      For saving memory, you should set the `binding` variable to null after onDestroyView.

## Overview
`ViewBinding-ktx`
- provides the unified way of declaring the `binding` variable
    - between Activity and Fragment.
    - between DataBinding-ktx and ViewBinding-ktx.
- is saving memory
    - The `binding` variable is stored as the Fragment's view's tag.
    - The `binding` variable is cleaning up along with the Fragment's view after onDestroyView.
- needs one of the following
    - calling `setContentView` in Activity and calling `inflater.inflate` in `onCreateView` of Fragment.
    - calling Activity/Fragment's secondary constructor passing layout res id.

## Usage

### Reflection

```kotlin
private val binding: ViewBindingActivityBinding by viewBinding()
```

### No reflection

```kotlin
private val binding by viewBinding { ViewBindingActivityBinding.bind(it) }
```

### Activity
- Use Activity's secondary constructor passing layout res id.
```kotlin
class ViewBindingActivity : AppCompatActivity(R.layout.view_binding_activity) {
    // Declare the `binding` variable using `by viewBinding()`.
    private val binding: ViewBindingActivityBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // You can use binding
    }
}
```

### Fragment
- Use Fragment's secondary constructor passing layout res id.
```kotlin
class ViewBindingFragment : Fragment(R.layout.view_binding_fragment) {
    // Declare the `binding` variable using `by viewBinding()`.
    private val binding: ViewBindingFragmentBinding by viewBinding()
    // DO NOT override onCreateView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // You can use binding
    }
}
```

## Gradle

[![](https://jitpack.io/v/wada811/ViewBinding-ktx.svg)](https://jitpack.io/#wada811/ViewBinding-ktx)

```groovy
android {
    buildFeatures {
        viewBinding = true
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
