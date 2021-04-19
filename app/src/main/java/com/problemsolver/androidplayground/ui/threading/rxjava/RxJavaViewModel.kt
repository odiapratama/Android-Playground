package com.problemsolver.androidplayground.ui.threading.rxjava

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class RxJavaViewModel : ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    private val _threadingState = MutableLiveData<String>()
    val threadingState: LiveData<String>
        get() = _threadingState

    val data = listOf("Test 1", "Test 2")

    fun rxCreate() {
        val observable = Observable.create(ObservableOnSubscribe<String> { emitter ->
            try {
                for (item in data) {
                    emitter.onNext(item)
                }
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        })

        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                _threadingState.postValue("onSubscribe")
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                _threadingState.postValue(t)
                println(t)
            }

            override fun onError(e: Throwable) {
                _threadingState.postValue(e.message)
                println(e.message)
            }

            override fun onComplete() {
                _threadingState.postValue("onComplete")
                println("onComplete")
            }
        }

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun rxDefer() {
        val deferData = DeferClass()
        deferData.setTextValue("Halo")
        deferData.valueObservable()
            .subscribe({
                _threadingState.postValue(it)
                println("Defer: $it")
            }, {
                _threadingState.postValue(it.message)
                print("Defer: ${it.message}")
            }).addTo(compositeDisposable)
    }

    class DeferClass {
        private var textValue: String = ""

        fun setTextValue(data: String) {
            textValue = data
        }

        fun valueObservable(): Observable<String> {
            return Observable.defer {
                Observable.just(textValue)
            }
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
        super.onCleared()
    }
}