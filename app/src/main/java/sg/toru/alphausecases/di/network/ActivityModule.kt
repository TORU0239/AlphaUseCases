package sg.toru.alphausecases.di.network

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun activityDependency(
        sub1Dep: ActivitySub1Dep,
        sub2Dep: ActivitySub2Dep
    ) = ActivityDependency(sub1Dep, sub2Dep)

    @Provides
    fun sub1Dep() = ActivitySub1Dep()

    @Provides
    fun sub2Dep() = ActivitySub2Dep()
}

@ActivityScoped
class ActivityDependency constructor(
    sub1Dep: ActivitySub1Dep,
    sub2Dep: ActivitySub2Dep
){
    init {
        Log.e("ActivityDependency", "created!")
        sub1Dep.test()
        sub2Dep.test()
    }

    fun test(){
        Log.e("ActivityDependency", "tested!")
    }
}

@ActivityScoped
class ActivitySub1Dep {
    init {
        Log.e("ActivitySub1Dep", "created!")
    }

    fun test() {
        Log.e("ActivitySub1Dep", "test!")
    }
}

@ActivityScoped
class ActivitySub2Dep {
    init {
        Log.e("ActivitySub2Dep", "created!")
    }

    fun test() {
        Log.e("ActivitySub2Dep", "test!")
    }
}