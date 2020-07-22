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
- `ViewBinding-ktx` provide the unified way of declaring the `binding` variable in Activity and Fragment.
- `ViewBinding-ktx` is saving memory because of cleaning up the `binding` variable having the view tree after onDestroyView.
- `ViewBinding-ktx` needs one of the following
    - calling `setContentView` in Activity and calling `inflater.inflate` in `onCreateView` of Fragment.
    - calling Activity/Fragment's secondary constructor passing layout res id.

## Usage 
```kotlin
private val binding by viewBinding { ViewBindingActivityBinding.bind(it) }
```
### Activity
- Use Activity's secondary constructor passing layout res id.
```kotlin
class ViewBindingActivity : AppCompatActivity(R.layout.view_binding_activity) {
    // Declare the `binding` variable using `by viewBinding()`.
    private val binding by viewBinding(ViewBindingActivityBinding::bind)
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
    private val binding by viewBinding(ViewBindingFragmentBinding::bind)
    // DO NOT override onCreateView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // You can use binding
    }
}
```


## Note
### Activity
- If you forget to use Activity's secondary constructor passing layout res id, your app crash.

```kotlin
// You can define and use ViewBindingAppCompatActivity for not forgetting.
open class ViewBindingAppCompatActivity<T : ViewBinding>(@LayoutRes contentLayoutId: Int, bind: (View) -> T) : AppCompatActivity(contentLayoutId) {
    protected val binding by viewBinding(bind)
}

class YourActivity : ViewBindingAppCompatActivity<YourActivityBinding>(R.layout.your_activity, YourActivityBinding::bind) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // You can use binding
    }
}
```

### Fragment
- If you forget to use Fragment's secondary constructor passing layout res id, Fragment is not shown.

```kotlin
// You can define and use ViewBindingFragment for not forgetting.
open class ViewBindingFragment<T : ViewBinding>(@LayoutRes contentLayoutId : Int, bind: (View) -> T) : Fragment(contentLayoutId) {
    protected val binding: T by viewBinding(bind)
} 
class YourFragment : ViewBindingFragment<YourFragmentBinding>(R.layout.your_fragment) {
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
