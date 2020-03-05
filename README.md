
## Android Jumpstart Kotlin

With Android Jumpstart, we want to zero down the scaffolding time for Android apps. Most apps we
work on share the same boilerplate code, including
  * Declaring dependencies
  * Auto-increment version code - ToDo
  * Setting up [Retrofit](http://square.github.io/retrofit/) for API interaction
  * Setting up [Dagger](https://github.com/google/dagger) for dependency injection
  * Setting up common utility classes
  * Creating a mocking framework for testing- ToDo

Jumpstart takes care of all this, and more. Jumpstart adds support for many commonly used libraries,
  * [Retrofit](http://square.github.io/retrofit/)
  * [Timber](https://github.com/JakeWharton/timber)
  * ToDo- Add More

### Setting up

Setting up is really easy, there's a python script
[here](https://github.com/adg-delhi/JumpstartScript) that clones the Jumpstart repo, changes the
project name and package name. All the developer needs to after this is the update the API urls
and they have a base project ready.

### How to use

#### BaseActivity
Make your activities extend one of `BaseActivity`, `BaseToolbarActivity` or `BaseDrawerActivity`,
(all of which subclass `AppCompatActivity`) depending on your requirements. This gives you access
to the `APIService` which is injected into the BaseActivities.

```java
apiService.getSomeResource()
```

#### Setting up the Navigation Drawer
The BaseDrawerActivity handles the Navigation Drawer setup, and the DrawerActionToggle. You can
customize the drawer menu by modifying the file `nav_drawer_menu.xml`

#### Setting up the toolbar
The BaseToolbarActivity handles setting up the toolbar and the home as up button. Simply have your
classes extend this and there's no need to worry about the toolbar.

TODO Add information about FragmentTransactionHandler

#### BaseFragment
Similar to `BaseActivity`, extending `BaseFragment` gives you access to `apiService`.
#### APIProvider
The retrofit configuration is done here.

#### Build configurations
Jumpstart adds four build types by default, _debug_, _debugProd_, _release_, _releaseProd_. You
should configure these as per your requirements.